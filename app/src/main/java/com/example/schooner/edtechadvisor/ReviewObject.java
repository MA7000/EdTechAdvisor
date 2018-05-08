package com.example.schooner.edtechadvisor;

import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RatingBar;

import java.io.Serializable;

/**
 * Created by anowens on 5/3/2018.
 */

public class ReviewObject implements Serializable {
    public boolean introduceContent;
    public boolean practiceContent;
    public boolean reviewContent;
    public String studentDrivenInput;
    public String otherCommentsInput;
    public float easinessInput;
    public float userFriendlinessInput;
    public float overAllInput;
    public boolean repeatTestInput;

    public ReviewObject (boolean inro, boolean prac, boolean rev, String stu, String other, float eas, float usr, float overall, boolean rep) {
        this.introduceContent = inro;
        this.practiceContent = prac;
        this.reviewContent = rev;
        this.studentDrivenInput = stu;
        this.otherCommentsInput = other;
        this.easinessInput = eas;
        this.userFriendlinessInput = usr;
        this.overAllInput = overall;
        this.repeatTestInput = rep;
    }

    public void setEasinessInput(float easinessInput) {
        this.easinessInput = easinessInput;
    }

    public void setIntroduceContent(boolean introduceContent) {
        this.introduceContent = introduceContent;
    }

    public String getIntroduceContent () {
        if (this.introduceContent == true) {
            return "To Introduce Content, ";
        } else {
            return "";
        }
    }

    public void setPracticeContent(boolean practiceContent) {
        this.practiceContent = practiceContent;
    }

    public String getPracticeContent () {
        if (this.practiceContent == true) {
            return "To Practice Content, ";
        } else {
            return "";
        }
    }

    public void setReviewContent(boolean reviewContent) {
        this.reviewContent = reviewContent;
    }

    public String getReviewContent () {
        if (this.introduceContent == true) {
            return "To Review Content";
        } else {
            return "";
        }
    }

    public String getStudentDrivenInput() {
        return studentDrivenInput;
    }

    public void setStudentDrivenInput(String studentDrivenInput) {
        this.studentDrivenInput = studentDrivenInput;
    }

    public String getOtherCommentsInput() {
        return otherCommentsInput;
    }

    public void setOtherCommentsInput(String otherCommentsInput) {
        this.otherCommentsInput = otherCommentsInput;
    }

    public float getEasinessInput() {
        return easinessInput;
    }

    public float getUserFriendlinessInput() {
        return userFriendlinessInput;
    }

    public void setUserFriendlinessInput(float userFriendlinessInput) {
        this.userFriendlinessInput = userFriendlinessInput;
    }

    public float getOverAllInput() {
        return overAllInput;
    }

    public void setOverAllInput(float overAllInput) {
        this.overAllInput = overAllInput;
    }

    public void setRepeatTestInput(boolean repeatTestInput) {
        this.repeatTestInput = repeatTestInput;
    }

    public String getRepeatTestInput () {
        if (this.repeatTestInput == true) {
            return "yes";
        } else {
            return "no";
        }
    }
}
