package ru.example.seminar6.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.example.seminar6.model.Note;
import ru.example.seminar6.service.NoteServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/note")
@RequiredArgsConstructor
public class NoteController {
    public final NoteServiceImpl noteService;
    @GetMapping()
    public ResponseEntity<List<Note>> getAll(){
        return new ResponseEntity<>(noteService.getAllNotes(), HttpStatus.OK);
    }
    @GetMapping("{id}")
    public ResponseEntity<Note> getById(@PathVariable Long id){
        return new ResponseEntity<>(noteService.getNoteById(id), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Note> addNote(@RequestBody Note note){
        return new ResponseEntity<>(noteService.createNote(note), HttpStatus.CREATED);
    }
    @PutMapping
    public ResponseEntity<Note> updateNote(@RequestBody Note note){
        return new ResponseEntity<>(noteService.updateNote(note), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        noteService.deleteNote(id);
        return ResponseEntity.ok().build();
    }


}
