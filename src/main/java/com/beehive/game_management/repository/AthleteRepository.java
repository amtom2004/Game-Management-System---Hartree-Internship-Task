package com.beehive.game_management.repository;

import com.beehive.game_management.entity.Athlete;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface AthleteRepository extends JpaRepository<Athlete, Long> {
}
