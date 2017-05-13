package edu.cpp.hci.scrapers.koofers.model.professor;

import edu.cpp.hci.scrapers.koofers.model.rating.KoofersRatingDTO;

import java.util.List;

public interface KoofersProfessorDTO {
    String getName();
    void setName(String name);
    String getSchool();
    void setPeriod(String period);
    String getPeriod();
    void setDepartment(String department);
    String getDepartment();
    void setSchool(String school);
    double getOverallRating();
    void setOverallRating(double overallRating);
    void setOverallGPA(double overallGPA);
    double getOverallGPA();

    void setRatings(List<KoofersRatingDTO> ratings);
    List<KoofersRatingDTO> getRatings();


}
