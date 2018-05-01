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


import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class MainActivity extends AppCompatActivity {
    private List<Object> tools= new ArrayList<>();;
    private ObjectsAdapter objectsAdapter;
    RecyclerView recyclerView;
    Object newTool;

    private FirebaseDatabase database;
    private DatabaseReference myRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialData();

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        LinearLayoutManager horizontalLayoutManager
                = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(horizontalLayoutManager);
        recyclerView.setHasFixedSize(true);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        objectsAdapter = new ObjectsAdapter (tools, this);
        recyclerView.setAdapter(objectsAdapter);

/**
 * setting up the database to save the list of tools
 */
        database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("toolsTest");
        myRef.setValue(tools);

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again whenever data at this location is updated.
                for (DataSnapshot postSnapshot: dataSnapshot.getChildren()) {
                    String name = postSnapshot.child("name").getValue(String.class);
                    String info = postSnapshot.child("info").getValue(String.class);
                    String objId = postSnapshot.child("objectId").getValue(Long.class).toString();
                    System.out.println("Tool: " + name + " | Id: " + objId + " | Info: " + info);
                }
            }
            @Override
            public void onCancelled(DatabaseError error) {
                Toast.makeText(MainActivity.this, "Error loading Firebase", Toast.LENGTH_SHORT).show();
            }
        });

    }
//recyclerview stuff//
    private void initialData() {
        tools.add(new Object("Class Dojo", "Classroom Management App", R.drawable.classdojo2, "management"));
        tools.add(new Object("Socrative", "Formative Assessment Tool", R.drawable.socrative2, "formative"));
        tools.add(new Object("Kahoot", "Formative Assessment Tool", R.drawable.kahoot2, "formative"));
        tools.add(new Object("Test Tool", "Classroom Management Tool", R.drawable.kahoot2, "management"));

    }
//below is menu stuff//
    public boolean onCreateOptionsMenu(Menu menu) {
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

    }


    public void viewLibrary(MenuItem item) {
        Toast.makeText(this, "Check out the Library.", Toast.LENGTH_SHORT).show();
        Intent goToLibrary = new Intent(this, Category.class);
        startActivity(goToLibrary);
    }

    public void viewTutorial(MenuItem item) {
        Toast.makeText(this, "Check out the Tutorial Section", Toast.LENGTH_SHORT).show();
        Intent goToTutorial = new Intent(this, Tutorials.class);
        startActivity(goToTutorial);
    }


    public void signup(MenuItem item) {
        Toast.makeText(this, "SIGN ME UP NOW!", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, SignUp.class);
        startActivity(intent);
//    }


    }

    public void goToLibrary (View view) {
        Toast.makeText(this, "Check out the Library.", Toast.LENGTH_SHORT).show();
        Intent goToLibrary = new Intent(this, Category.class);
        startActivity(goToLibrary);
    }

    public void suggestTool (View view) {
        Toast.makeText(this, "What has worked for you?", Toast.LENGTH_SHORT).show();
        Intent suggestTool = new Intent(this, SuggestActivity.class);
        startActivity(suggestTool);
    }

    public void goToTutorial (View view) {
        Toast.makeText(this, "What has worked for you?", Toast.LENGTH_SHORT).show();
        Intent goToTutorial= new Intent(this, Tutorials.class);
        startActivity(goToTutorial);
    }
}

