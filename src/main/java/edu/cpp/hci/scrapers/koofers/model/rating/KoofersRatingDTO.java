package edu.cpp.hci.scrapers.koofers.model.rating;

import edu.cpp.hci.scrapers.koofers.model.rating.impl.KoofersRating;

import java.util.List;

public interface KoofersRatingDTO {
    void setCourseName(String name);
    String getCourseName();
    void setCourseNumber(String number);
    String getCourseNumber();
    void setPeriod(String period);
    String getPeriod();
    void setOverallGPA(double overallGPA);
    double getOverallGPA();

}
