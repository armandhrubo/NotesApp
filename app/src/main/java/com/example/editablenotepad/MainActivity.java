package com.example.editablenotepad;

import android.content.Intent;
import android.os.Bundle;

import com.example.editablenotepad.adapters.NotesAdapter;
import com.example.editablenotepad.database.DatabaseHandler;
import com.example.editablenotepad.interfaces.OnEditListener;
import com.example.editablenotepad.models.Note;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements OnEditListener {

    @BindView(R.id.rvNotes)
    RecyclerView rvNotes;

    RecyclerView.Adapter adapter;
    List<Note> notesList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        initViews();
        loadNotes();

    }

    private void initViews() {

        rvNotes.setLayoutManager(new LinearLayoutManager(this));
    }

    private void loadNotes() {
        DatabaseHandler db = new DatabaseHandler(this);

        notesList = db.getAllNotes();

        if (notesList.size() != 0) {
            adapter = new NotesAdapter(this,notesList, this);
            rvNotes.setAdapter(adapter);
        }


    }

    @OnClick(R.id.fabAddNote)
    public void addNote() {
        Intent i = new Intent(MainActivity.this,AddNoteActivity.class);
        startActivity(i);
    }

    @Override
    public void editItem(Note note, int index) {
        System.out.println("noteId: " + note.getId());
        System.out.println("index: " + index);
        Intent intent = new Intent(this, EditNoteActivity.class);
        intent.putExtra("SELECTED_NOTE", note);
        startActivity(intent);
    }
}
