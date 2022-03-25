package com.bird.demo.domain.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bird.demo.domain.model.Bird;
import com.bird.demo.domain.model.Note;
import com.bird.demo.domain.repository.NoteRepository;

@Service
public class NoteService {
	private NoteRepository noteRepository;

	public NoteService(NoteRepository noteRepository) {
		this.noteRepository = noteRepository;
	}

	public Note saveNote(Note note) {
		return noteRepository.save(note);
	}

	public List<Note> notesPerBird(Bird bird) {
		return noteRepository.findAllByBird(bird);
	}
}
