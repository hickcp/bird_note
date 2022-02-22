package com.bird.demo.api;

import com.bird.demo.domain.model.Birds;
import com.bird.demo.domain.service.BirdsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping(path = "/bird")
public class BirdController {

    @Autowired
    private BirdsService birdsService;
    
    @Autowired
    private ApplicationEventPublisher publisher;

    public BirdController(BirdsService birdsService, ApplicationEventPublisher publisher) {
        this.birdsService = birdsService;
        this.publisher = publisher;
    }

    @PostMapping("/write")
    public ResponseEntity<Birds> salvar(@Validated @RequestBody Birds birds, HttpServletResponse response){

        Birds b = birdsService.saveBirds(birds);
        return ResponseEntity.status(HttpStatus.CREATED).body(b);
    }

}
