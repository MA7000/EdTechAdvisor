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

}
