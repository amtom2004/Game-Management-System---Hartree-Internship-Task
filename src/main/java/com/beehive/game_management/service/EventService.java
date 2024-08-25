package com.beehive.game_management.service;

import com.beehive.game_management.entity.Athlete;
import com.beehive.game_management.entity.Event;
import com.beehive.game_management.entity.Result;
import com.beehive.game_management.exception.ResourceNotFoundException;
import com.beehive.game_management.repository.AthleteRepository;
import com.beehive.game_management.repository.EventRepository;
import com.beehive.game_management.repository.ResultRepository;
import org.springframework.stereotype.Service;

@Service
public class EventService {
    private EventRepository eventRepository;
    private ResultRepository resultRepository;
    private AthleteRepository athleteRepository;

    public Result recordResult(Long athleteId, Long eventId, int position, int points){
        Athlete athlete = athleteRepository.findById(athleteId).orElseThrow(() -> new ResourceNotFoundException("Athlete Not found for the given Id: " + athleteId));
        Event event = eventRepository.findById(eventId).orElseThrow(() -> new ResourceNotFoundException("Event Not found for the given Id: " + eventId));
        Result result = new Result(athlete, event, position, points);
        return resultRepository.save(result);
    }
}
