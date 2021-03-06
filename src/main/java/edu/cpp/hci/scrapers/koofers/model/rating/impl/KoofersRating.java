package edu.cpp.hci.scrapers.koofers.model.rating.impl;

import edu.cpp.hci.scrapers.koofers.model.rating.KoofersRatingDTO;

public class KoofersRating implements KoofersRatingDTO {
    private String courseNumber;
    private String courseName;
    private String period;
    private double overallRating;
    private double overallGPA;
    private String reviewText;


    @Override
    public String getPeriod() {
        return period;
    }

    @Override
    public void setPeriod(String period) {
        this.period = period;
    }

    @Override
    public String getCourseName() {
        return courseName;
    }

    @Override
    public void setCourseName(String name) {
        this.courseName = name;
    }

    @Override
    public String getCourseNumber() {
        return courseNumber;
    }

    @Override
    public void setCourseNumber(String number) {
        this.courseNumber = number;
    }

    public double getOverallRating() {
        return overallRating;
    }

    public void setOverallRating(double overallRating) {
        this.overallRating = overallRating;
    }

    @Override
    public double getOverallGPA() {
        return overallGPA;
    }

    @Override
    public void setOverallGPA(double overallGPA) {
        this.overallGPA = overallGPA;
    }

    public String getReviewText() {
        return reviewText;
    }

    public void setReviewText(String reviewText) {
        this.reviewText = reviewText;
    }
}
