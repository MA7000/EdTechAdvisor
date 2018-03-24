//package com.example.schooner.edtechadvisor;
//
//import android.content.Context;
//import android.support.v7.widget.RecyclerView;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//
//import java.util.List;
//
///**
// * Created by Schooner on 3/21/2018.
// */
//
//public class PersonsAdapter extends RecyclerView.Adapter<PersonViewHolder>{
//    private List <Person> persons;
//    private Context context;
//
//    public PersonsAdapter (List<Person> persons, Context context){
//        this.persons=persons;
//        this.context = context;
//    }
//
//    @Override
//    public PersonViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_object,parent,false);
//                return new PersonViewHolder (view, context);
//
//    }
//
//    @Override
//    public void onBindViewHolder (PersonViewHolder holder, int position) {
//    Person person = persons.get(position);
//    holder.personName.setText(person.name);
//    holder.personInfo.setText(person.info);
//    holder.personPhoto.setImageResource(person.photoId);
//    }
//
//    @Override
//public int getItemCount() {
//        return persons.size();
//    }
//}
