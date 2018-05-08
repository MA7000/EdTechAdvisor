package com.example.schooner.edtechadvisor;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
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


import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class MainActivity extends AppCompatActivity {
    private List<Object> tools= new ArrayList<>();
    private MainObjectsAdapter objectsAdapter;
    RecyclerView recyclerView;
    Object newTool;

    private FirebaseDatabase database;
    private DatabaseReference myRef;

//    member variables for authentication
    private FirebaseAuth msAuth;
    private FirebaseAuth.AuthStateListener authListener;
    private DatabaseReference userReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialData();

        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        LinearLayoutManager horizontalLayoutManager
                = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(horizontalLayoutManager);
        recyclerView.setHasFixedSize(true);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        objectsAdapter = new MainObjectsAdapter (tools, this);
        recyclerView.setAdapter(objectsAdapter);

/**
 * setting up the database to save the list of tools
 */
        database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("tools");
        myRef.setValue(tools);

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again whenever data at this location is updated.
                for (DataSnapshot postSnapshot: dataSnapshot.getChildren()) {
                    String name = postSnapshot.child("name").getValue(String.class);
                    String info = postSnapshot.child("info").getValue(String.class);
                    String imjId = postSnapshot.child("imageId").getValue(Long.class).toString();
                    String toolId = postSnapshot.child("toolId").getValue(String.class);
                    System.out.println("Tool: " + name + " | Image Id: " + imjId + " | Tool Id: " + toolId + " | Info: " + info);
                }
            }
            @Override
            public void onCancelled(DatabaseError error) {
                Toast.makeText(MainActivity.this, "Error loading Firebase", Toast.LENGTH_SHORT).show();
            }
        });

//        setting up authentication
        msAuth = FirebaseAuth.getInstance();
        userReference = database.getReference("HardCodedUser");

        authListener =  new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = msAuth.getCurrentUser();
                if (user == null){
                    System.out.println("HELLO. This user is not in the database");
                } else {
                    System.out.println("HELLO. This user is in the database");
                    userReference = database.getReference(user.getUid());
                }
            }
        };
    }

//recyclerview stuff//
    private void initialData() {
        tools.add(new Object("Class Dojo", "Classroom Management App", R.drawable.classdojo2, "management"));
        tools.add(new Object("Socrative", "Formative Assessment Tool", R.drawable.socrative2, "formative"));
        tools.add(new Object("Kahoot", "Formative Assessment Tool", R.drawable.kahoot2, "formative"));
        tools.add(new Object("Test Tool", "Classroom Management Tool", R.drawable.kahoot2, "management"));
    }

//below is menu stuff//
    public boolean onPrepareOptionsMenu(Menu menu) {
        FirebaseUser user = msAuth.getCurrentUser();
        if (user == null){
            invalidateOptionsMenu();
            getMenuInflater().inflate(R.menu.main_menu, menu);
            return super.onCreateOptionsMenu(menu);
        } else {
            invalidateOptionsMenu();
            getMenuInflater().inflate(R.menu.logged_in_menu, menu);
            return super.onCreateOptionsMenu(menu);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.share:
                Toast.makeText(this, "Sharing", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.setData(Uri.parse("mailto:")); // only email apps should handle this
                intent.putExtra(Intent.EXTRA_SUBJECT, "Check out this great app - EdTechAdvisor");
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }
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
    }
    public void login (MenuItem item) {
        Toast.makeText(this, "LOG ME IN!", Toast.LENGTH_SHORT).show();
        Intent goToLogin = new Intent(this, LoginActivity.class);
        startActivity(goToLogin);
    }

    public void logout (MenuItem item) {
        Toast.makeText(this, "YOU ARE NOW LOGGED OUT", Toast.LENGTH_SHORT).show();
        msAuth.signOut();
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

    protected void onStart() {
        super.onStart();
        msAuth.addAuthStateListener(authListener);
    }

    @Override
    public void onStop() {
        super.onStop();
        msAuth.removeAuthStateListener(authListener);
    }

}

