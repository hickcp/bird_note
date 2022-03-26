package com.bird.demo.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bird.demo.domain.model.Bird;
import com.bird.demo.domain.model.Note;
import com.bird.demo.domain.service.BirdService;
import com.bird.demo.domain.service.NoteService;

@CrossOrigin
@Controller
@RequestMapping(path = "/note")
public class NoteController {
	@Autowired
	private BirdService birdService;

	@Autowired
	private NoteService noteService;

	@PostMapping("/write")
	public ResponseEntity<Note> save(@RequestBody Note newNote) {
		String birdName = newNote.getBird().getName();

		if (birdName.length() > 1 && newNote.getComments().length() > 1) {
			Bird bird = birdService.findByName(birdName).get(0);

			newNote.setBird(bird);

			Note savedNote = noteService.save(newNote);

			return ResponseEntity.status(HttpStatus.CREATED).body(savedNote);
		}

		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);

	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Note>> all() {
		return ResponseEntity.ok(noteService.all());		
	}

}
