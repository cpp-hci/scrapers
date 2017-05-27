package edu.cpp.hci.scrapers.koofers.model.rating;

public interface KoofersRatingDTO {
    String getCourseName();

    void setCourseName(String name);

    String getCourseNumber();

    void setCourseNumber(String number);

    String getPeriod();

    void setPeriod(String period);

    double getOverallGPA();

    void setOverallGPA(double overallGPA);

    void setReviewText(String text);

    String getReviewText();

}
