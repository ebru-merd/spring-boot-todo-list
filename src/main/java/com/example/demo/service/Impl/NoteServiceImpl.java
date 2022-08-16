package com.example.demo.service.Impl;
import com.example.demo.model.Note;

import java.util.List;

public interface NoteServiceImpl {

    public Note createNote(Note note);
    public void deleteNote(Note note);
    List<Note> getAll();
    List<Note> getAllNotesByUser(Long userId);
    public Note getNoteById(Long id);


}

