package edu.cpp.hci.scrapers;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.cpp.hci.scrapers.constants.School;
import edu.cpp.hci.scrapers.exceptions.NoResultsException;
import edu.cpp.hci.scrapers.exceptions.TooManyResultsException;

import java.io.IOException;

public abstract class WebScraper<E extends Professor> {
    private String professor;
    private String school;
    private String json;
    private E data;

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

    public void setProfessor(String professor) throws TooManyResultsException, NoResultsException, IOException {
        this.professor = professor;
        refresh();
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) throws TooManyResultsException, NoResultsException, IOException {
        this.school = school;
        refresh();
    }

    public void setSchool(School school) throws TooManyResultsException, NoResultsException, IOException {
        this.school = school.toString();
        refresh();
    }

    public String getJson() throws TooManyResultsException, NoResultsException, IOException {
        if (json == null) {
            refresh();
        }
        return json;
    }

    public E getData() throws TooManyResultsException, NoResultsException, IOException {
        if (data == null) {
            refresh();
        }
        return data;
    }

    public void refresh() throws TooManyResultsException, NoResultsException, IOException {
        data = fetch();
        json = new ObjectMapper().writeValueAsString(data);
    }

    public abstract E fetch() throws TooManyResultsException, NoResultsException, IOException;

}