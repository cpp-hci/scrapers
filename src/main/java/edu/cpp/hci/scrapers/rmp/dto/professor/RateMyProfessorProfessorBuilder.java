package edu.cpp.hci.scrapers.rmp.dto.professor;

import edu.cpp.hci.scrapers.rmp.dto.professor.impl.RateMyProfessorProfessor;
import edu.cpp.hci.scrapers.rmp.dto.rating.impl.RateMyProfessorRating;
import edu.cpp.hci.scrapers.rmp.dto.rating.RateMyProfessorRatingDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;

public class RateMyProfessorProfessorBuilder {
    private int id;
    private double overallQuality;
    private double levelOfDifficulty;
    private double wouldTakeAgain;
    private List<RateMyProfessorRatingDTO> ratings;

    public RateMyProfessorProfessorBuilder setId(int id) {
        this.id = id;
        return this;
    }

    public RateMyProfessorProfessorBuilder setOverallQuality(double overallQuality) {
        this.overallQuality = overallQuality;
        return this;
    }

    public RateMyProfessorProfessorBuilder setLevelOfDifficulty(double levelOfDifficulty) {
        this.levelOfDifficulty = levelOfDifficulty;
        return this;
    }

    public RateMyProfessorProfessorBuilder setWouldTakeAgain(double wouldTakeAgain) {
        this.wouldTakeAgain = wouldTakeAgain;
        return this;
    }

    public RateMyProfessorProfessorBuilder setRatings(List<RateMyProfessorRatingDTO> ratings) {
        this.ratings = ratings;
        return this;
    }

    public RateMyProfessorProfessorBuilder withReview(RateMyProfessorRatingDTO review) {
        if (ratings == null) {
            ratings = new ArrayList<>();
        }
        ratings.add(review);
        return this;
    }

    public RateMyProfessorProfessorDTO createRateMyProfessorProfessorDTO() {
        if (ratings != null) {
            if (levelOfDifficulty == 0) {
                OptionalDouble average = ratings.stream().mapToInt(RateMyProfessorRatingDTO::getLevelOfDifficulty).average();
                if (average.isPresent()) {
                    levelOfDifficulty = average.getAsDouble();
                }
            }
            if (overallQuality == 0) {
                OptionalDouble average = ratings.stream().mapToInt(RateMyProfessorRatingDTO::getOverallQuality).average();
                if (average.isPresent()) {
                    overallQuality = average.getAsDouble();
                }
            }
            if (wouldTakeAgain == 0) {
                OptionalDouble average = ratings.stream()
                        .map(RateMyProfessorRatingDTO::getWouldTakeAgain)
                        .mapToInt(this::wouldTakeAgainToInt).average();
                if (average.isPresent()) {
                    wouldTakeAgain = average.getAsDouble();
                }
            }
        }
        return new RateMyProfessorProfessor(id, overallQuality, levelOfDifficulty, wouldTakeAgain, ratings);
    }

    public int wouldTakeAgainToInt(String wouldTakeAgain) {
        return wouldTakeAgain.equals("Yes") ? 1 : 0;
    }
}