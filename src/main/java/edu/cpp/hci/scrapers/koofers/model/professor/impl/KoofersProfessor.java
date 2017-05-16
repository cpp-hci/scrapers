package edu.cpp.hci.scrapers.koofers.model.professor.impl;

import edu.cpp.hci.scrapers.koofers.model.professor.KoofersProfessorDTO;
import edu.cpp.hci.scrapers.koofers.model.rating.KoofersRatingDTO;
import edu.cpp.hci.scrapers.koofers.model.rating.impl.KoofersRating;
import edu.cpp.hci.scrapers.koofers.model.rating.impl.KoofersRatingBuilder;

import java.util.ArrayList;
import java.util.List;

public class KoofersProfessor implements KoofersProfessorDTO {

    private String name;
    private String period ;
    private String school;
    private String department;
    private double overallRating;
    private double overallGPA;
   // private List ratings;
    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    @Override
    public String getSchool() {
        return school;
    }

    @Override
    public void setSchool(String school) {
        this.school =school;

    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public double getOverallRating() {
        return overallRating;
    }

    @Override
    public void setOverallRating(double overallRating) {
    this.overallRating = overallRating;
    }

    @Override
  public void setRatings(List<KoofersRating> ratings)   {    }


    //@Override
   public List<KoofersRating> getRatings() {         return null;     }

    public double getOverallGPA() {
        return overallGPA;
    }

    public void setOverallGPA(double overallGPA) {
        this.overallGPA = overallGPA;
    }


}
