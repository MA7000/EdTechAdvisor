package com.example.schooner.edtechadvisor;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
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

/**
 * Created by Schooner on 4/28/2018.
 */

public class SampleTool extends AppCompatActivity {
    private View toolCard;
    private Button learnMore;
    private Button review;
    private boolean userState;
    private TextView toolName;
    private TextView toolInfo;
    private ImageView logo;
    private String name;
    private String toolId;
    private List <ReviewObject> reviews;
    private String info;
    private String imjId;
    private String tag;

    private FirebaseDatabase database;

    //    member variables for authentication
    private FirebaseAuth msAuth;
    private FirebaseAuth.AuthStateListener authListener;
    private DatabaseReference userReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sampletool);

        toolCard = findViewById(R.id.card_view_object3);
        learnMore = toolCard.findViewById(R.id.learn);
        learnMore.setVisibility(View.GONE);
        review = toolCard.findViewById(R.id.review);
        toolName = toolCard.findViewById(R.id.tool_name);
        toolInfo = toolCard.findViewById(R.id.tool_info);
        logo = toolCard.findViewById(R.id.object_logo);

//        name = toolName.getText().toString();

        initialData();
        RecyclerView rerecyclerview = findViewById(R.id.review_recycler_view);
        rerecyclerview.setHasFixedSize(true);
        rerecyclerview.setLayoutManager(new LinearLayoutManager(this));
        rerecyclerview.setAdapter(new ReviewsAdapter(reviews, this));

        Intent suggestIntent = getIntent();
        name = suggestIntent.getStringExtra("NAME_STRING");
        System.out.println("-----------------------------------THIS IS MY SENT NAME = " + name);
        toolName.setText(name);



        //        setting up authentication
        msAuth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("tools");

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again whenever data at this location is updated.
                for (DataSnapshot postSnapshot: dataSnapshot.getChildren()) {
                    String dbName = postSnapshot.child("name").getValue(String.class);
                    System.out.println("-----------------------------------THIS IS MY VARIABLE DB NAME = " + dbName);
                    if (dbName.equals(name)) {
                        toolId = postSnapshot.child("toolId").getValue(String.class);
                        String info = postSnapshot.child("info").getValue(String.class);
                        toolInfo.setText(info);
                        int imjId = postSnapshot.child("imageId").getValue(int.class);
                        logo.setImageResource(imjId);
                        String tag = postSnapshot.child("tag").getValue(String.class);
                        System.out.println("TOOL ID: " + toolId);

                        return;
                    } else {
                        System.out.println("The names are not equal.");
                    }
                }
            }


            @Override
            public void onCancelled(DatabaseError error) {
                Toast.makeText(SampleTool.this, "Error loading Firebase", Toast.LENGTH_SHORT).show();
            }
        });




        // listen for clicks on the Review button
        review.setOnClickListener(new View.OnClickListener() {
            FirebaseUser user = msAuth.getCurrentUser();
            @Override
            public void onClick (View v){
                String text = toolName.getText().toString();
                if (user != null) {
                    Toast.makeText(SampleTool.this, text ,Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent (SampleTool.this, SuggestActivity.class);
                    intent.putExtra("ID_STRING", toolId.toString());
                    intent.putExtra("NAME_STRING", name.toString());
                    startActivity(intent);
                } else {
                    Toast.makeText(SampleTool.this, "Please log in to review this tool." ,Toast.LENGTH_SHORT).show();
                }
            }
        } );}

        private void initialData (){
            reviews = new ArrayList<>();
            reviews.add (new ReviewObject (true,false, true,"Students can monitor their own progress", "Parents can be involved but don't have to be.", 3, 4, 3, true));
            reviews.add (new ReviewObject (false,false, true,"Students can get feedback about their performance", "Sometimes malfunctions midway", 2, 2, 2, false));
            reviews.add (new ReviewObject (true,true, true,"Allows students to keep track of their behavior", "The monsters are really cute.", 4, 4, 4, true));
            reviews.add (new ReviewObject (true,false, false,"Students can answer questions in live time!", "Can get too competitive sometimes.", 3, 3, 3, true));
            reviews.add (new ReviewObject (false,false, false,"Students can respond to questions and get feedback instantly.", "It's like a calmer version of Kahoot.", 5, 4, 4, true));
        }
    }



