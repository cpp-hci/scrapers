package edu.cpp.hci.scrapers.koofers.model.rating;

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
