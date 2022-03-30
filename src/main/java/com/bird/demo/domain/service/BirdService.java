package com.bird.demo.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bird.demo.domain.model.Bird;
import com.bird.demo.domain.repository.BirdRepository;

@Service
public class BirdService {
	@Autowired
	private BirdRepository birdRepository;

	public Bird save(Bird b) {
		return birdRepository.save(b);
	} //salva/POST no Bird.

	public List<Bird> all() {
		return birdRepository.findAll();
	} //Retorna todos os Bird
	
	public List<Bird> findByNameStartsWith(String name) {
		return birdRepository.findByNameStartsWithIgnoreCase(name);
	} // Retorna todos os Bird que começam com determinada palavra/letra
	
	public List<Bird> findByName(String name) {
		return birdRepository.findByNameIgnoreCase(name);
	} //Retorna o Bird pelo nome.

}
