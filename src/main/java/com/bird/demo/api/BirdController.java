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
import com.bird.demo.exceptions.TENenhumBirdEncontradoException;
import com.bird.demo.exceptions.TENomeNaoInformadoException;

@RestController
@RequestMapping(path = "/bird")
public class BirdController {

	@Autowired
	private BirdService birdService;

	@PostMapping("/write")
	public ResponseEntity<Bird> save(@RequestBody Bird bird) throws TENomeNaoInformadoException { //Faz o POST solicitando um corpo do tipo Bird
		
		Bird b = birdService.save(bird); // pega o bird para salvar
		if(ehBrancoNulo(b.getName())) throw new TENomeNaoInformadoException();
		return ResponseEntity.status(HttpStatus.CREATED).body(b); //retonar o bird salvo
	}

	@GetMapping("/search/{birdName}")
	public ResponseEntity<List<Bird>> search(@PathVariable String birdName) throws TENenhumBirdEncontradoException { // procura o Bird pelo nome com uma String
		if(birdService.findByName(birdName).isEmpty()) throw new TENenhumBirdEncontradoException();
		return ResponseEntity.ok(birdService.findByNameStartsWith(birdName)); // retorna o Bird que foi pesquisado
	}

	@GetMapping("/all")
	public ResponseEntity<List<Bird>> all() {
		return ResponseEntity.ok(birdService.all());
	} //retornam todos os Bird registrados.

	private boolean ehBrancoNulo(String s) {
		return "".equals(s) || s == null;
	}
}
