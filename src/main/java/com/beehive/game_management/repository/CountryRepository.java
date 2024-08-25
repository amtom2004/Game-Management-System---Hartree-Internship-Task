package com.beehive.game_management.repository;

import com.beehive.game_management.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface CountryRepository extends JpaRepository<Country, Long> {
    List<Country> findByIso(String iso);
}
