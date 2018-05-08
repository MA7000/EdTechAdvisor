package com.example.schooner.edtechadvisor;

import android.content.Intent;
import android.media.Rating;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.w3c.dom.Text;

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
        nameField = (TextView) findViewById(R.id.tool_name);
        nameField.setText(toolName);
        System.out.println("--------------------------------------WHY WON'T TOOL NAME WORK? " + toolName);

        database = FirebaseDatabase.getInstance();

    }

    public void onSubmit(View view) {
        // retrieve the values for each of the fields
        introduceContent = (CheckBox) findViewById(R.id.introducecontent);
        practiceContent = (CheckBox) findViewById(R.id.practicecontent);
        reviewContent = (CheckBox) findViewById (R.id.reviewcontent);
        studentDrivenInput = (EditText) findViewById (R.id.studentDriven);
        otherCommentsInput = (EditText) findViewById (R.id.othercomments);
        easinessInput = (RatingBar) findViewById (R.id.easeRatingBar);
        userFriendlinessInput = (RatingBar) findViewById (R.id.userEaseRatingBar);
        overAllInput = (RatingBar) findViewById (R.id.ratingBar);
        repeatTestInput = (CheckBox) findViewById (R.id.repeatTest);

        // update values to be stored in a review object

        intro = introduceContent.isChecked();
        prac = practiceContent.isChecked();
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

        DatabaseReference myRef = database.getReference("reviews").push();
        myRef.setValue(toolId);
//        myRef.setValue(currentReview);
        System.out.println("----------------------------------------------SUBMITTED");

//        introduceContent= (CheckBox) findViewById(R.id.introducecontent);
//        boolean introduceContentIsChecked= introduceContent.isChecked();
//
//        practiceContent= (CheckBox) findViewById(R.id.practicecontent);
//        boolean practiceContentIsChecked= practiceContent.isChecked();
//
//        CheckBox reviewContent= (CheckBox) findViewById(R.id.reviewcontent);
//        boolean reviewContentIsChecked= reviewContent.isChecked();
//
//        EditText studentDrivenInput = (EditText) findViewById(R.id.studentDriven);
//        String studentDriven= studentDrivenInput.getText().toString();
//
//        EditText otherCommentsInput = (EditText) findViewById(R.id.othercomments);
//        String otherComments= otherCommentsInput.getText().toString();
//
////        Rating bar needs to be declared and initialized with greater depth. If we want to simplify this in anyway, I'm down.
////        RatingBar easinessInput = (RatingBar) findViewById(R.id.easiness);
////        float easeRating = easinessInput.getRating();
//
//        CheckBox repeatTestInput= (CheckBox) findViewById(R.id.repeatTest);
//        boolean repeatTest= repeatTestInput.isChecked();

    }

}


