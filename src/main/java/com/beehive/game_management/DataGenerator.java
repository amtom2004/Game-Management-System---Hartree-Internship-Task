package com.beehive.game_management;

import com.beehive.game_management.entity.Athlete;
import com.beehive.game_management.entity.Country;
import com.beehive.game_management.entity.Event;
import com.beehive.game_management.repository.AthleteRepository;
import com.beehive.game_management.repository.CountryRepository;
import com.beehive.game_management.repository.EventRepository;
import com.github.javafaker.Faker;
import jakarta.annotation.PostConstruct;
import org.aspectj.weaver.bcel.FakeAnnotation;
import org.hibernate.annotations.Comment;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Locale;

@Component
public class DataGenerator {
    private final AthleteRepository athleteRepository;
    private final CountryRepository countryRepository;
    private final EventRepository eventRepository;

    public DataGenerator(AthleteRepository athleteRepository, CountryRepository countryRepository, EventRepository eventRepository) {
        this.athleteRepository = athleteRepository;
        this.countryRepository = countryRepository;
        this.eventRepository = eventRepository;
    }

    @PostConstruct
    public void generateData(){
        Faker faker = new Faker();

        for(String countryCode : Locale.getISOCountries()){
            List<Country> existingCountry = countryRepository.findByIso(countryCode);
            if(existingCountry.isEmpty()) {
                Locale locale = new Locale("", countryCode);
                Country country = new Country();
                country.setName(locale.getDisplayCountry());
                country.setIso(countryCode);
                countryRepository.save(country);
            }
        }

        List<Country> countries = countryRepository.findAll();
        for(int i = 0; i < 1000; i++){
            Country country = countries.get(faker.random().nextInt(countries.size()));
            Athlete athlete = new Athlete();
            athlete.setFirstName(faker.name().firstName());
            athlete.setLastName(faker.name().lastName());
            athlete.setAge(faker.number().numberBetween(18, 40));
            athlete.setGender(faker.options().option("Male", "Female"));
            athlete.setCountry(country);
            athleteRepository.save(athlete);
        }

        String[] eventNames = {"100 m", "200 m", "Long Jump", "High Jump"};
        for(String eventName : eventNames){
            List<Event> existingEvent = eventRepository.findByName(eventName);
            if(existingEvent.isEmpty()) {
                Event event = new Event();
                event.setName(eventName);
                eventRepository.save(event);
            }
        }
    }
}
