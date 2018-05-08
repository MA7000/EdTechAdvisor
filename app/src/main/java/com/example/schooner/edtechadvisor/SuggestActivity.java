package com.example.schooner.edtechadvisor;

import android.content.Intent;
import android.content.Context;
import android.media.Rating;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

//This page should lead users to write reviews of objects/tools

public class SuggestActivity extends AppCompatActivity {
    private String toolName;
    private String toolId;
    private TextView nameField;
    private CheckBox introduceContent;
    private CheckBox practiceContent;
    private CheckBox reviewContent;
    private EditText studentDrivenInput;
    private EditText otherCommentsInput;
    private RatingBar easinessInput;
    private RatingBar userFriendlinessInput;
    private RatingBar overAllInput;
    private CheckBox repeatTestInput;

    private boolean intro;
    private boolean prac;
    private boolean rev;
    private String stud;
    private String other;
    private float ease;
    private float user;
    private float over;
    private boolean rep;

    private Button reviewBtn;

    private ReviewObject currentReview;

    private FirebaseDatabase database;
    private DatabaseReference myRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suggest);


        // getting data passed into intent
        Intent suggestIntent = getIntent();
        toolId = suggestIntent.getStringExtra("ID_STRING");
        toolName = suggestIntent.getStringExtra("NAME_STRING");
        System.out.println("----------------------------------------------THIS IS MY TOOL ID: " + toolId);

        // set page title to the name of the tool being reviewed
        nameField = findViewById(R.id.tool_name);
        nameField.setText(toolName);
        System.out.println("--------------------------------------WHY WON'T TOOL NAME WORK? " + toolName);

        // retrieve the values for each of the fields
        introduceContent = findViewById(R.id.introducecontent);
        practiceContent = findViewById(R.id.practicecontent);
        reviewContent = findViewById (R.id.reviewcontent);
        studentDrivenInput = findViewById (R.id.studentDriven);
        otherCommentsInput = findViewById (R.id.othercomments);
        easinessInput = findViewById (R.id.easeRatingBar);
        userFriendlinessInput = findViewById (R.id.userEaseRatingBar);
        overAllInput = findViewById (R.id.ratingBar);
        repeatTestInput = findViewById (R.id.repeatTest);

        reviewBtn = findViewById(R.id.review_btn);

        database = FirebaseDatabase.getInstance();
        myRef = database.getReference("reviews");

        reviewBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v){
                // update values to be stored in a review object
                intro = introduceContent.isChecked();
                System.out.println("INTRO? " + intro);
                prac = practiceContent.isChecked();
                System.out.println("PRAC? " + prac);
                rev = reviewContent.isChecked();
                stud = studentDrivenInput.getText().toString();
                other = otherCommentsInput.getText().toString();
                ease = easinessInput.getRating();
                user = userFriendlinessInput.getRating();
                over = overAllInput.getRating();
                rep = repeatTestInput.isChecked();

                // create a new review object to be stored in the database
                currentReview = new ReviewObject(intro, prac, rev, stud, other, ease, user, over, rep);

                // get ready to access the database
                myRef.child(toolId).push().setValue(currentReview);
                System.out.println("----------------------------------------------SUBMITTED working");
            }
        } );
    }


}


