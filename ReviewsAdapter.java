package com.example.schooner.edtechadvisor;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * Created by Schooner on 5/6/2018.
 */

public class ReviewsAdapter extends  RecyclerView.Adapter <ReviewViewHolder> {

        private List<Review> reviews;
        private Context context;

        public ReviewsAdapter (List<Review> reviews,Context context){
            this.reviews=reviews;
            this.context=context;
        }

        @Override
        public ReviewViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
            View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_review,parent,false);
            return new ReviewViewHolder(view, context);

        }

        @Override
        public void onBindViewHolder(ReviewViewHolder holder,int position){
            Review review =reviews.get(position);
            holder.userNameResponse.setText((CharSequence) review.userNameInput);
            holder.answer1.setText((CharSequence) review.answer1);
            holder.answer2.setText ((CharSequence)review.answer2);
            holder.answer3.setText ((CharSequence)review.answer3);
            holder.answer6.setText ((CharSequence)review.answer6);
            holder.answer7.setText ((CharSequence)review.answer7);
        }

        @Override
        public int getItemCount(){
            return reviews.size();
        }
    }

