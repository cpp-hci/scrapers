package edu.cpp.hci.scrapers.koofers;

import edu.cpp.hci.scrapers.WebScraper;
import edu.cpp.hci.scrapers.constants.School;
import edu.cpp.hci.scrapers.exceptions.NoResultsException;
import edu.cpp.hci.scrapers.koofers.model.rating.KoofersRatingDTO;
import edu.cpp.hci.scrapers.koofers.model.rating.impl.KoofersRating;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.List;

public class KoofersWebScraper extends WebScraper<KoofersRatingDTO> {
    public KoofersWebScraper(String professor, School school) {
        super(professor, school);
    }

    @Override
    public List<KoofersRatingDTO> fetch() throws NoResultsException, IOException {
        List<KoofersRatingDTO> results;

        KoofersRating rating = new KoofersRating();
        rating.setCourseName();
        rating.setCourseNumber();

        return null;
    }

    public static void main(String[] args) {
        try {
            test();
        } catch (IOException e) {
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
