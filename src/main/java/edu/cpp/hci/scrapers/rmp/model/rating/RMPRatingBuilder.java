package edu.cpp.hci.scrapers.rmp.model.rating;

import edu.cpp.hci.scrapers.rmp.model.rating.impl.RMPRating;
import edu.cpp.hci.scrapers.rmp.json.RateMyProfessorRatingRawJsonDTO;

import java.util.List;

public class RMPRatingBuilder {
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

    public static RMPRatingDTO copyFromRawJson(RateMyProfessorRatingRawJsonDTO copy) {
        RMPRatingBuilder builder = new RMPRatingBuilder();
        builder.setAttendance(copy.getAttendance());
        builder.setId(copy.getId());
        builder.setClassName(copy.getrClass());
        builder.setDate(copy.getrDate());
        builder.setDescription(copy.getQuality());
        builder.setForCredit(copy.getTakenForCredit());
        builder.setGradeReceived(copy.getTeacherGrade());
        builder.setLevelOfDifficulty(copy.getrEasy());
        builder.setFoundHelpful(copy.getHelpCount());
        builder.setFoundUnhelpful(copy.getNotHelpCount());
        builder.setRatingText(copy.getrComments());
        builder.setOverallQuality(copy.getrClarity());
        builder.setForCredit(copy.getTakenForCredit());
        builder.setTextBookUsed(copy.getrTextBookUse());
        builder.setWouldTakeAgain(copy.getrWouldTakeAgain());
        builder.setTags(copy.getTeacherRatingTags());
        builder.createRateMyProfessorReviewDTO();
        return builder.createRateMyProfessorReviewDTO();
    }

    public RMPRatingBuilder setId(int id) {
        this.id = id;
        return this;
    }

    public RMPRatingBuilder setDate(String date) {
        this.date = date;
        return this;
    }

    public RMPRatingBuilder setDescription(String description) {
        this.description = description;
        return this;
    }

    public RMPRatingBuilder setOverallQuality(int overallQuality) {
        this.overallQuality = overallQuality;
        return this;
    }

    public RMPRatingBuilder setLevelOfDifficulty(int levelOfDifficulty) {
        this.levelOfDifficulty = levelOfDifficulty;
        return this;
    }

    public RMPRatingBuilder setClassName(String className) {
        this.className = className;
        return this;
    }

    public RMPRatingBuilder setForCredit(String forCredit) {
        this.forCredit = forCredit;
        return this;
    }

    public RMPRatingBuilder setAttendance(String attendance) {
        this.attendance = attendance;
        return this;
    }

    public RMPRatingBuilder setTextBookUsed(String textBookUsed) {
        this.textBookUsed = textBookUsed;
        return this;
    }

    public RMPRatingBuilder setWouldTakeAgain(String wouldTakeAgain) {
        this.wouldTakeAgain = wouldTakeAgain;
        return this;
    }

    public RMPRatingBuilder setGradeReceived(String gradeReceived) {
        this.gradeReceived = gradeReceived;
        return this;
    }

    public RMPRatingBuilder setTags(List<String> tags) {
        this.tags = tags;
        return this;
    }

    public RMPRatingBuilder setRatingText(String ratingText) {
        this.ratingText = ratingText;
        return this;
    }

    public RMPRatingBuilder setFoundHelpful(int foundHelpful) {
        this.foundHelpful = foundHelpful;
        return this;
    }

    public RMPRatingBuilder setFoundUnhelpful(int foundUnhelpful) {
        this.foundUnhelpful = foundUnhelpful;
        return this;
    }

    public RMPRatingDTO createRateMyProfessorReviewDTO() {
        return new RMPRating(id, date, description, overallQuality, levelOfDifficulty, className,
                forCredit, attendance, textBookUsed, wouldTakeAgain, gradeReceived, tags, ratingText, foundHelpful,
                foundUnhelpful);
    }

}