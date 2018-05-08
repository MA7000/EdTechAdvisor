package com.example.schooner.edtechadvisor;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Schooner on 3/24/2018.
 */

public class ObjectViewHolder extends RecyclerView.ViewHolder {

        public CardView cardView;
        public TextView toolName;
        public TextView toolInfo;
        public ImageView toolPhoto;
        public String toolId;
        public Button toolLearn;
        public Button toolReview;



        public ObjectViewHolder (View itemView, final Context context) {
            super (itemView);
            cardView = itemView.findViewById(R.id.card_view);
            toolName = itemView.findViewById(R.id.tool_name);
            toolInfo = itemView.findViewById(R.id.tool_info);
            toolPhoto= itemView.findViewById(R.id.object_logo);
            toolLearn = itemView.findViewById(R.id.learn);
            toolReview = itemView.findViewById(R.id.review);


//            this takes the user from the recyclerview to the specific tool page. it should take the user to a template that
//          autopopulates based on the tool clicked
//            and the reviews associated with it//

            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick (View v){
                    Toast.makeText(context, toolName.getText(),Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent (context, SampleTool.class);
                    context.startActivity(intent);
                }
            } );

            toolLearn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick (View v){
                    Toast.makeText(context, toolName.getText(),Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent (context, SampleTool.class);
                    intent.putExtra("NAME_STRING", toolName.getText().toString());
                    context.startActivity(intent);
                    System.out.println("THIS IS MY CARD VIEW WHAT IS THE NAME: " + toolName.getText().toString());
                }
            } );

        }
    }
