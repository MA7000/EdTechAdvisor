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
 * Created by Schooner on 3/24/2018.
 */

public class Category extends AppCompatActivity {
    private List<Object> tools;
    private ObjectsAdapter objectsAdapter;
    private Toolbar myToolbar;
    RecyclerView recyclerView;
    Object newTool;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
    }

//    private void initialData() {
//        tools = new ArrayList<>();
//        tools.add(new Object("Class Dojo", "Classroom Management App", R.drawable.classdojo2));
//        tools.add(new Object("Socrative", "Formative Assessment Tool", R.drawable.socrative2));
//        tools.add(new Object("Kahoot", "Formative Assessment Tool", R.drawable.kahoot2));
//    }

    //these are intents that go to the tool category pages//
    public void goToAdminTools(View view) {
        Intent goToAdminTools = new Intent(this, AdminTools.class);
        startActivity(goToAdminTools);
    }

    public void goToContentTools (View view) {
        Intent goToContentTools= new Intent(this, ContentTools.class);
        startActivity(goToContentTools);
    }

    public void goToTutorial(View view) {
        Toast.makeText(this, "What has worked for you?", Toast.LENGTH_SHORT).show();
        Intent goToTutorial = new Intent(this, Tutorials.class);
        startActivity(goToTutorial);
    }
}






