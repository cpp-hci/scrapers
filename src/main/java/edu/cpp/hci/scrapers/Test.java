package edu.cpp.hci.scrapers;

import edu.cpp.hci.scrapers.exceptions.NoResultsException;
import edu.cpp.hci.scrapers.rmp.RateMyProfessorWebScaper;
import edu.cpp.hci.scrapers.rmp.dto.professor.RateMyProfessorProfessorDTO;
import edu.cpp.hci.scrapers.constants.School;

import java.io.IOException;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        RateMyProfessorWebScaper scrapper = new RateMyProfessorWebScaper("Yu Sun", School.CAL_POLY_POMONA);
        try {
            List<RateMyProfessorProfessorDTO> objectResult = scrapper.getData();
            String jsonResult = scrapper.getJson();
            System.out.println(jsonResult);
        } catch (IOException | NoResultsException e) {
            e.printStackTrace();
        }
    }
}