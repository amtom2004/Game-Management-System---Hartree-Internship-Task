package com.beehive.game_management.dto;


import com.beehive.game_management.entity.Country;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AthleteDto {
    private Long id;
    private String firstName;
    private String lastName;
    private Integer age;
    private String gender;
    private Country country;
}
