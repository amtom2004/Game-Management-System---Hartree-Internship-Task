package com.beehive.game_management.controller;

import com.beehive.game_management.dto.AthleteDto;
import com.beehive.game_management.service.RegistrationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/athletes")
public class AthleteController {
    private final RegistrationService registrationService;

    public AthleteController(RegistrationService registrationService){
        this.registrationService = registrationService;
    }

    //Build Create Athlete REST API
    @PostMapping
    public ResponseEntity<AthleteDto> registerAthlete(@RequestBody AthleteDto athleteDto){
        AthleteDto savedAthlete = registrationService.athleteRegistration(athleteDto);
        return new ResponseEntity<>(savedAthlete, HttpStatus.CREATED);
    }

    //Build Get Athletes REST API
    @GetMapping("{id}")
    public ResponseEntity<AthleteDto> getAthleteById(@PathVariable("id") Long athleteId){
        AthleteDto athleteDto = registrationService.getAthleteById(athleteId);
        return ResponseEntity.ok(athleteDto);
    }

    //Build Get All Athletes REST API
    @GetMapping
    public ResponseEntity<List<AthleteDto>> getAllAthletes(){
        List<AthleteDto> athletes = registrationService.getAllAthletes();
        return ResponseEntity.ok(athletes);
    }

    //Build Update Athlete REST API
    @PutMapping("{id}")
    public ResponseEntity<AthleteDto> updateAthletes(@PathVariable("id") Long athleteId, @RequestBody AthleteDto updatedAthlete){
        AthleteDto athleteDto = registrationService.updateAthlete(athleteId, updatedAthlete);
        return ResponseEntity.ok(athleteDto);
    }

    //Build Delete Athlete REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteAthlete(@PathVariable("id") Long athleteId){
        registrationService.deleteAthlete(athleteId);
        return ResponseEntity.ok("Athlete Deleted Successfully: " + athleteId);
    }
}
