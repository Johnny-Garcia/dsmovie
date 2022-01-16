package com.devsuperior.dsvomie.services;

import com.devsuperior.dsvomie.dto.MovieDTO;
import com.devsuperior.dsvomie.dto.ScoreDTO;
import com.devsuperior.dsvomie.entities.Movie;
import com.devsuperior.dsvomie.entities.Score;
import com.devsuperior.dsvomie.entities.User;
import com.devsuperior.dsvomie.repositories.MovieRepository;
import com.devsuperior.dsvomie.repositories.ScoreRepository;
import com.devsuperior.dsvomie.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ScoreService {

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ScoreRepository scoreRepository;

    @Transactional
    public MovieDTO saveScore(ScoreDTO scoreDTO){
        User user = userRepository.findByEmail(scoreDTO.getEmail());
        if (user == null){
            user = new User();
            user.setEmail(scoreDTO.getEmail());
            userRepository.saveAndFlush(user);
        }
        Movie movie = movieRepository.findById(scoreDTO.getMovieId()).get();

        Score score = new Score();
        score.setMovie(movie);
        score.setUser(user);
        score.setValue(scoreDTO.getScore());
        scoreRepository.saveAndFlush(score);

        double sum = 0.0;
        for (Score s : movie.getScores()){
            sum = sum + s.getValue();
        }

        double avg = sum / movie.getScores().size();

        movie.setScore(avg);
        movie.setCount(movie.getScores().size());
        movieRepository.saveAndFlush(movie);

        return new MovieDTO(movie);
    }
}
