package com.bird.demo.api;

import com.bird.demo.domain.event.ResourceCreatedEvent;
import com.bird.demo.domain.model.Birds;
import com.bird.demo.domain.model.Note;
import com.bird.demo.domain.repository.BirdRepository;
import com.bird.demo.domain.service.BirdsService;
import com.bird.demo.domain.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;

@CrossOrigin
@Controller
@RequestMapping(path = "/note")
public class NoteController {
    @Autowired
    private BirdRepository birdRepository;
    @Autowired
    private NoteService noteService;
    @Autowired
    private ApplicationEventPublisher publisher;
    @Autowired
    private BirdsService birdsService;



    public NoteController(BirdRepository birdRepository, NoteService noteService, ApplicationEventPublisher publisher, BirdsService birdsService) {
        this.birdRepository = birdRepository;
        this.noteService = noteService;
        this.publisher = publisher;
        this.birdsService = birdsService;


    }

    @PostMapping("/write")
    public ResponseEntity<Object> noteSave(@Validated @RequestBody String birdName, Note note, HttpServletResponse response){
        Birds birds = birdRepository.findByBirdName(birdName).get();
        note.setBirds(birds);
        Note n = noteService.saveNote(note);
        publisher.publishEvent(new ResourceCreatedEvent(this, response, n.getId()));
        return ResponseEntity.status(HttpStatus.CREATED).body(n);

    }


}

