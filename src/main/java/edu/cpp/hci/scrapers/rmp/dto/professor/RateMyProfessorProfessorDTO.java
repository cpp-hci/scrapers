package edu.cpp.hci.scrapers.rmp.dto.professor;

import edu.cpp.hci.scrapers.Professor;
import edu.cpp.hci.scrapers.rmp.dto.rating.RateMyProfessorRatingDTO;

import java.util.List;

public class RateMyProfessorProfessorDTO implements Professor {
    private int id;
    private double overallQuality;
    private double levelOfDifficulty;
    private double wouldTakeAgain;
    private List<RateMyProfessorRatingDTO> ratings;

    public RateMyProfessorProfessorDTO(int id, double overallQuality, double levelOfDifficulty, double wouldTakeAgain,
                                       List<RateMyProfessorRatingDTO> ratings) {
        this.id = id;
        this.overallQuality = overallQuality;
        this.levelOfDifficulty = levelOfDifficulty;
        this.wouldTakeAgain = wouldTakeAgain;
        this.ratings = ratings;
    }

    public RateMyProfessorProfessorDTO() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getOverallQuality() {
        return overallQuality;
    }

    public void setOverallQuality(double overallQuality) {
        this.overallQuality = overallQuality;
    }

    public double getLevelOfDifficulty() {
        return levelOfDifficulty;
    }

    public void setLevelOfDifficulty(double levelOfDifficulty) {
        this.levelOfDifficulty = levelOfDifficulty;
    }

    public double getWouldTakeAgain() {
        return wouldTakeAgain;
    }

    public void setWouldTakeAgain(double wouldTakeAgain) {
        this.wouldTakeAgain = wouldTakeAgain;
    }

    public List<RateMyProfessorRatingDTO> getRatings() {
        return ratings;
    }

    public void setRatings(List<RateMyProfessorRatingDTO> ratings) {
        this.ratings = ratings;
    }
}
