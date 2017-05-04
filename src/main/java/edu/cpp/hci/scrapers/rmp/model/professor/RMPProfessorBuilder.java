package edu.cpp.hci.scrapers.rmp.model.professor;

import edu.cpp.hci.scrapers.rmp.model.professor.impl.RMPProfessor;
import edu.cpp.hci.scrapers.rmp.model.rating.RMPRatingDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;

public class RMPProfessorBuilder {
    private int id;
    private double overallQuality;
    private double levelOfDifficulty;
    private double wouldTakeAgain;
    private String name;
    private String school;
    private List<RMPRatingDTO> ratings;

    public RMPProfessorBuilder setId(int id) {
        this.id = id;
        return this;
    }

    public RMPProfessorBuilder setOverallQuality(double overallQuality) {
        this.overallQuality = overallQuality;
        return this;
    }

    public RMPProfessorBuilder setLevelOfDifficulty(double levelOfDifficulty) {
        this.levelOfDifficulty = levelOfDifficulty;
        return this;
    }

    public RMPProfessorBuilder setWouldTakeAgain(double wouldTakeAgain) {
        this.wouldTakeAgain = wouldTakeAgain;
        return this;
    }

    public RMPProfessorBuilder setRatings(List<RMPRatingDTO> ratings) {
        this.ratings = ratings;
        return this;
    }

    public RMPProfessorBuilder withReview(RMPRatingDTO review) {
        if (ratings == null) {
            ratings = new ArrayList<>();
        }
        ratings.add(review);
        return this;
    }

    public RMPProfessorBuilder setName(String name){
        this.name = name;
        return this;
    }

    public RMPProfessorBuilder setSchool(String school){
        this.school = school;
        return this;
    }

    public RMPProfessorDTO createRateMyProfessorProfessorDTO() {
        if (ratings != null) {
            if (levelOfDifficulty == 0) {
                OptionalDouble average = ratings.stream().mapToInt(RMPRatingDTO::getLevelOfDifficulty).average();
                if (average.isPresent()) {
                    levelOfDifficulty = average.getAsDouble();
                }
            }
            if (overallQuality == 0) {
                OptionalDouble average = ratings.stream().mapToInt(RMPRatingDTO::getOverallQuality).average();
                if (average.isPresent()) {
                    overallQuality = average.getAsDouble();
                }
            }
            if (wouldTakeAgain == 0) {
                OptionalDouble average = ratings.stream()
                        .map(RMPRatingDTO::getWouldTakeAgain)
                        .mapToInt(this::wouldTakeAgainToInt).average();
                if (average.isPresent()) {
                    wouldTakeAgain = average.getAsDouble();
                }
            }
        }
        return new RMPProfessor(id, name, school, overallQuality, levelOfDifficulty, wouldTakeAgain, ratings);
    }

    public int wouldTakeAgainToInt(String wouldTakeAgain) {
        return wouldTakeAgain.equals("Yes") ? 1 : 0;
    }
}