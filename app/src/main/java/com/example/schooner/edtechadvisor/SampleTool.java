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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sampletool);

    }

    public void goReview (View view) {
        Intent goReview = new Intent(this, Review.class);
        startActivity(goReview);
    }

}
