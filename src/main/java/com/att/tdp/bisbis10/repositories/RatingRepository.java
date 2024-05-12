package com.att.tdp.bisbis10.repositories;

import com.att.tdp.bisbis10.entities.Rating;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RatingRepository extends JpaRepository<Rating, Long> {
}
