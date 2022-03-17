package com.bird.demo.domain.service;

import com.bird.demo.domain.model.Birds;
import com.bird.demo.domain.model.Note;
import com.bird.demo.domain.repository.BirdRepository;
import com.bird.demo.domain.repository.NoteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteService {
    private NoteRepository noteRepository;

    public NoteService(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    public Note saveNote(Note note){
        return noteRepository.save(note);
    }

    public List<Note> notesPerBird(Birds birds){
        return noteRepository.findAllByBirds(birds);
    }
}
