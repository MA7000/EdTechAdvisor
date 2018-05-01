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

import org.w3c.dom.Text;

//This page should lead users to write reviews of objects/tools

public class SuggestActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suggest);

        CheckBox introduceContent;
        CheckBox practiceContent;
        CheckBox reviewContent;
        EditText studentDrivenInput;
        EditText otherCommentsInput;
        RatingBar easinessInput;
        RatingBar userFriendlinessInput;
        RatingBar overAllInput;
        CheckBox repeatTestInput;

//        Couldn't figure out how to initalize it.
//        final RatingBar easeRatingBar = (RatingBar) findViewById(R.id.easiness);
    }

    public void onSubmit(View view) {
        CheckBox introduceContent= (CheckBox) findViewById(R.id.introducecontent);
        boolean introduceContentIsChecked= introduceContent.isChecked();

        CheckBox practiceContent= (CheckBox) findViewById(R.id.practicecontent);
        boolean practiceContentIsChecked= practiceContent.isChecked();

        CheckBox reviewContent= (CheckBox) findViewById(R.id.reviewcontent);
        boolean reviewContentIsChecked= reviewContent.isChecked();

        EditText studentDrivenInput = (EditText) findViewById(R.id.studentDriven);
        String studentDriven= studentDrivenInput.getText().toString();

        EditText otherCommentsInput = (EditText) findViewById(R.id.othercomments);
        String otherComments= otherCommentsInput.getText().toString();

//        Rating bar needs to be declared and initialized with greater depth. If we want to simplify this in anyway, I'm down.
//        RatingBar easinessInput = (RatingBar) findViewById(R.id.easiness);
//        float easeRating = easinessInput.getRating();

        CheckBox repeatTestInput= (CheckBox) findViewById(R.id.repeatTest);
        boolean repeatTest= repeatTestInput.isChecked();

    }

}


