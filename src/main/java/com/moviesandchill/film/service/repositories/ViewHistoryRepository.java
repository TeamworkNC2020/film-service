package com.moviesandchill.film.service.repositories;

import com.moviesandchill.film.service.domain.View_history;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ViewHistoryRepository  extends JpaRepository<View_history, Long> {
}
