package com.beehive.game_management.mapper;

import com.beehive.game_management.dto.AthleteDto;
import com.beehive.game_management.entity.Athlete;

public class AthleteMapper {

    public static AthleteDto mapToAthleteDto(Athlete athlete){
        return new AthleteDto(
                athlete.getId(),
                athlete.getFirstName(),
                athlete.getLastName(),
                athlete.getAge(),
                athlete.getGender(),
                athlete.getCountry()
        );
    }

    public static Athlete mapToAthlete(AthleteDto athleteDto){
        return new Athlete(
                athleteDto.getId(),
                athleteDto.getFirstName(),
                athleteDto.getLastName(),
                athleteDto.getAge(),
                athleteDto.getGender(),
                athleteDto.getCountry()
        );
    }
}
