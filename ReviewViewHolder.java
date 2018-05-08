package com.example.schooner.edtechadvisor;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Schooner on 5/6/2018.
 */

public class ReviewViewHolder extends RecyclerView.ViewHolder {
    public CardView reviewCardView;
    public TextView userNameResponse;
    public TextView objectId;
    public TextView toolUse;
    public TextView answer1;
    public TextView studentDriven;
    public TextView answer2;
    public TextView otherComments;
    public TextView answer3;
    public TextView overallRating;
    public TextView answer6;
    public TextView repeatTest;
    public TextView answer7;


    public ReviewViewHolder(View itemView, final Context context) {
        super(itemView);

        reviewCardView = (CardView) itemView.findViewById(R.id.card_view_review);
        userNameResponse = (TextView) itemView.findViewById(R.id.userNameResponse);
        answer1 = (TextView) itemView.findViewById(R.id.answer1);
        answer2 = (TextView) itemView.findViewById(R.id.answer2);
        answer3 = (TextView) itemView.findViewById(R.id.answer3);
        answer6 = (TextView) itemView.findViewById(R.id.answer6);
        answer7 = (TextView) itemView.findViewById(R.id.answer7);

        reviewCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, userNameResponse.getText(), Toast.LENGTH_SHORT).show();

            }
        } );

    }
}