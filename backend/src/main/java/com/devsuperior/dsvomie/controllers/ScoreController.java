package com.devsuperior.dsvomie.controllers;

import com.devsuperior.dsvomie.dto.MovieDTO;
import com.devsuperior.dsvomie.dto.ScoreDTO;
import com.devsuperior.dsvomie.services.MovieService;
import com.devsuperior.dsvomie.services.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/score")
public class ScoreController {

    @Autowired
    private ScoreService scoreService;

    @PutMapping
    public MovieDTO saveScore(@RequestBody ScoreDTO scoreDTO){
        MovieDTO movieDTO = scoreService.saveScore(scoreDTO);
        return movieDTO;
    }

}
