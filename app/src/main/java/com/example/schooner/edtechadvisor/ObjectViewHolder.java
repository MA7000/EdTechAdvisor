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
        public Button toolLearn;
        public Button toolReview;



        public ObjectViewHolder (View itemView, final Context context) {
            super (itemView);
            cardView = (CardView) itemView.findViewById(R.id.card_view);
            toolName = (TextView) itemView.findViewById(R.id.tool_name);
            toolInfo = (TextView) itemView.findViewById(R.id.tool_info);
            toolPhoto= (ImageView) itemView.findViewById(R.id.object_logo);
            toolLearn = (Button) itemView.findViewById(R.id.learn);
            toolReview = (Button) itemView.findViewById(R.id.review);

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
                    context.startActivity(intent);
                }
            } );

            toolReview.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick (View v){
                    Toast.makeText(context, toolName.getText(),Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent (context, SuggestActivity.class);
                    context.startActivity(intent);
                }
            } );


        }
    }
