package com.example.editablenotepad.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.editablenotepad.R;
import com.example.editablenotepad.interfaces.OnEditListener;
import com.example.editablenotepad.models.Note;

import java.util.ArrayList;
import java.util.List;

public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.NotesViewHolder> {

    Context context;
    List<Note> noteList = new ArrayList<>();
    private OnEditListener editListener;

    public NotesAdapter(Context context, List<Note> noteList, OnEditListener onEditListener) {
        this.context = context;
        this.noteList = noteList;
        this.editListener = onEditListener;
    }

    @Override
    public NotesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.row_note,parent,false);
        NotesViewHolder nvh = new NotesViewHolder(v);
        return nvh;
    }

    @Override
    public void onBindViewHolder(NotesViewHolder holder, int position) {
        holder.tvTitle.setText(noteList.get(position).getTitle());
        holder.tvNote.setText(noteList.get(position).getNote());
        holder.tvDate.setText(noteList.get(position).getDate());
        holder.itemView.setOnClickListener(e -> {
            editListener.editItem(noteList.get(position), position);
        });

    }

    @Override
    public int getItemCount() {
        return noteList.size();
    }

    public class NotesViewHolder extends RecyclerView.ViewHolder{

        TextView tvTitle,tvNote,tvDate;
        public NotesViewHolder(View itemView) {
            super(itemView);

            tvTitle = itemView.findViewById(R.id.tvNoteTitle);
            tvNote = itemView.findViewById(R.id.tvNoteText);
            tvDate = itemView.findViewById(R.id.tvNoteDate);

        }
    }

}
