package edu.cpp.hci.scrapers.koofers.model.rating.impl;

import edu.cpp.hci.scrapers.koofers.model.rating.KoofersRatingDTO;

public class KoofersRating implements KoofersRatingDTO {
    private String courseNumber;
    private String courseName;

    @Override
    public void setCourseName(String name) {
        this.courseName = name;
    }

    @Override
    public String getCourseName() {
        return courseName;
    }

    @Override
    public void setCourseNumber(String number) {

    }

    @Override
    public String getCourseNumber() {
        return null;
    }
}
