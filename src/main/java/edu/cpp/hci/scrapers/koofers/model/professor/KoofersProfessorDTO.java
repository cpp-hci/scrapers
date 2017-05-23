package edu.cpp.hci.scrapers.koofers.model.professor;

import edu.cpp.hci.scrapers.koofers.model.rating.impl.KoofersRating;

import java.util.List;

public interface KoofersProfessorDTO {
    String getName();

    void setName(String name);

    String getSchool();

    void setSchool(String school);

    String getPeriod();

    void setPeriod(String period);

    String getDepartment();

    void setDepartment(String department);

    double getOverallRating();

    void setOverallRating(double overallRating);

    double getOverallGPA();

    void setOverallGPA(double overallGPA);

    List<KoofersRating> getRatings();

    void setRatings(List<KoofersRating> ratings);
}
