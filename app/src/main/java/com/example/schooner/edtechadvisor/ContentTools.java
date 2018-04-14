package com.example.schooner.edtechadvisor;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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
 * Created by Schooner on 4/14/2018.
 */

public class ContentTools extends AppCompatActivity {
    private List<Object> tools;
    private ObjectsAdapter objectsAdapter;
    RecyclerView recyclerView;
    Object newTool;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content);

        initialData();

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
       recyclerView.setLayoutManager(new LinearLayoutManager(this));
        objectsAdapter = new ObjectsAdapter (tools, this);
        recyclerView.setAdapter(objectsAdapter);

    }

    private void initialData() {
        tools = new ArrayList<>();
        tools.add(new Object("Class Dojo", "Classroom Management App", R.drawable.classdojo2));
        tools.add(new Object("Socrative", "Formative Assessment Tool", R.drawable.socrative2));
        tools.add(new Object("Kahoot", "Formative Assessment Tool", R.drawable.kahoot2));
    }

 /*   public boolean onCreateOptionsMenu (Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.share:
                Toast.makeText(this, "Share it baby", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }*/

}
