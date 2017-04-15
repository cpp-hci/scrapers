package edu.cpp.hci.scrapers.rmp.json;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RateMyProfessorResultRawJsonDTO {
    private List<RateMyProfessorRatingRawJsonDTO> ratings;
    private int remaining;

    public RateMyProfessorResultRawJsonDTO() {

    }

    public RateMyProfessorResultRawJsonDTO(List<RateMyProfessorRatingRawJsonDTO> ratings, int remaining) {

        this.ratings = ratings;
        this.remaining = remaining;
    }

    public List<RateMyProfessorRatingRawJsonDTO> getRatings() {
        return ratings;
    }

    public void setRatings(List<RateMyProfessorRatingRawJsonDTO> ratings) {
        this.ratings = ratings;
    }

    public int getRemaining() {
        return remaining;
    }

    public void setRemaining(int remaining) {
        this.remaining = remaining;
    }
}
