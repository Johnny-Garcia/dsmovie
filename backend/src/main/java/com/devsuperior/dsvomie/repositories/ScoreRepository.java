package com.devsuperior.dsvomie.repositories;

import com.devsuperior.dsvomie.entities.Score;
import com.devsuperior.dsvomie.entities.ScorePK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScoreRepository extends JpaRepository<Score, ScorePK> {
}
