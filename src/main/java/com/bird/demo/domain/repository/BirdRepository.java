package com.bird.demo.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bird.demo.domain.model.Bird;

@Repository
public interface BirdRepository extends JpaRepository<Bird, Long> {
	List<Bird> findByNameIgnoreCase(String name); //Encontra o Bird pelo nome, ignorando a diferença entre maiúsculo e minúsculo.

	List<Bird> findByNameStartsWithIgnoreCase(String name); //Encontra o bird com o nome parecido, ignorando a diferença entre maiúsculo e minúsculo
}
