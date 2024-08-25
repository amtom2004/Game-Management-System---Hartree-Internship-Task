package com.beehive.game_management.controller;

import com.beehive.game_management.entity.Athlete;
import com.beehive.game_management.entity.Country;
import com.beehive.game_management.service.StatsService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stats")
public class StatsController {
    private final StatsService statsService;

    @Autowired
    public StatsController(StatsService statsService){
        this.statsService = statsService;
    }

    @GetMapping("/countries/most-gold-medals")
    public List<Object[]> getCountriesWithMostGoldMedals(){
        return statsService.getCountriesWithMostGoldMedals();
    }

    @GetMapping("/countries/least-silver-medals")
    public List<Object[]> getCountriesWithLeastSilverMedals(){
        return statsService.getCountriesWithLeastSilverMedals();
    }

    @GetMapping("/athletes/most-medals")
    public Object[] getAthleteWithMostMedals(){
        return statsService.getAthleteWithMostMedals();
    }

    @GetMapping("/athletes/most-points")
    public Object[] getAthleteWithMAxPoints(){
        return statsService.getAthleteWithMAxPoints();
    }

    @GetMapping("/countries/top-medal-tally/{n}")
    public ResponseEntity<List<Object[]>> getTopNMedalTally(@PathVariable int n){
        List<Object[]> result = statsService.getTopNMedalTally(n);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/countries/top-medal-tally-event/{n}/{eventId}")
    public ResponseEntity<List<Object[]>> getTopNMedalTallyForEvent(@PathVariable int n, @PathVariable Long eventId){
        List<Object[]> result = statsService.getTopNMedalTallyForEvent(n, eventId);
        return ResponseEntity.ok(result);
    }
}
