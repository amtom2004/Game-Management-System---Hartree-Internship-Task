package com.beehive.game_management;

import com.beehive.game_management.entity.Athlete;
import com.beehive.game_management.entity.Event;
import com.beehive.game_management.entity.Result;
import com.beehive.game_management.repository.AthleteRepository;
import com.beehive.game_management.repository.EventRepository;
import com.beehive.game_management.repository.ResultRepository;
import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EventSimulator {

    private final ResultRepository resultRepository;
    private final AthleteRepository athleteRepository;
    private final EventRepository eventRepository;

    @Autowired
    public EventSimulator(ResultRepository resultRepository, AthleteRepository athleteRepository, EventRepository eventRepository){
        this.resultRepository = resultRepository;
        this.athleteRepository = athleteRepository;
        this.eventRepository = eventRepository;
    }
    @Scheduled(fixedRate = 60000)
    public void simulationEvents(){
        Faker faker = new Faker();
        List<Event> events = eventRepository.findAll();
        List<Athlete> athletes = athleteRepository.findAll();

        for(Event event : events){
            for(int i = 0; i < 10; i++) {
                Athlete athlete = athletes.get(faker.random().nextInt(athletes.size()));
                int position = faker.number().numberBetween(1, 10);
                int points = (10 - position);
                Result result = new Result();
                result.setAthlete(athlete);
                result.setEvent(event);
                result.setPosition(position);
                result.setPoints(points);
                resultRepository.save(result);
            }
        }

    }
}
