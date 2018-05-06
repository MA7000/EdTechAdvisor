package com.example.schooner.edtechadvisor;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Schooner on 4/30/2018.
 */

public class Review extends AppCompatActivity {
    public String name;
    public String toolUse;
    public String studentDriven;
    public String otherComments;
    int objectId;
    EditText studentDrivenInput;
    EditText otherCommentsInput;
    float overallRatingInput;
    boolean repeatUseInputTF;
    EditText toolUseInput;
    CheckBox repeatUseInput;
    String repeatUse;
    TextView userNameResponse;
    public TextView userNameInput;
    public TextView answer1;
    public TextView answer2;
    public TextView answer3;
    public TextView answer6;
    public TextView answer7;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review_tool);


    }

    public Review(int objectId, String name, String toolUse, String studentDriven, String otherComments, String repeatUse) {
        this.objectId = objectId;
        this.name = name;
        this.toolUse = toolUse;
        this.studentDriven = studentDriven;
        this.otherComments = otherComments;
//            this.easeRating = easeRating;
//            this.userFRating = userFRating;
//            this.overallRating = overallRating;
        this.repeatUse = repeatUse;
    }

    public void addReview(View view) {
        submitReview();
    }

    public void submitReview() {
        int objectId = 12;

        EditText userNameInput = (EditText) findViewById(R.id.userNameInput);
        String userName = userNameInput.getText().toString();
        userNameResponse.setText(userName);

        CheckBox introduceContentInput = (CheckBox) findViewById(R.id.introducecontent);
        boolean introduceContent = introduceContentInput.isChecked();

        if  (introduceContent) {
            String toolUse = "Introduce content";
            answer1.setText(toolUse);
        }
        else {
            String toolUse = "..";
            answer1.setText(toolUse);
        }

        EditText studentDrivenInput = (EditText) findViewById(R.id.studentDrivenInput);
        String studentDriven = studentDrivenInput.getText().toString();
        answer2.setText(studentDriven);

        EditText otherCommentsInput = (EditText) findViewById(R.id.otherCommentsInput);
        String otherComments = otherCommentsInput.getText().toString();
        answer3.setText(otherComments);

        CheckBox repeatUseInput = (CheckBox) findViewById(R.id.repeatUseTest);
        boolean repeatTestInputTF = repeatUseInput.isChecked();
        if (repeatTestInputTF) {
            String repeatUse = "Yes";
            answer7.setText(repeatUse);
        } else {
            String repeatUse = "No";
            answer7.setText(repeatUse);
        }

        Review newReview = new Review(objectId, name, toolUse, studentDriven, otherComments, repeatUse);
     //   newReview.save();
    }

    public void goToSampleTool (View view) {
        Intent goToSampleTool= new Intent(this, SampleTool.class);
        startActivity(goToSampleTool);
    }
    public String getToolUse() {
        return toolUse;
    }

    public void setToolUse(String toolUse) {
        this.toolUse = toolUse;
    }
    public Review() {
    }

    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
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
    public String getRepeatUse() {
        return repeatUse;
    }

    public void setRepeatUse(String repeatUse) {
        this.repeatUse = repeatUse;
    }


    public float easeRating;
    public float userFRating;
    public float overallRating;
    public boolean repeatTest;
}



