package com.beehive.game_management.controller;

import com.beehive.game_management.entity.Result;
import com.beehive.game_management.service.EventService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/events")
public class EventController {
    private EventService eventService;

    @PostMapping("/{eventId}/results")
    public Result recordResult(@PathVariable Long eventId, @RequestBody Result result){
        return eventService.recordResult(result.getAthlete().getId(), eventId, result.getPosition(), result.getPosition());
    }
}
