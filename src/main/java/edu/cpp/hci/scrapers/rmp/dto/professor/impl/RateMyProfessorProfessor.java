package edu.cpp.hci.scrapers.rmp.dto.professor.impl;

import edu.cpp.hci.scrapers.rmp.dto.professor.RateMyProfessorProfessorDTO;
import edu.cpp.hci.scrapers.rmp.dto.rating.RateMyProfessorRatingDTO;

import java.util.List;

public class RateMyProfessorProfessor implements RateMyProfessorProfessorDTO {
    private int id;
    private double overallQuality;
    private double levelOfDifficulty;
    private double wouldTakeAgain;
    private List<RateMyProfessorRatingDTO> ratings;

    public RateMyProfessorProfessor(int id, double overallQuality, double levelOfDifficulty, double wouldTakeAgain,
                                    List<RateMyProfessorRatingDTO> ratings) {
        this.id = id;
        this.overallQuality = overallQuality;
        this.levelOfDifficulty = levelOfDifficulty;
        this.wouldTakeAgain = wouldTakeAgain;
        this.ratings = ratings;
    }

    public RateMyProfessorProfessor() {
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
    public List<RateMyProfessorRatingDTO> getRatings() {
        return ratings;
    }

    @Override
    public void setRatings(List<RateMyProfessorRatingDTO> ratings) {
        this.ratings = ratings;
    }
}
