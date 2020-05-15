package com.example.editablenotepad.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.editablenotepad.R;
import com.example.editablenotepad.models.Note;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.NotesViewHolder> {

    Context context;
    List<Note> noteList = new ArrayList<>();

    public NotesAdapter(Context context, List<Note> noteList) {
        this.context = context;
        this.noteList = noteList;
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
        holder.timestamp.setText(noteList.get(position).getTimestamp());
    }

    @Override
    public int getItemCount() {
        return noteList.size();
    }

    public class NotesViewHolder extends RecyclerView.ViewHolder{

        TextView tvTitle,tvNote, timestamp;
        public NotesViewHolder(View itemView) {
            super(itemView);

            tvTitle = itemView.findViewById(R.id.tvNoteTitle);
            tvNote = itemView.findViewById(R.id.tvNoteText);
            timestamp = itemView.findViewById(R.id.timestamp);

        }
    }

    public String formatDate(String dateStr) {
        try {
            SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date = fmt.parse(dateStr);
            SimpleDateFormat fmtOut = new SimpleDateFormat("MMM d");
            return fmtOut.format(date);
        }
        catch (ParseException e) {

        }

        return "";
    }

}
