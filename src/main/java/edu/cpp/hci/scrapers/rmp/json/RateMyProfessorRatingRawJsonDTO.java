package edu.cpp.hci.scrapers.rmp.json;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)

public class RateMyProfessorRatingRawJsonDTO {
    private int id;
    private String attendance;
    private int helpCount;
    private int notHelpCount;
    private String quality;
    private String onlineClass;
    private int rClarity;
    private String rClass;
    private String rComments;
    private String rDate;
    private int rEasy;
    private String rOverallString;
    private String rTextBookUse;
    private String rWouldTakeAgain;
    private String takenForCredit;
    private List<String> teacherRatingTags;
    private String teacherGrade;

    public RateMyProfessorRatingRawJsonDTO() {
    }

    public RateMyProfessorRatingRawJsonDTO(int id, String attendance, int helpCount, int notHelpCount, String quality,
                                           String onlineClass, int rClarity, String rClass, String rComments,
                                           String rDate, int rEasy, String rOverallString, String rTextBookUse,
                                           String rWouldTakeAgain, String takenForCredit, List<String> teacherRatingTags,
                                           String teacherGrade) {
        this.id = id;
        this.attendance = attendance;
        this.helpCount = helpCount;
        this.notHelpCount = notHelpCount;
        this.quality = quality;
        this.onlineClass = onlineClass;
        this.rClarity = rClarity;
        this.rClass = rClass;
        this.rComments = rComments;
        this.rDate = rDate;
        this.rEasy = rEasy;
        this.rOverallString = rOverallString;
        this.rTextBookUse = rTextBookUse;
        this.rWouldTakeAgain = rWouldTakeAgain;
        this.takenForCredit = takenForCredit;
        this.teacherRatingTags = teacherRatingTags;
        this.teacherGrade = teacherGrade;
    }

    public String getTeacherGrade() {
        return teacherGrade;
    }

    public void setTeacherGrade(String teacherGrade) {
        this.teacherGrade = teacherGrade;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAttendance() {
        return attendance;
    }

    public void setAttendance(String attendance) {
        this.attendance = attendance;
    }

    public int getHelpCount() {
        return helpCount;
    }

    public void setHelpCount(int helpCount) {
        this.helpCount = helpCount;
    }

    public int getNotHelpCount() {
        return notHelpCount;
    }

    public void setNotHelpCount(int notHelpCount) {
        this.notHelpCount = notHelpCount;
    }

    public String getQuality() {
        return quality;
    }

    public void setQuality(String quality) {
        this.quality = quality;
    }

    public String getOnlineClass() {
        return onlineClass;
    }

    public void setOnlineClass(String onlineClass) {
        this.onlineClass = onlineClass;
    }

    public int getrClarity() {
        return rClarity;
    }

    public void setrClarity(int rClarity) {
        this.rClarity = rClarity;
    }

    public String getrClass() {
        return rClass;
    }

    public void setrClass(String rClass) {
        this.rClass = rClass;
    }

    public String getrComments() {
        return rComments;
    }

    public void setrComments(String rComments) {
        this.rComments = rComments;
    }

    public String getrDate() {
        return rDate;
    }

    public void setrDate(String rDate) {
        this.rDate = rDate;
    }

    public int getrEasy() {
        return rEasy;
    }

    public void setrEasy(int rEasy) {
        this.rEasy = rEasy;
    }

    public String getrOverallString() {
        return rOverallString;
    }

    public void setrOverallString(String rOverallString) {
        this.rOverallString = rOverallString;
    }

    public String getrTextBookUse() {
        return rTextBookUse;
    }

    public void setrTextBookUse(String rTextBookUse) {
        this.rTextBookUse = rTextBookUse;
    }

    public String getrWouldTakeAgain() {
        return rWouldTakeAgain;
    }

    public void setrWouldTakeAgain(String rWouldTakeAgain) {
        this.rWouldTakeAgain = rWouldTakeAgain;
    }

    public String getTakenForCredit() {
        return takenForCredit;
    }

    public void setTakenForCredit(String takenForCredit) {
        this.takenForCredit = takenForCredit;
    }

    public List<String> getTeacherRatingTags() {
        return teacherRatingTags;
    }

    public void setTeacherRatingTags(List<String> teacherRatingTags) {
        this.teacherRatingTags = teacherRatingTags;
    }
}
