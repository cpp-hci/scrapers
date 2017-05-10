package edu.cpp.hci.scrapers.koofers;

import edu.cpp.hci.scrapers.WebScraper;
import edu.cpp.hci.scrapers.constants.School;
import edu.cpp.hci.scrapers.exceptions.NoResultsException;
import edu.cpp.hci.scrapers.koofers.model.professor.KoofersProfessorDTO;
import edu.cpp.hci.scrapers.koofers.model.professor.impl.KoofersProfessor;
import edu.cpp.hci.scrapers.koofers.model.rating.KoofersRatingDTO;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class KoofersWebScraper extends WebScraper<KoofersProfessorDTO> {
    public KoofersWebScraper(String professor, School school) {
        super(professor, school);
    }

    @Override
    public List<KoofersProfessorDTO> fetch() throws NoResultsException, IOException {
        List<KoofersProfessorDTO> results = new ArrayList<>();
        KoofersProfessor young = new KoofersProfessor();
        Document doc = Jsoup.connect("https://www.koofers.com/california-state-polytechnic-university-pomona-csupomona/instructors/young-145216/").get();
        Elements name = doc.select("div[id*=full_name]");
        young.setName(name.get(0).text());
        results.add(young);
        return results;
    }

    public static void main(String[] args) {
        try {
            List<KoofersProfessorDTO> fetch = new KoofersWebScraper("", School.CAL_POLY_POMONA).fetch();
            for (KoofersProfessorDTO koofersProfessorDTO : fetch) {
                System.out.println(koofersProfessorDTO.getName());
            }

        } catch (NoResultsException | IOException e) {
            e.printStackTrace();
        }
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
