package com.example.editablenotepad.interfaces;

import com.example.editablenotepad.models.Note;

public interface OnEditListener {
    public void editItem(Note note, int index);
}
