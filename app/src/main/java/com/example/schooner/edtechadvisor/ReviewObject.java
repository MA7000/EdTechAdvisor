package com.example.schooner.edtechadvisor;

import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RatingBar;

/**
 * Created by anowens on 5/3/2018.
 */

public class ReviewObject {
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

    public boolean isIntroduceContent() {
        return introduceContent;
    }

    public void setIntroduceContent(boolean introduceContent) {
        this.introduceContent = introduceContent;
    }

    public boolean isPracticeContent() {
        return practiceContent;
    }

    public void setPracticeContent(boolean practiceContent) {
        this.practiceContent = practiceContent;
    }

    public boolean isReviewContent() {
        return reviewContent;
    }

    public void setReviewContent(boolean reviewContent) {
        this.reviewContent = reviewContent;
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

    public boolean isRepeatTestInput() {
        return repeatTestInput;
    }

    public void setRepeatTestInput(boolean repeatTestInput) {
        this.repeatTestInput = repeatTestInput;
    }
}
