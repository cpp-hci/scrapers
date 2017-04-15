package edu.cpp.hci.scrapers.rmp;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.cpp.hci.scrapers.WebScraper;
import edu.cpp.hci.scrapers.constants.School;
import edu.cpp.hci.scrapers.exceptions.NoResultsException;
import edu.cpp.hci.scrapers.exceptions.TooManyResultsException;
import edu.cpp.hci.scrapers.rmp.dto.professor.RateMyProfessorProfessorDTO;
import edu.cpp.hci.scrapers.rmp.dto.professor.RateMyProfessorProfessorDTOBuilder;
import edu.cpp.hci.scrapers.rmp.dto.rating.RateMyProfessorRatingDTOBuilder;
import edu.cpp.hci.scrapers.rmp.exceptions.RateMyProfessorNoResultsException;
import edu.cpp.hci.scrapers.rmp.exceptions.RateMyProfessorTooManyResultsException;
import edu.cpp.hci.scrapers.rmp.json.RateMyProfessorResultRawJsonDTO;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.URL;
import java.net.URLEncoder;

public class RateMyProfessorWebScaper extends WebScraper<RateMyProfessorProfessorDTO> {
    private final static String HOSTNAME = "https://www.ratemyprofessors.com";
    private final static String QUERY_URL = "/search.jsp?query=";
    private final static String SHOW_RATINGS_URL = "/ShowRatings.jsp?tid=";
    private final static String PAGINATION_URL = "/paginate/professors/ratings?tid=";
    private final static String PAGE_URL = "&page=";

    public RateMyProfessorWebScaper(String professor, School school) {
        super(professor, school);
    }

    private int fetchProfessorID() throws IOException,
            RateMyProfessorTooManyResultsException, RateMyProfessorNoResultsException {
        Document connection = fetchQueryConnection(getProfessor(), getSchool());
        Elements elements = connection.select("a[href*=" + SHOW_RATINGS_URL + "]");
        if (elements.size() > 1) {
            throw new RateMyProfessorTooManyResultsException();
        }
        if (elements.size() < 1) {
            throw new RateMyProfessorNoResultsException();
        }
        return Integer.parseInt(elements.get(0).attr("href").substring(SHOW_RATINGS_URL.length()));
    }

    private Document fetchQueryConnection(String professor, String school) throws IOException {
        String query = HOSTNAME + QUERY_URL + URLEncoder.encode(school + " " + professor, "UTF-8");
        return Jsoup.connect(query).get();
    }

    @Override
    public RateMyProfessorProfessorDTO fetch()
            throws TooManyResultsException, NoResultsException, IOException {
        int professorID = fetchProfessorID();
        return fetchProfessorData(professorID);
    }

    private RateMyProfessorProfessorDTO fetchProfessorData(int professorID) throws IOException {
        RateMyProfessorProfessorDTOBuilder professorBuilder = new RateMyProfessorProfessorDTOBuilder().setId(professorID);
        int remaining, page = 0;
        do {
            RateMyProfessorResultRawJsonDTO result = fetchRawProfessorData(professorID, page);
            result.getRatings().stream()
                    .map(RateMyProfessorRatingDTOBuilder::copyFromRawJson)
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
