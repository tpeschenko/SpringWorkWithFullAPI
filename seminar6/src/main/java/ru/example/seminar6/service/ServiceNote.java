package ru.example.seminar6.service;

import ru.example.seminar6.model.Note;

import java.util.List;
import java.util.Optional;

public interface ServiceNote {
    List<Note> getAllNotes();

    Note getNoteById(Long id);

    Note updateNote(Note product);

    Note createNote(Note product);

    void deleteNote(Long id);
}
