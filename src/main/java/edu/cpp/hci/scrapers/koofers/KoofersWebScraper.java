package edu.cpp.hci.scrapers.koofers;

import edu.cpp.hci.scrapers.WebScraper;
import edu.cpp.hci.scrapers.constants.School;
import edu.cpp.hci.scrapers.exceptions.NoProfessorException;
import edu.cpp.hci.scrapers.exceptions.NoResultsException;
import edu.cpp.hci.scrapers.koofers.exceptions.KoofersNoProfessorException;
import edu.cpp.hci.scrapers.koofers.model.professor.KoofersProfessorDTO;
import edu.cpp.hci.scrapers.koofers.model.professor.impl.KoofersProfessor;
import edu.cpp.hci.scrapers.koofers.model.rating.KoofersRatingDTO;
import edu.cpp.hci.scrapers.koofers.model.rating.impl.KoofersRating;
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

    public KoofersWebScraper(String professor, String school) {
        super(professor, school);
    }

    @Override
    public List<KoofersProfessorDTO> fetch() throws NoResultsException, IOException, NoProfessorException {
        String professorURL = getProfessorURL();
        Document doc = Jsoup.connect(professorURL).get();
        KoofersProfessor professor = new KoofersProfessor();
        List<KoofersProfessorDTO> results = new ArrayList<>();
        professor.setName(getProfessor());
        professor.setSchool(getSchool());
        Elements overallRate = doc.select("div[id*=header_box_rating]");
        Element subd = overallRate.get(0);
        professor.setOverallRating(Double.parseDouble(subd.text().substring(2, 5)));
        Elements overallGPA = doc.select("div[id*=avg_gpa]");
        if (overallGPA.size() > 0) {
            professor.setOverallGPA(Double.parseDouble(overallGPA.get(0).text()));
        }
        professor.setRatings(getRatings(professorURL));
        results.add(professor);
        return results;
    }

    public String getProfessorURL() throws IOException, KoofersNoProfessorException {
        String query = BING_BASE_URL + "koofers+" + URLEncoder.encode(getSchool() + " " + getProfessor(), "UTF-8");
        Document doc = Jsoup.connect(query).get();
        Elements select = doc.select("li.b_algo");
        Element element = select.get(0).select("h2").get(0).select("a").get(0);
        String url = element.attr("href");
        if (url.charAt(4) != 's') {
            url = url.substring(0, 4) + 's' + url.substring(4);
        }
        String name = element.select("strong").get(0).text().toLowerCase();
        if (!url.contains(KOOFERS_BASE_URL) || !url.contains(getSchoolURL())) {
            throw new KoofersNoProfessorException();
        }
        for (String subName : getProfessor().toLowerCase().split(" ")) {
            if (!name.contains(subName)) {
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

    public List<KoofersRatingDTO> getRatings(String professorURL) throws IOException {
        Document doc;
        List<KoofersRatingDTO> reviewList = new ArrayList<>();
        doc = Jsoup.connect(professorURL).get();
        Elements reviews = doc.select("div.user_rating_box");
        for (int i = 0; i < reviews.size(); i++) {
            KoofersRating krb = new KoofersRating();
            Element singleReview = reviews.get(i);
            Elements courseNum = singleReview.select("div.course_num");
            String cnumber = courseNum.text();
            krb.setCourseNumber(cnumber);

            Elements coursenam = singleReview.select("div.course_name");
            String courseName = coursenam.get(0).text();
            krb.setCourseName(courseName);

            Elements rating = singleReview.select("span");
            double classrating = Double.parseDouble(rating.get(0).text());
            krb.setOverallRating(classrating);

            Elements select = singleReview.select("div.right");
            String reviewText = select.get(0).select("div").get(0).text();
            int index = reviewText.lastIndexOf(" Professor rated by");
            if (index == -1) {
                System.out.println(reviewText);
            }
            krb.setReviewText(reviewText.substring(0, index));

            reviewList.add(krb);
        }
        return reviewList;
    }

}

