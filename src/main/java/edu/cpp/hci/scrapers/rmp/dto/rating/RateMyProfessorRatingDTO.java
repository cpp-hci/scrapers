package edu.cpp.hci.scrapers.rmp.dto.rating;

import java.util.List;

public interface RateMyProfessorRatingDTO {
    int getId();

    void setId(int id);

    String getDate();

    void setDate(String date);

    String getDescription();

    void setDescription(String description);

    int getOverallQuality();

    void setOverallQuality(int overallQuality);

    int getLevelOfDifficulty();

    void setLevelOfDifficulty(int levelOfDifficulty);

    String getClassName();

    void setClassName(String className);

    String getForCredit();

    void setForCredit(String forCredit);

    String getAttendance();

    void setAttendance(String attendance);

    String getTextBookUsed();

    void setTextBookUsed(String textBookUsed);

    String getWouldTakeAgain();

    void setWouldTakeAgain(String wouldTakeAgain);

    String getGradeReceived();

    void setGradeReceived(String gradeReceived);

    List<String> getTags();

    void setTags(List<String> tags);

    String getRatingText();

    void setRatingText(String ratingText);

    int getFoundHelpful();

    void setFoundHelpful(int foundHelpful);

    int getFoundUnhelpful();

    void setFoundUnhelpful(int foundUnhelpful);
}
