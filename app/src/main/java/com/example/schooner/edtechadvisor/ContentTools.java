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

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

/**
 * Created by Schooner on 4/14/2018.
 */

public class ContentTools extends AppCompatActivity {
    private List<Object> tools =  new ArrayList<>();
    private ObjectsAdapter objectsAdapter;
    RecyclerView recyclerView;
    Object newTool;

    private FirebaseDatabase database;
    private DatabaseReference myRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content);

//        initialData();

        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
       recyclerView.setLayoutManager(new LinearLayoutManager(this));
        objectsAdapter = new ObjectsAdapter (tools, this);
        recyclerView.setAdapter(objectsAdapter);

        /**
         * setting up the database to save the list of tools
         */
        database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("tools");
//        myRef.setValue(tools);

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again whenever data at this location is updated.
                for (DataSnapshot postSnapshot: dataSnapshot.getChildren()) {
                    String tag = postSnapshot.child("tag").getValue(String.class);
                    if (tag.equals("management")) {
                        String name = postSnapshot.child("name").getValue(String.class);
                        System.out.println("----------------NAME----------------" + name);
                        String info = postSnapshot.child("info").getValue(String.class);
                        System.out.println("----------------INFO----------------" + info);

                        String objId = postSnapshot.child("imageId").getValue(Long.class).toString();
                        tools.add(new Object(name, info, Integer.parseInt(objId), tag));
                        System.out.println("Tool: " + name + " | Id: " + objId + " | Info: " + info + " | Tag: " + tag);
                    }
                }
            }
            @Override
            public void onCancelled(DatabaseError error) {
                Toast.makeText(ContentTools.this, "Error loading Firebase", Toast.LENGTH_SHORT).show();
            }
        });

    }

//    private void initialData() {
//        tools = new ArrayList<>();
//        tools.add(new Object("Class Dojo", "Classroom Management App", R.drawable.classdojo2));
//        tools.add(new Object("Socrative", "Formative Assessment Tool", R.drawable.socrative2));
//        tools.add(new Object("Kahoot", "Formative Assessment Tool", R.drawable.kahoot2));
//    }

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
