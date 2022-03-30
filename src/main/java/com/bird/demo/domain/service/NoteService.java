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
	} //Salva o note

	public List<Note> birdNotes(Bird bird) {
		return noteRepository.findAllByBird(bird);
	} //Uma list de Note que é usado um tipo Bird para achar e retornar a list Note
	
	public List<Note> all() {
		return noteRepository.findAll();
	} //Retorna todos os note
}
