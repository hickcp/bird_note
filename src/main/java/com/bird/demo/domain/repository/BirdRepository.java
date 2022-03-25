package com.bird.demo.domain.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bird.demo.domain.model.Bird;

@Repository
public interface BirdRepository extends JpaRepository<Bird, Long> {
	Optional<Bird> findByName(String name);
}
