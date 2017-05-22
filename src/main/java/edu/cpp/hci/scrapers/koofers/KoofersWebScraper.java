package edu.cpp.hci.scrapers.koofers;

import edu.cpp.hci.scrapers.WebScraper;
import edu.cpp.hci.scrapers.constants.School;
import edu.cpp.hci.scrapers.exceptions.NoProfessorException;
import edu.cpp.hci.scrapers.exceptions.NoResultsException;
import edu.cpp.hci.scrapers.koofers.exceptions.KoofersNoProfessorException;
import edu.cpp.hci.scrapers.koofers.model.professor.KoofersProfessorDTO;
import edu.cpp.hci.scrapers.koofers.model.professor.impl.KoofersProfessor;
import edu.cpp.hci.scrapers.rmp.RateMyProfessorWebScaper;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

public class KoofersWebScraper extends WebScraper<KoofersProfessorDTO> {

    private static final String BING_BASE_URL = "https://www.bing.com/search?q=";

    private static final String KOOFERS_BASE_URL = "https://www.koofers.com/";

    public KoofersWebScraper(String professor, School school) {
        super(professor, school);
    }

    @Override
    public List<KoofersProfessorDTO> fetch() throws NoResultsException, IOException, NoProfessorException {
        Document doc = Jsoup.connect(getProfessorURL()).get();
        List<KoofersProfessorDTO> results = new ArrayList<>();
        KoofersProfessor professor = new KoofersProfessor();
        Elements name = doc.select("div[id*=full_name]");
        professor.setName(name.get(0).text());
        results.add(professor);
        return results;
    }

    public static void main(String[] args) {
        try {
            System.out.println(new KoofersWebScraper("Mohammad Husain", School.CAL_POLY_POMONA).getJson());
        } catch (IOException | NoProfessorException | NoResultsException e) {
            e.printStackTrace();
        }
    }

    public String getProfessorURL() throws IOException, KoofersNoProfessorException {
        String query = BING_BASE_URL + "koofers+" + URLEncoder.encode(getSchool() + " " + getProfessor(), "UTF-8");
        Document doc = Jsoup.connect(query).get();
        Elements select = doc.select("li.b_algo");
        Element element = select.get(0).select("h2").get(0).select("a").get(0);
        String url = element.attr("href");
        if(url.charAt(4) != 's'){
            url = url.substring(0,4) + 's' + url.substring(4);
        }
        String name = element.select("strong").get(0).text().toLowerCase();
        if(!url.contains(KOOFERS_BASE_URL) || !url.contains(getSchoolURL())){
            throw new KoofersNoProfessorException();
        }
        for(String subName: getProfessor().toLowerCase().split(" ")){
            if(!name.contains(subName)){
                throw new KoofersNoProfessorException();
            }
        }
        return url;
    }

    private String getSchoolURL() throws IOException {
        Document doc = Jsoup.connect(BING_BASE_URL + "koofers+" + URLEncoder.encode(getSchool(), "UTF-8")).get();
        Elements select = doc.select("li.b_algo");
        String url = select.get(0).select("h2").get(0).select("a").get(0).attr("href");
        return url.substring(KOOFERS_BASE_URL.length() - 1, url.lastIndexOf('/'));
    }

    public static void test() throws IOException {
        Document doc;
        // need http protocol
        doc = Jsoup.connect("https://www.koofers.com/california-state-polytechnic-university-pomona-csupomona/instructors/young-145216/").get();
        Elements reviews = doc.select("div.user_rating_box");
        for (int i = 0; i < reviews.size(); i++) {
            Element singleReview = reviews.get(i);
//            Elements select = singleReview.select("div.course_num");
//            String courseNumber = select.text();
//            System.out.println(courseNumber);
            Elements select = singleReview.select("div.right");
//            String reviewText = select.get(0).select("div").get(0).text();
//            System.out.println(reviewText);

            select = singleReview.select("div.course_name");
            String courseName = select.get(0).text();
            System.out.println(courseName);
        }
        System.out.println(reviews.size());
    }
}
