package edu.cpp.hci.scrapers.koofers.model.rating.impl;

import edu.cpp.hci.scrapers.rmp.json.RateMyProfessorRatingRawJsonDTO;
import edu.cpp.hci.scrapers.rmp.model.rating.RMPRatingDTO;
import edu.cpp.hci.scrapers.rmp.model.rating.impl.RMPRating;

import java.util.List;

public class KoofersRatingBuilder {
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
        KoofersRatingBuilder builder = new KoofersRatingBuilder();
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

    public KoofersRatingBuilder setId(int id) {
        this.id = id;
        return this;
    }

    public KoofersRatingBuilder setDate(String date) {
        this.date = date;
        return this;
    }

    public KoofersRatingBuilder setDescription(String description) {
        this.description = description;
        return this;
    }

    public KoofersRatingBuilder setOverallQuality(int overallQuality) {
        this.overallQuality = overallQuality;
        return this;
    }

    public KoofersRatingBuilder setLevelOfDifficulty(int levelOfDifficulty) {
        this.levelOfDifficulty = levelOfDifficulty;
        return this;
    }

    public KoofersRatingBuilder setClassName(String className) {
        this.className = className;
        return this;
    }

    public KoofersRatingBuilder setForCredit(String forCredit) {
        this.forCredit = forCredit;
        return this;
    }

    public KoofersRatingBuilder setAttendance(String attendance) {
        this.attendance = attendance;
        return this;
    }

    public KoofersRatingBuilder setTextBookUsed(String textBookUsed) {
        this.textBookUsed = textBookUsed;
        return this;
    }

    public KoofersRatingBuilder setWouldTakeAgain(String wouldTakeAgain) {
        this.wouldTakeAgain = wouldTakeAgain;
        return this;
    }

    public KoofersRatingBuilder setGradeReceived(String gradeReceived) {
        this.gradeReceived = gradeReceived;
        return this;
    }

    public KoofersRatingBuilder setTags(List<String> tags) {
        this.tags = tags;
        return this;
    }

    public KoofersRatingBuilder setRatingText(String ratingText) {
        this.ratingText = ratingText;
        return this;
    }

    public KoofersRatingBuilder setFoundHelpful(int foundHelpful) {
        this.foundHelpful = foundHelpful;
        return this;
    }

    public KoofersRatingBuilder setFoundUnhelpful(int foundUnhelpful) {
        this.foundUnhelpful = foundUnhelpful;
        return this;
    }

    public RMPRatingDTO createRateMyProfessorReviewDTO() {
        return new RMPRating(id, date, description, overallQuality, levelOfDifficulty, className,
                forCredit, attendance, textBookUsed, wouldTakeAgain, gradeReceived, tags, ratingText, foundHelpful,
                foundUnhelpful);
    }

}