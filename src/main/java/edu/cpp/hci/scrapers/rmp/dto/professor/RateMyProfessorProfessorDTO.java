package edu.cpp.hci.scrapers.rmp.dto.professor;

import edu.cpp.hci.scrapers.ProfessorDTO;
import edu.cpp.hci.scrapers.rmp.dto.rating.RateMyProfessorRatingDTO;

import java.util.List;

public interface RateMyProfessorProfessorDTO extends ProfessorDTO {
    int getId();

    void setId(int id);

    double getOverallQuality();

    void setOverallQuality(double overallQuality);

    double getLevelOfDifficulty();

    void setLevelOfDifficulty(double levelOfDifficulty);

    double getWouldTakeAgain();

    void setWouldTakeAgain(double wouldTakeAgain);

    List<RateMyProfessorRatingDTO> getRatings();

    void setRatings(List<RateMyProfessorRatingDTO> ratings);
}
