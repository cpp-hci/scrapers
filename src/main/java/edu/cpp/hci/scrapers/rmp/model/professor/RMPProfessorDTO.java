package edu.cpp.hci.scrapers.rmp.model.professor;

import edu.cpp.hci.scrapers.rmp.model.rating.RMPRatingDTO;

import java.util.List;

public interface RMPProfessorDTO {
    int getId();

    void setId(int id);

    double getOverallQuality();

    void setOverallQuality(double overallQuality);

    double getLevelOfDifficulty();

    void setLevelOfDifficulty(double levelOfDifficulty);

    double getWouldTakeAgain();

    void setWouldTakeAgain(double wouldTakeAgain);

    List<RMPRatingDTO> getRatings();

    void setRatings(List<RMPRatingDTO> ratings);

    String getName();

    void setName(String name);

    String getSchool();

    void setSchool(String school);
}
