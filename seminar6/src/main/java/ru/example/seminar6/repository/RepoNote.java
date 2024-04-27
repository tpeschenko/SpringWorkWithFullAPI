package ru.example.seminar6.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.example.seminar6.model.Note;

import java.util.Optional;


@Repository
public interface RepoNote extends JpaRepository<Note, Long> {
}


