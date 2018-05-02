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
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;
import android.app.ActionBar;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by Schooner on 4/28/2018.
 */

public class SampleTool extends AppCompatActivity {
    private View toolCard;
    private Button learnMore;
    private Button review;
    private boolean userState;
    private TextView toolName;
    private String name;

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
        learnMore = (Button) toolCard.findViewById(R.id.learn);
        learnMore.setVisibility(View.GONE);
        review = (Button) toolCard.findViewById(R.id.review);
        toolName = (TextView) toolCard.findViewById(R.id.tool_name);
        name = toolName.getText().toString();

        //        setting up authentication
        msAuth = FirebaseAuth.getInstance();

//        authListener =  new FirebaseAuth.AuthStateListener() {
//            @Override
//            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
//                FirebaseUser user = msAuth.getCurrentUser();
//                if (user == null){
//                    userState = false;
//                    System.out.println("HELLO. This user is not in the database");
//                } else {
//                    userReference = database.getReference(user.getUid());
//                    userState = true;
//                    System.out.println("HELLO. This user is in the database" + " | STATE = " + userState);
//                }
//            }
//        };

        review.setOnClickListener(new View.OnClickListener() {
            FirebaseUser user = msAuth.getCurrentUser();
            @Override
            public void onClick (View v){
                String text = toolName.getText().toString();
                if (user != null) {
                    Toast.makeText(SampleTool.this, text ,Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent (SampleTool.this, SuggestActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(SampleTool.this, "Please log in to review this tool." ,Toast.LENGTH_SHORT).show();
                }
            }
        } );
    }


}

