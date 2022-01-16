package com.devsuperior.dsvomie.repositories;

import com.devsuperior.dsvomie.entities.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long> {
}
