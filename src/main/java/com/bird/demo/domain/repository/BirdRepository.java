package com.bird.demo.domain.repository;

import com.bird.demo.domain.model.Birds;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Repository
public interface BirdRepository extends JpaRepository<Birds, Long> {

    Optional<Birds> findByBirdName(String birdName);


    @Query("FROM Birds c WHERE c.birdName LIKE %?1%")
    Optional<Birds> findByBirdNameLike(String birdName);
}
