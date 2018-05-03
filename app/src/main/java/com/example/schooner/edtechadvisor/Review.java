package com.example.schooner.edtechadvisor;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

/**
 * Created by Schooner on 4/30/2018.
 */

public class Review extends AppCompatActivity {
        public String name;
        public boolean toolUse;
        public String studentDriven;
        public String otherComments;
        EditText userNameInput;
        int objectId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review_tool);

    }

    public Review () {
    }

    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }

    public boolean isToolUse() {
        return toolUse;
    }

    public void setToolUse(boolean toolUse) {
        this.toolUse = toolUse;
    }

    public String getStudentDriven() {
        return studentDriven;
    }

    public void setStudentDriven(String studentDriven) {
        this.studentDriven = studentDriven;
    }

    public String getOtherComments() {
        return otherComments;
    }

    public void setOtherComments(String otherComments) {
        this.otherComments = otherComments;
    }

    public float getEaseRating() {
        return easeRating;
    }

    public void setEaseRating(float easeRating) {
        this.easeRating = easeRating;
    }

    public float getUserFRating() {
        return userFRating;
    }

    public void setUserFRating(float userFRating) {
        this.userFRating = userFRating;
    }

    public float getOverallRating() {
        return overallRating;
    }

    public void setOverallRating(float overallRating) {
        this.overallRating = overallRating;
    }

    public boolean isRepeatTest() {
        return repeatTest;
    }

    public void setRepeatTest(boolean repeatTest) {
        this.repeatTest = repeatTest;
    }

    public float easeRating;
        public float userFRating;
        public float overallRating;
        public boolean repeatTest;

        public Review (int objectId, boolean toolUse, String studentDriven, String otherComments,
                       float overallRating,boolean repeatTest) {
            this.objectId = objectId;
            this.name = name;
            this.toolUse = toolUse;
            this.studentDriven = studentDriven;
            this.otherComments = otherComments;
//            this.easeRating = easeRating;
//            this.userFRating = userFRating;
            this.overallRating = overallRating;
            this.repeatTest = repeatTest;
        }
    }


