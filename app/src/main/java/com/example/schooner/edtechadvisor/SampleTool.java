package com.example.schooner.edtechadvisor;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;
import android.app.ActionBar;
import android.view.View;

/**
 * Created by Schooner on 4/28/2018.
 */

public class SampleTool extends AppCompatActivity {
    private List <Review> reviews;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sampletool);

        initialData();

        RecyclerView rerecyclerview = findViewById(R.id.review_recycler_view);
        rerecyclerview.setHasFixedSize(true);
        rerecyclerview.setLayoutManager(new LinearLayoutManager(this));
        rerecyclerview.setAdapter(new ReviewsAdapter(reviews, this));





    }



    private void initialData (){
        reviews = new ArrayList<>();
        reviews.add (new Review (12, "Bellatrix","Introduce content","Students can monitor their own progress", "Parents can be involved but don't have to be.", "Yes"));
        reviews.add (new Review (12, "Tom", "Introduce content", "Students can get feedback about their performance", "Sometimes malfunctions midway", "No"));
        reviews.add (new Review (12, "Hagrid", "...", "Allows students to keep track of their behavior", "The monsters are really cute.", "Yes"));
        reviews.add (new Review (13, "Hermione","Introduce content",  "Students can answer questions in live time!", "Can get too competitive sometimes.", "Yes"));
        reviews.add (new Review (14, "Ron", "Introduce content", "Students can respond to questions and get feedback instantly.", "It's like a calmer version of Kahoot.", "Yes"));

    }

    public void goReview (View view) {
        Intent goReview = new Intent(this, Review.class);
        startActivity(goReview);
    }



}
