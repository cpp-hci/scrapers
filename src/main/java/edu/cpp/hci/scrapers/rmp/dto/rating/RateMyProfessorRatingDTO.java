package edu.cpp.hci.scrapers.rmp.dto.rating;

import java.util.List;

public class RateMyProfessorRatingDTO {
    private int id;
    private String date;
    private String description;
    private int overallQuality;
    private int levelOfDifficulty;
    private String className;
    private String forCredit;
    private String attendance;
    private String textBookUsed;
    private String wouldTakeAgain;
    private String gradeReceived;
    private List<String> tags;
    private String ratingText;
    private int foundHelpful;
    private int foundUnhelpful;

    public RateMyProfessorRatingDTO(int id, String date, String description, int overallQuality,
                                    int levelOfDifficulty, String className, String forCredit, String attendance,
                                    String textBookUsed, String wouldTakeAgain, String gradeReceived, List<String> tags,
                                    String ratingText, int foundHelpful, int foundUnhelpful) {
        this.id = id;
        this.date = date;
        this.description = description;
        this.overallQuality = overallQuality;
        this.levelOfDifficulty = levelOfDifficulty;
        this.className = className;
        this.forCredit = forCredit;
        this.attendance = attendance;
        this.textBookUsed = textBookUsed;
        this.wouldTakeAgain = wouldTakeAgain;
        this.gradeReceived = gradeReceived;
        this.tags = tags;
        this.ratingText = ratingText;
        this.foundHelpful = foundHelpful;
        this.foundUnhelpful = foundUnhelpful;
    }

    public RateMyProfessorRatingDTO() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getOverallQuality() {
        return overallQuality;
    }

    public void setOverallQuality(int overallQuality) {
        this.overallQuality = overallQuality;
    }

    public int getLevelOfDifficulty() {
        return levelOfDifficulty;
    }

    public void setLevelOfDifficulty(int levelOfDifficulty) {
        this.levelOfDifficulty = levelOfDifficulty;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getForCredit() {
        return forCredit;
    }

    public void setForCredit(String forCredit) {
        this.forCredit = forCredit;
    }

    public String getAttendance() {
        return attendance;
    }

    public void setAttendance(String attendance) {
        this.attendance = attendance;
    }

    public String getTextBookUsed() {
        return textBookUsed;
    }

    public void setTextBookUsed(String textBookUsed) {
        this.textBookUsed = textBookUsed;
    }

    public String getWouldTakeAgain() {
        return wouldTakeAgain;
    }

    public void setWouldTakeAgain(String wouldTakeAgain) {
        this.wouldTakeAgain = wouldTakeAgain;
    }

    public String getGradeReceived() {
        return gradeReceived;
    }

    public void setGradeReceived(String gradeReceived) {
        this.gradeReceived = gradeReceived;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public String getRatingText() {
        return ratingText;
    }

    public void setRatingText(String ratingText) {
        this.ratingText = ratingText;
    }

    public int getFoundHelpful() {
        return foundHelpful;
    }

    public void setFoundHelpful(int foundHelpful) {
        this.foundHelpful = foundHelpful;
    }

    public int getFoundUnhelpful() {
        return foundUnhelpful;
    }

    public void setFoundUnhelpful(int foundUnhelpful) {
        this.foundUnhelpful = foundUnhelpful;
    }
}
