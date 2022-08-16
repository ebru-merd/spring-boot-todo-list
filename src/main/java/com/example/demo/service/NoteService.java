package com.example.demo.service;

import com.example.demo.model.Note;
import com.example.demo.repository.NoteRepository;
import com.example.demo.service.Impl.NoteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteService implements NoteServiceImpl {
    @Autowired
    private NoteRepository noteRepository;
    @Override
    public Note createNote(Note note) {
        return noteRepository.save(note);
    }

    @Override
    public void deleteNote(Note note) {
        noteRepository.delete(note);
    }

    @Override
    public List<Note> getAll() {
        return noteRepository.findAll();
    }

    @Override
    public List<Note> getAllNotesByUser(Long userId) {
        return noteRepository.findAllNotesByUser(userId);
    }

    @Override
    public Note getNoteById(Long id) {
        return noteRepository.findNoteById(id);
    }


}
