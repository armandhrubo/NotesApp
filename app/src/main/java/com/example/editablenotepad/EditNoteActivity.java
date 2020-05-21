package com.example.editablenotepad;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.editablenotepad.database.DatabaseHandler;
import com.example.editablenotepad.models.Note;

import butterknife.BindView;
import butterknife.ButterKnife;

public class EditNoteActivity extends AppCompatActivity {

    @BindView(R.id.etTitle)
    EditText etTitle;

    @BindView(R.id.etNote)
    EditText etNote;

    private Note note;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_note);

        ButterKnife.bind(this);
        initNote();
    }

    private void initNote() {
        Intent intent = getIntent();

        if (intent != null) {
            note = (Note) intent.getSerializableExtra("SELECTED_NOTE");
            System.out.println("Note: " + note.getNote());

            etTitle.setText(note.getTitle());
            etNote.setText(note.getNote());
        }
    }

    private void updateNote(){

        note.setTitle(etTitle.getText().toString());
        note.setNote(etNote.getText().toString());

        if (note.getTitle().equals("") || note.getNote().equals("")) {
            showToast("Please fill all the fields before saving");
        }
        else {
            DatabaseHandler db = new DatabaseHandler(this);
            System.out.println("update method calling...");
            db.updateNote(note);
            db.close();

            Intent i = new Intent(EditNoteActivity.this,MainActivity.class);
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(i);

        }

    }

    public void editNote(View view) {
        updateNote();
    }

    private void showToast(String msg) {
        Toast.makeText(this,msg,Toast.LENGTH_SHORT);
    }
}
