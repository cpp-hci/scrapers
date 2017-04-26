package edu.cpp.hci.scrapers.rmp.dto.rating.impl;

import edu.cpp.hci.scrapers.rmp.dto.rating.RateMyProfessorRatingDTO;

import java.util.List;

public class RateMyProfessorRating implements RateMyProfessorRatingDTO {
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

    public RateMyProfessorRating(int id, String date, String description, int overallQuality,
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

    public RateMyProfessorRating() {
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String getDate() {
        return date;
    }

    @Override
    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int getOverallQuality() {
        return overallQuality;
    }

    @Override
    public void setOverallQuality(int overallQuality) {
        this.overallQuality = overallQuality;
    }

    @Override
    public int getLevelOfDifficulty() {
        return levelOfDifficulty;
    }

    @Override
    public void setLevelOfDifficulty(int levelOfDifficulty) {
        this.levelOfDifficulty = levelOfDifficulty;
    }

    @Override
    public String getClassName() {
        return className;
    }

    @Override
    public void setClassName(String className) {
        this.className = className;
    }

    @Override
    public String getForCredit() {
        return forCredit;
    }

    @Override
    public void setForCredit(String forCredit) {
        this.forCredit = forCredit;
    }

    @Override
    public String getAttendance() {
        return attendance;
    }

    @Override
    public void setAttendance(String attendance) {
        this.attendance = attendance;
    }

    @Override
    public String getTextBookUsed() {
        return textBookUsed;
    }

    @Override
    public void setTextBookUsed(String textBookUsed) {
        this.textBookUsed = textBookUsed;
    }

    @Override
    public String getWouldTakeAgain() {
        return wouldTakeAgain;
    }

    @Override
    public void setWouldTakeAgain(String wouldTakeAgain) {
        this.wouldTakeAgain = wouldTakeAgain;
    }

    @Override
    public String getGradeReceived() {
        return gradeReceived;
    }

    @Override
    public void setGradeReceived(String gradeReceived) {
        this.gradeReceived = gradeReceived;
    }

    @Override
    public List<String> getTags() {
        return tags;
    }

    @Override
    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    @Override
    public String getRatingText() {
        return ratingText;
    }

    @Override
    public void setRatingText(String ratingText) {
        this.ratingText = ratingText;
    }

    @Override
    public int getFoundHelpful() {
        return foundHelpful;
    }

    @Override
    public void setFoundHelpful(int foundHelpful) {
        this.foundHelpful = foundHelpful;
    }

    @Override
    public int getFoundUnhelpful() {
        return foundUnhelpful;
    }

    @Override
    public void setFoundUnhelpful(int foundUnhelpful) {
        this.foundUnhelpful = foundUnhelpful;
    }
}
