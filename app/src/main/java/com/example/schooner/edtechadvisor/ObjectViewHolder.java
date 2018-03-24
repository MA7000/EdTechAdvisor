package com.example.schooner.edtechadvisor;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
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


        public ObjectViewHolder (View itemView, final Context context) {
            super (itemView);
            cardView = (CardView) itemView.findViewById(R.id.card_view);
            toolName = (TextView) itemView.findViewById(R.id.tool_name);
            toolInfo = (TextView) itemView.findViewById(R.id.tool_info);
            toolPhoto= (ImageView) itemView.findViewById(R.id.object_logo);

            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick (View v){
                    Toast.makeText(context, toolName.getText(),Toast.LENGTH_SHORT).show();
                }
            } );

        }
    }
