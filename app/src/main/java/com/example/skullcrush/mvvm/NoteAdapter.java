package com.example.skullcrush.mvvm;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import androidx.recyclerview.widget.RecyclerView;

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.NoteHolder> {

    private List<Note> notes = new ArrayList<>();

    @Override
    public NoteHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.note_item,parent,false);


        return new NoteHolder(view);
    }

    @Override
    public void onBindViewHolder(NoteHolder holder, int position) {

        Note currentnote =  notes.get(position);
        holder.textviewpriority.setText(String.valueOf(currentnote.getPriority()));
        holder.textViewtitle.setText(currentnote.getTitle());
        holder.textviewdesc.setText(currentnote.getDescription());

    }

    @Override
    public int getItemCount() {
        return notes.size();
    }
    public void setNotes(List<Note> note){
        this.notes = note;
        notifyDataSetChanged();

    }
    public Note getNoteAt(int position){

        return notes.get(position);

    }
    class NoteHolder extends RecyclerView.ViewHolder{

        private TextView textViewtitle,textviewdesc,textviewpriority;

        public NoteHolder(View itemView) {
            super(itemView);
            textviewdesc = itemView.findViewById(R.id.text_view_description);
            textViewtitle = itemView.findViewById(R.id.text_view_title);
            textviewpriority = itemView.findViewById(R.id.text_view_priority);
        }
    }
}
