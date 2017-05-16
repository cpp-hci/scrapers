package edu.cpp.hci.scrapers.koofers.model.rating.impl;

import edu.cpp.hci.scrapers.rmp.json.RateMyProfessorRatingRawJsonDTO;
import edu.cpp.hci.scrapers.rmp.model.rating.RMPRatingDTO;
import edu.cpp.hci.scrapers.rmp.model.rating.impl.RMPRating;

import java.util.ArrayList;
import java.util.List;

public class KoofersRatingBuilder {

    private String date;
    private String classNum;
    private String className;
    private double classRating;
    private String ratingText;
    public KoofersRatingBuilder(){}

    public KoofersRatingBuilder(String date, String classNum, String className, double classRating, String ratingText) {
        this.date = date;
        this.classNum = classNum;
        this.className = className;
        this.classRating = classRating;
        this.ratingText = ratingText;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getClassNum() {
        return classNum;
    }

    public void setClassNum(String classNum) {
        this.classNum = classNum;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public double getClassRating() {
        return classRating;
    }

    public void setClassRating(double classRating) {
        this.classRating = classRating;
    }

    public String getRatingText() {
        return ratingText;
    }

    public void setRatingText(String ratingText) {
        this.ratingText = ratingText;
    }


}