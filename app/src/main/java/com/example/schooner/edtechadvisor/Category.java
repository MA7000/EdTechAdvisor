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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);


        initialData();

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        objectsAdapter = new ObjectsAdapter(tools, this);
        recyclerView.setAdapter(objectsAdapter);

     //  Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
       //myToolbar.setSubtitle("Test");
        //myToolbar.inflateMenu(R.menu.sub_menu);
/*         setSupportActionBar(myToolbar);
        myToolbar.inflateMenu(R.menu.sub_menu);*/

    }

    private void initialData() {
        tools = new ArrayList<>();
        tools.add(new Object("Class Dojo", "Classroom Management App", R.drawable.classdojo2));
        tools.add(new Object("Socrative", "Formative Assessment Tool", R.drawable.socrative2));
        tools.add(new Object("Kahoot", "Formative Assessment Tool", R.drawable.kahoot2));
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.main_menu, menu);
//        return true;
//    }
@Override
public boolean onCreateOptionsMenu(Menu menu) {
getMenuInflater().inflate(R.menu.sub_menu, menu);
return super.onCreateOptionsMenu(menu);
}
//
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.save:
                Toast.makeText(this, "Saved", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.share:
                Toast.makeText(this, "Share it baby", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.star:
                Toast.makeText(this, "Added to My Library", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.add:
                tools.add(addRandomObject());
                objectsAdapter.notifyDataSetChanged();
            default:
                return super.onOptionsItemSelected(item);
        }

    }

    private Object addRandomObject() {
        int num = (int) (Math.random() * 3);
        if (num == 0)
            return new Object("Class Dojo", "Classroom Management App", R.drawable.classdojo);
        else if (num == 1)
            return new Object("Socrative", "Formative Assessment Tool", R.drawable.socrative);
        else
            return new Object("Kahoot", "Formative Assessment Tool", R.drawable.kahoot);
    }


    public void signup(MenuItem item) {
        Toast.makeText(this, "SIGN ME UP NOW!", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, Tutorial.class);
        startActivity(intent);
    }
}






