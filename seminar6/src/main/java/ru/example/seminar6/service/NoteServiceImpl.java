package ru.example.seminar6.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.example.seminar6.model.Note;
import ru.example.seminar6.repository.RepoNote;

import java.util.List;


@Service
@RequiredArgsConstructor
public class NoteServiceImpl implements ServiceNote{
    public final RepoNote repoNote;
    @Override
    public List<Note> getAllNotes() {
        return repoNote.findAll();
    }

    @Override
    public Note getNoteById(Long id) {
        return repoNote.findById(id).orElseThrow(null);
    }

    @Override
    public Note updateNote(Note note) {
        Note noteById = getNoteById(note.getId());
        noteById.setTitle(note.getTitle());
        noteById.setDescription(note.getDescription());

        return repoNote.save(noteById);
    }

    @Override
    public Note createNote(Note note) {
        return repoNote.save(note);
    }

    @Override
    public void deleteNote(Long id) {
        Note noteById = getNoteById(id);
        repoNote.delete(noteById);
    }
}
