package com.bird.demo.domain.repository;

import com.bird.demo.domain.model.Birds;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BirdRepository extends JpaRepository<Birds, Long> {
}
