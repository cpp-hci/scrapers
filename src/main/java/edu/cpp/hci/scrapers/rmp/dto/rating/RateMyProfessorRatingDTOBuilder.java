package edu.cpp.hci.scrapers.rmp.dto.rating;

import edu.cpp.hci.scrapers.rmp.json.RateMyProfessorRatingRawJsonDTO;

import java.util.List;

public class RateMyProfessorRatingDTOBuilder {
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

    public static RateMyProfessorRatingDTO copyFromRawJson(RateMyProfessorRatingRawJsonDTO copy) {
        RateMyProfessorRatingDTOBuilder builder = new RateMyProfessorRatingDTOBuilder();
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

    public RateMyProfessorRatingDTOBuilder setId(int id) {
        this.id = id;
        return this;
    }

    public RateMyProfessorRatingDTOBuilder setDate(String date) {
        this.date = date;
        return this;
    }

    public RateMyProfessorRatingDTOBuilder setDescription(String description) {
        this.description = description;
        return this;
    }

    public RateMyProfessorRatingDTOBuilder setOverallQuality(int overallQuality) {
        this.overallQuality = overallQuality;
        return this;
    }

    public RateMyProfessorRatingDTOBuilder setLevelOfDifficulty(int levelOfDifficulty) {
        this.levelOfDifficulty = levelOfDifficulty;
        return this;
    }

    public RateMyProfessorRatingDTOBuilder setClassName(String className) {
        this.className = className;
        return this;
    }

    public RateMyProfessorRatingDTOBuilder setForCredit(String forCredit) {
        this.forCredit = forCredit;
        return this;
    }

    public RateMyProfessorRatingDTOBuilder setAttendance(String attendance) {
        this.attendance = attendance;
        return this;
    }

    public RateMyProfessorRatingDTOBuilder setTextBookUsed(String textBookUsed) {
        this.textBookUsed = textBookUsed;
        return this;
    }

    public RateMyProfessorRatingDTOBuilder setWouldTakeAgain(String wouldTakeAgain) {
        this.wouldTakeAgain = wouldTakeAgain;
        return this;
    }

    public RateMyProfessorRatingDTOBuilder setGradeReceived(String gradeReceived) {
        this.gradeReceived = gradeReceived;
        return this;
    }

    public RateMyProfessorRatingDTOBuilder setTags(List<String> tags) {
        this.tags = tags;
        return this;
    }

    public RateMyProfessorRatingDTOBuilder setRatingText(String ratingText) {
        this.ratingText = ratingText;
        return this;
    }

    public RateMyProfessorRatingDTOBuilder setFoundHelpful(int foundHelpful) {
        this.foundHelpful = foundHelpful;
        return this;
    }

    public RateMyProfessorRatingDTOBuilder setFoundUnhelpful(int foundUnhelpful) {
        this.foundUnhelpful = foundUnhelpful;
        return this;
    }

    public RateMyProfessorRatingDTO createRateMyProfessorReviewDTO() {
        return new RateMyProfessorRatingDTO(id, date, description, overallQuality, levelOfDifficulty, className,
                forCredit, attendance, textBookUsed, wouldTakeAgain, gradeReceived, tags, ratingText, foundHelpful,
                foundUnhelpful);
    }

}