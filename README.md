# Scrapers for Professor Ratings and Reviews

Scrapers should all extend the WebScraper class which supports Object based output as well as JSON based output. These methods have a couple of thrown exceptions. TooManyResultsException will be thrown is scraping resulted in more than one professor being found. NoResultsException will be thrown if the query didn't find any professors, and IOException will be thrown from network troubles.

### Usage

You can download the code and builder the jar using the maven jar, but a simpler method is to use [jitpack.io](https://jitpack.io/#cpp-hci/scrapers/-SNAPSHOT) to include this repo as a dependency for your project.

### ratemyprofessors.com

Use the RateMyProfessorWebScaper to scrape for results from rmp. Note the school formatting is very specific for rmp so you must use a constant from the School enum.

````java
import edu.cpp.hci.scrapers.rmp.RateMyProfessorWebScaper;
import edu.cpp.hci.scrapers.rmp.dto.professor.RateMyProfessorProfessorDTO;
import edu.cpp.hci.scrapers.constants.School;

public class Example {
    public static void main(String[] args) {
        RateMyProfessorWebScaper scrapper = new RateMyProfessorWebScaper("Yu Sun", School.CAL_POLY_POMONA);
        
        try {
            RateMyProfessorProfessorDTO objectResult = scrapper.getData();
            String jsonResult = scrapper.getJson();
            System.out.println(jsonResult);
        } catch (TooManyResultsException | IOException | NoResultsException e) {
            e.printStackTrace();
        }
    }
}
````
Output: 
````json
{"id":1943004,"overallQuality":5.0,"levelOfDifficulty":2.0,"wouldTakeAgain":1.0,"ratings":[{"id":28009667,"date":"04/06/2017","description":"awesome","overallQuality":5,"levelOfDifficulty":2,"className":"CS480","forCredit":"Yes","attendance":"Not Mandatory","textBookUsed":"No","wouldTakeAgain":"Yes","gradeReceived":"A","tags":["GROUP PROJECTS","LOTS OF HOMEWORK","Caring"],"ratingText":"Dr Sun is knowledgeable about the subject and communicates clearly, both verbally and through presentation materials. Live coding demos in class and energetic lecture keep the class interesting. Workload, however, is as much as you want to put in. If you are motivated to learn a lot about Software Engineering quickly, he is a good choice.","foundHelpful":0,"foundUnhelpful":0},{"id":27809149,"date":"02/06/2017","description":"awesome","overallQuality":5,"levelOfDifficulty":2,"className":"CS480","forCredit":"N/A","attendance":"Not Mandatory","textBookUsed":"No","wouldTakeAgain":"Yes","gradeReceived":"A","tags":["Inspirational","Caring","GROUP PROJECTS"],"ratingText":"Best Software Engineering professor at CPP.  Only class you'll take that means anything outside of college.","foundHelpful":1,"foundUnhelpful":0},{"id":28009667,"date":"04/06/2017","description":"awesome","overallQuality":5,"levelOfDifficulty":2,"className":"CS480","forCredit":"Yes","attendance":"Not Mandatory","textBookUsed":"No","wouldTakeAgain":"Yes","gradeReceived":"A","tags":["Caring","GROUP PROJECTS","LOTS OF HOMEWORK"],"ratingText":"Dr Sun is knowledgeable about the subject and communicates clearly, both verbally and through presentation materials. Live coding demos in class and energetic lecture keep the class interesting. Workload, however, is as much as you want to put in. If you are motivated to learn a lot about Software Engineering quickly, he is a good choice.","foundHelpful":0,"foundUnhelpful":0},{"id":27809149,"date":"02/06/2017","description":"awesome","overallQuality":5,"levelOfDifficulty":2,"className":"CS480","forCredit":"N/A","attendance":"Not Mandatory","textBookUsed":"No","wouldTakeAgain":"Yes","gradeReceived":"A","tags":["GROUP PROJECTS","Inspirational","Caring"],"ratingText":"Best Software Engineering professor at CPP.  Only class you'll take that means anything outside of college.","foundHelpful":1,"foundUnhelpful":0}]}
````