package com.moviesandchill.film.service.repositories;

import com.moviesandchill.film.service.domain.ViewHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ViewHistoryRepository  extends JpaRepository<ViewHistory, Long> {
}
