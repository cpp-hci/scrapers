package edu.cpp.hci.scrapers;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.cpp.hci.scrapers.constants.School;
import edu.cpp.hci.scrapers.exceptions.NoResultsException;

import java.io.IOException;
import java.util.List;

public abstract class WebScraper<E extends ProfessorDTO> {
    private String professor;
    private String school;
    private String json;
    private List<E> data;

    public WebScraper(String professor, School school) {
        this.professor = professor;
        this.school = school.toString();
    }

    public WebScraper(String professor, String school) {
        this.professor = professor;
        this.school = school;
    }

    public String getProfessor() {
        return professor;
    }

    public void setProfessor(String professor) throws NoResultsException, IOException {
        this.professor = professor;
        refresh();
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) throws NoResultsException, IOException {
        this.school = school;
        refresh();
    }

    public void setSchool(School school) throws NoResultsException, IOException {
        this.school = school.toString();
        refresh();
    }

    public String getJson() throws NoResultsException, IOException {
        if (json == null) {
            refresh();
        }
        return json;
    }

    public List<E> getData() throws NoResultsException, IOException {
        if (data == null) {
            refresh();
        }
        return data;
    }

    public void refresh() throws NoResultsException, IOException {
        data = fetch();
        json = new ObjectMapper().writeValueAsString(data);
    }

    public abstract List<E> fetch() throws NoResultsException, IOException;

}