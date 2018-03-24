package com.example.schooner.edtechadvisor;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Object> tools;
    private ObjectsAdapter objectsAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        initialData();
//
//        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
//        recyclerView.setHasFixedSize(true);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//        objectsAdapter = new ObjectsAdapter (tools, this);
//        recyclerView.setAdapter(objectsAdapter);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

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

            //                tools.add(getRandomObject());
//                objectsAdapter.notifyDataSetChanged();
            default:
                return super.onOptionsItemSelected(item);
        }

    }


    public void viewLibrary(MenuItem item) {
        Toast.makeText(this, "Check out the Library.", Toast.LENGTH_SHORT).show();
        Intent goToLibrary = new Intent(this, Category.class);
        startActivity(goToLibrary);
    }


    public void signup(MenuItem item) {
        Toast.makeText(this, "SIGN ME UP NOW!", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, Tutorial.class);
        startActivity(intent);
//    }


    }
}

