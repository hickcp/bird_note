package com.bird.demo.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bird.demo.domain.model.Bird;

@Repository
public interface BirdRepository extends JpaRepository<Bird, Long> {
	List<Bird> findByNameIgnoreCase(String name);

	List<Bird> findByNameStartsWithIgnoreCase(String name);
}
