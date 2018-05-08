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

        private List<ReviewObject> reviews;
        private Context context;

        public ReviewsAdapter (List<ReviewObject> reviews,Context context){
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
            ReviewObject review =reviews.get(position);
//            holder.userNameResponse.setText((CharSequence) review.userNameInput);
            holder.answer1.setText(review.getIntroduceContent() + review.getPracticeContent() + review.getReviewContent());
            holder.answer2.setText(review.studentDrivenInput);
            holder.answer3.setText (review.otherCommentsInput);
            holder.rating4.setRating(review.getEasinessInput());
            holder.rating5.setRating(review.getUserFriendlinessInput());
//            holder.answer4.setText(String.valueOf(review.getEasinessInput()));
//            holder.answer5.setText(String.valueOf(review.getUserFriendlinessInput()));
//            holder.answer6.setText (String.valueOf(review.getOverAllInput()));
            holder.answer7.setText (review.getRepeatTestInput());
            holder.rating6.setRating(review.getOverAllInput());
        }

        @Override
        public int getItemCount(){
            return reviews.size();
        }
    }

