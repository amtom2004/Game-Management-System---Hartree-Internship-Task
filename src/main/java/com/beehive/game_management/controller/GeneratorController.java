package com.beehive.game_management.controller;

import com.beehive.game_management.DataGenerator;
import com.beehive.game_management.EventSimulator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.crypto.Data;

@RestController
@RequestMapping("/api/data")
public class GeneratorController {

    private final DataGenerator dataGenerator;
    private final EventSimulator eventSimulator;

    @Autowired
    public GeneratorController(DataGenerator dataGenerator, EventSimulator eventSimulator)
    {
        this.dataGenerator = dataGenerator;
        this.eventSimulator = eventSimulator;
    }

    @GetMapping("/generate")
    public String generateData(){
        dataGenerator.generateData();
        return "Data Generation Initiated";
    }

    @GetMapping("/simulate")
    public String simulateEvent(){
        eventSimulator.simulationEvents();
        return "Event Simulation Started";
    }
}
