package com.bird.demo.api;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bird.demo.domain.model.Bird;
import com.bird.demo.domain.model.Note;
import com.bird.demo.domain.repository.BirdRepository;
import com.bird.demo.domain.service.NoteService;

@CrossOrigin
@Controller
@RequestMapping(path = "/note")
public class NoteController {
	@Autowired
	private BirdRepository birdRepository;

	@Autowired
	private NoteService noteService;

	@PostMapping("/write")
	public ResponseEntity<Object> noteSave(@RequestBody String birdName, Note note, HttpServletResponse response) {
		Bird birds = birdRepository.findByName(birdName).get();
		note.setBird(birds);
		Note n = noteService.saveNote(note);

		return ResponseEntity.status(HttpStatus.CREATED).body(n);
	}

}
