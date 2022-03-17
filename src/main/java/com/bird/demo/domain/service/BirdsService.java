package com.bird.demo.domain.service;

import com.bird.demo.domain.model.Birds;
import com.bird.demo.domain.repository.BirdRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BirdsService {
    private BirdRepository birdRepository;

    @Autowired
    public BirdsService(BirdRepository birdRepository) {
        this.birdRepository = birdRepository;
    }

    public Birds saveBirds(Birds b){
        b.getNotes().forEach(n -> n.setBirds(b));

        return birdRepository.save(b);
    }


    public Birds getBirds(String birdName){
        return birdRepository.findByBirdName(birdName).get();
    }

    public List<Birds> getLikeBirds(String birdName){
        return birdRepository.findByBirdNameLike(birdName);
    }


}
