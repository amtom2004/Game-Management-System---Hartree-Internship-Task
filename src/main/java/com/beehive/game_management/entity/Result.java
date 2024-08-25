package com.beehive.game_management.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "result")
public class Result {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @ManyToOne
    @JoinColumn(name = "athlete_id")
    private Athlete athlete;
    @ManyToOne
    @JoinColumn(name = "event_id")
    private Event event;
    @Column(name = "position")
    private int position;
    @Column(name = "points")
    private int points;

    public Result(Athlete athlete, Event event, int position, int points) {
        this.athlete = athlete;
        this.event = event;
        this.position = position;
        this.points = points;
    }
}
