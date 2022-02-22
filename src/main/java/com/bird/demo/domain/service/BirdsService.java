package com.bird.demo.domain.service;

import com.bird.demo.domain.model.Birds;
import com.bird.demo.domain.repository.BirdRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BirdsService {
    private BirdRepository birdRepository;

    @Autowired
    public BirdsService(BirdRepository birdRepository) {
        this.birdRepository = birdRepository;
    }

    public Birds saveBirds(Birds b){
        return birdRepository.save(b);
    }
}
