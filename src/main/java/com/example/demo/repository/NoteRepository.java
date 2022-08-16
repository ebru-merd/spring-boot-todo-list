package com.example.demo.repository;

import com.example.demo.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface NoteRepository extends JpaRepository<Note,Long> {
    @Query(" select " +
            "n " +
            "from Note n join n.user " +
            "where n.user.id=:userId"
    )
    List<Note> findAllNotesByUser(Long userId);
    public Note findNoteById(Long id);

}

