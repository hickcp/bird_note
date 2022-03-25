package com.bird.demo.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bird.demo.domain.model.Bird;
import com.bird.demo.domain.service.BirdService;

@RestController
@RequestMapping(path = "/bird")
public class BirdController {

	@Autowired
	private BirdService birdService;

	@PostMapping("/write")
	public ResponseEntity<Bird> save(@RequestBody Bird bird) {
		Bird b = birdService.save(bird);

		return ResponseEntity.status(HttpStatus.CREATED).body(b);
	}

	@GetMapping("/search/{birdName}")
	public ResponseEntity<List<Bird>> search(@PathVariable String birdName) {

		return ResponseEntity.ok(birdService.findByNameStartsWith(birdName));
	}

	@GetMapping("/all")
	public ResponseEntity<List<Bird>> all() {
		return ResponseEntity.ok(birdService.all());
	}

}
