package com.bird.demo.domain.repository;

import com.bird.demo.domain.model.Bird;
import com.bird.demo.domain.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoteRepository extends JpaRepository<Note, Long> {
    List<Note> findAllByBird (Bird bird); //Uma List tipo Note que é encontrada pelo tipo Bird.
}
