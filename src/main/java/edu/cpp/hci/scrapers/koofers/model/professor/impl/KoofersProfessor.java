package edu.cpp.hci.scrapers.koofers.model.professor.impl;

import edu.cpp.hci.scrapers.koofers.model.professor.KoofersProfessorDTO;
import edu.cpp.hci.scrapers.koofers.model.rating.KoofersRatingDTO;

import java.util.List;

public class KoofersProfessor implements KoofersProfessorDTO {
    private String name;

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
        return null;
    }

    @Override
    public void setSchool(String school) {

    }

    @Override
    public double getOverallRating() {
        return 0;
    }

    @Override
    public void setOverallRating(double overallRating) {

    }

    @Override
    public void setRatings(List<KoofersRatingDTO> ratings) {

    }

    @Override
    public List<KoofersRatingDTO> getRatings() {
        return null;
    }
}
