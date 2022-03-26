package com.bird.demo.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bird.demo.domain.model.Bird;
import com.bird.demo.domain.model.Note;
import com.bird.demo.domain.repository.NoteRepository;

@Service
public class NoteService {
	@Autowired
	private NoteRepository noteRepository;

	public Note save(Note note) {
		return noteRepository.save(note);
	}

	public List<Note> birdNotes(Bird bird) {
		return noteRepository.findAllByBird(bird);
	}
	
	public List<Note> all() {
		return noteRepository.findAll();
	}
}
