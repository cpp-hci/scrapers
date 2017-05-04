package edu.cpp.hci.scrapers.rmp.model.professor.impl;

import edu.cpp.hci.scrapers.rmp.model.professor.RMPProfessorDTO;
import edu.cpp.hci.scrapers.rmp.model.rating.RMPRatingDTO;

import java.util.List;

public class RMPProfessor implements RMPProfessorDTO {
    private int id;
    private double overallQuality;
    private double levelOfDifficulty;
    private double wouldTakeAgain;
    private List<RMPRatingDTO> ratings;
    private String name;
    private String school;

    public RMPProfessor(int id, String name, String school, double overallQuality, double levelOfDifficulty, double wouldTakeAgain,
                        List<RMPRatingDTO> ratings) {
        this.id = id;
        this.overallQuality = overallQuality;
        this.levelOfDifficulty = levelOfDifficulty;
        this.wouldTakeAgain = wouldTakeAgain;
        this.ratings = ratings;
        this.name = name;
        this.school = school;
    }

    public RMPProfessor() {
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public double getOverallQuality() {
        return overallQuality;
    }

    @Override
    public void setOverallQuality(double overallQuality) {
        this.overallQuality = overallQuality;
    }

    @Override
    public double getLevelOfDifficulty() {
        return levelOfDifficulty;
    }

    @Override
    public void setLevelOfDifficulty(double levelOfDifficulty) {
        this.levelOfDifficulty = levelOfDifficulty;
    }

    @Override
    public double getWouldTakeAgain() {
        return wouldTakeAgain;
    }

    @Override
    public void setWouldTakeAgain(double wouldTakeAgain) {
        this.wouldTakeAgain = wouldTakeAgain;
    }

    @Override
    public List<RMPRatingDTO> getRatings() {
        return ratings;
    }

    @Override
    public void setRatings(List<RMPRatingDTO> ratings) {
        this.ratings = ratings;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getSchool() {
        return school;
    }

    @Override
    public void setSchool(String school) {
        this.school = school;
    }
}
