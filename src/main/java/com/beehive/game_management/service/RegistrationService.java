package com.beehive.game_management.service;

import com.beehive.game_management.dto.AthleteDto;
import com.beehive.game_management.entity.Athlete;
import com.beehive.game_management.entity.Country;
import com.beehive.game_management.exception.ResourceNotFoundException;
import com.beehive.game_management.mapper.AthleteMapper;
import com.beehive.game_management.repository.AthleteRepository;
import com.beehive.game_management.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RegistrationService {
    private final AthleteRepository athleteRepository;
    private final CountryRepository countryRepository;

    @Autowired
    public RegistrationService(CountryRepository countryRepository, AthleteRepository athleteRepository){
        this. countryRepository = countryRepository;
        this.athleteRepository = athleteRepository;
    }

    public AthleteDto athleteRegistration(AthleteDto athleteDto){
        Country country = countryRepository.findById(athleteDto.getCountry().getId()).orElseThrow(() -> new ResourceNotFoundException("No Country Exists with given id: " + athleteDto.getCountry().getId()));
        Athlete athlete = AthleteMapper.mapToAthlete(athleteDto);
        Athlete savedAthlete = athleteRepository.save(athlete);
        return AthleteMapper.mapToAthleteDto(savedAthlete);
    }

    public AthleteDto getAthleteById(Long athleteId){
        Athlete athlete = athleteRepository.findById(athleteId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Athlete with given ID doesn't exists: " + athleteId));
        return AthleteMapper.mapToAthleteDto(athlete);
    }

    public List<AthleteDto> getAllAthletes(){
        List<Athlete> athletes = athleteRepository.findAll();
        return athletes.stream().map((athlete) -> AthleteMapper.mapToAthleteDto(athlete)).collect(Collectors.toList());
    }

    public AthleteDto updateAthlete(Long athleteId, AthleteDto updatedAthlete) {
        Athlete athlete = athleteRepository.findById(athleteId).orElseThrow(
                () -> new ResourceNotFoundException("The Athlete for the given ID not found:" + athleteId)
        );
        athlete.setFirstName(updatedAthlete.getFirstName());
        athlete.setLastName(updatedAthlete.getLastName());
        athlete.setAge(updatedAthlete.getAge());
        athlete.setGender(updatedAthlete.getGender());
        athlete.setCountry(updatedAthlete.getCountry());
        Athlete updatedEmployeeObj = athleteRepository.save(athlete);
        return AthleteMapper.mapToAthleteDto(updatedEmployeeObj);
    }

    public void deleteAthlete(Long athleteId) {
        Athlete employee = athleteRepository.findById(athleteId).orElseThrow(
                () -> new ResourceNotFoundException("The Athlete for the given ID not found:" + athleteId)
        );
        athleteRepository.deleteById(athleteId);
    }
}
