package edu.cpp.hci.scrapers.rmp.dto.professor;

import edu.cpp.hci.scrapers.rmp.dto.rating.RateMyProfessorRatingDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;

public class RateMyProfessorProfessorDTOBuilder {
    private int id;
    private double overallQuality;
    private double levelOfDifficulty;
    private double wouldTakeAgain;
    private List<RateMyProfessorRatingDTO> ratings;

    public RateMyProfessorProfessorDTOBuilder setId(int id) {
        this.id = id;
        return this;
    }

    public RateMyProfessorProfessorDTOBuilder setOverallQuality(double overallQuality) {
        this.overallQuality = overallQuality;
        return this;
    }

    public RateMyProfessorProfessorDTOBuilder setLevelOfDifficulty(double levelOfDifficulty) {
        this.levelOfDifficulty = levelOfDifficulty;
        return this;
    }

    public RateMyProfessorProfessorDTOBuilder setWouldTakeAgain(double wouldTakeAgain) {
        this.wouldTakeAgain = wouldTakeAgain;
        return this;
    }

    public RateMyProfessorProfessorDTOBuilder setRatings(List<RateMyProfessorRatingDTO> ratings) {
        this.ratings = ratings;
        return this;
    }

    public RateMyProfessorProfessorDTOBuilder withReview(RateMyProfessorRatingDTO review) {
        if (ratings == null) {
            ratings = new ArrayList<RateMyProfessorRatingDTO>();
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
        return new RateMyProfessorProfessorDTO(id, overallQuality, levelOfDifficulty, wouldTakeAgain, ratings);
    }

    public int wouldTakeAgainToInt(String wouldTakeAgain) {
        return wouldTakeAgain.equals("Yes") ? 1 : 0;
    }
}