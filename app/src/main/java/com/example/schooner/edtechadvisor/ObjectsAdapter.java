package com.example.schooner.edtechadvisor;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by Schooner on 3/24/2018.
 * connects object class to name, info, & photo for recycler view*
 */

public class ObjectsAdapter  extends RecyclerView.Adapter <ObjectViewHolder> {

    private List<Object> tools;
    private Context context;

    public ObjectsAdapter(List<Object> tools,Context context){
            this.tools=tools;
            this.context=context;
            }

    @Override
    public ObjectViewHolder onCreateViewHolder(ViewGroup parent,int viewType){
            View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_object,parent,false);
            return new ObjectViewHolder(view, context);

            }

    @Override
    public void onBindViewHolder(ObjectViewHolder holder,int position){
            Object object=tools.get(position);
            holder.toolName.setText(object.name);
            holder.toolInfo.setText(object.info);
            holder.toolPhoto.setImageResource(object.imageId);
            }

    @Override
    public int getItemCount(){
            return tools.size();
            }
            }

