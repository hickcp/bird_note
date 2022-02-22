package com.bird.demo.api;

import com.bird.demo.domain.service.BirdsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/bird")
public class BirdController {

    @Autowired
    private BirdsService birdsService;
    
    @Autowired
    private ApplicationEventPublisher publisher;
}
