package edu.cpp.hci.scrapers.rmp;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.cpp.hci.scrapers.WebScraper;
import edu.cpp.hci.scrapers.constants.School;
import edu.cpp.hci.scrapers.exceptions.NoProfessorException;
import edu.cpp.hci.scrapers.exceptions.NoResultsException;
import edu.cpp.hci.scrapers.rmp.model.professor.RMPProfessorBuilder;
import edu.cpp.hci.scrapers.rmp.model.professor.RMPProfessorDTO;
import edu.cpp.hci.scrapers.rmp.model.rating.RMPRatingBuilder;
import edu.cpp.hci.scrapers.rmp.exceptions.RateMyProfessorNoResultsException;
import edu.cpp.hci.scrapers.rmp.json.RateMyProfessorResultRawJsonDTO;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RateMyProfessorWebScaper extends WebScraper<RMPProfessorDTO> {
    private final static String HOSTNAME = "https://www.ratemyprofessors.com";
    private final static String QUERY_URL = "/search.jsp?query=";
    private final static String SHOW_RATINGS_URL = "/ShowRatings.jsp?tid=";
    private final static String PAGINATION_URL = "/paginate/professors/ratings?tid=";
    private final static String PAGE_URL = "&page=";

    public RateMyProfessorWebScaper(String professor, School school) {
        super(professor, school);
    }

    private List<Integer> fetchProfessorID() throws IOException, NoProfessorException {
        Document connection = fetchQueryConnection(getProfessor(), getSchool());
        Elements elements = connection.select("a[href*=" + SHOW_RATINGS_URL + "]");
        if (elements.size() < 1) {
            throw new NoProfessorException();
        }
        return elements.stream()
            .map(item -> item.attr("href").substring(SHOW_RATINGS_URL.length()))
            .map(Integer::new)
            .collect(Collectors.toList());
    }

    private Document fetchQueryConnection(String professor, String school) throws IOException {
        String query = HOSTNAME + QUERY_URL + URLEncoder.encode(school + " " + professor, "UTF-8");
        return Jsoup.connect(query).get();
    }

    @Override
    public List<RMPProfessorDTO> fetch()
            throws NoResultsException, IOException, NoProfessorException {
        List<Integer> professorIDs = fetchProfessorID();
        List<RMPProfessorDTO> profs = new ArrayList<>();
        for (Integer professorID : professorIDs) {
            profs.add(fetchProfessorData(professorID));

        }
        return profs;
    }

    private RMPProfessorDTO fetchProfessorData(int professorID) throws IOException, RateMyProfessorNoResultsException {
        RMPProfessorBuilder professorBuilder = new RMPProfessorBuilder().setId(professorID);
        professorBuilder.setName(getProfessor());
        professorBuilder.setSchool(getSchool());
        int remaining, page = 1;
        do {
            RateMyProfessorResultRawJsonDTO result = fetchRawProfessorData(professorID, page);
            if(result.getRatings().size() == 0 && page == 1) {
                throw new RateMyProfessorNoResultsException();
            }
            result.getRatings().stream()
                    .map(RMPRatingBuilder::copyFromRawJson)
                    .forEach(professorBuilder::withReview);
            remaining = result.getRemaining();
            page++;
        } while (remaining > 0);
        return professorBuilder.createRateMyProfessorProfessorDTO();
    }

    private RateMyProfessorResultRawJsonDTO fetchRawProfessorData(int professorID, int page) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        String query = HOSTNAME + PAGINATION_URL + professorID + PAGE_URL + page;
        return mapper.readValue(new URL(query), RateMyProfessorResultRawJsonDTO.class);
    }
}
