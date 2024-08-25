package com.beehive.game_management.service;

import com.beehive.game_management.entity.Athlete;
import com.beehive.game_management.entity.Country;
import com.beehive.game_management.repository.ResultRepository;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.apache.commons.lang3.reflect.Typed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatsService {
    private final ResultRepository resultRepository;
    private final EntityManager entityManager;

    @Autowired
    public StatsService(ResultRepository resultRepository, EntityManager entityManager){
        this.resultRepository = resultRepository;
        this.entityManager = entityManager;
    }

    public List<Object[]> getCountriesWithMostGoldMedals(){
        String jpql = "SELECT r.athlete.country, COUNT(r) AS goldCount " +
                "FROM Result r " +
                "WHERE r.position = 1 " +
                "GROUP BY r.athlete.country " +
                "ORDER BY goldCount DESC";
        TypedQuery<Object[]> query = entityManager.createQuery(jpql, Object[].class);
        return query.getResultList();
    }

    public List<Object[]> getCountriesWithLeastSilverMedals(){
        String jpql = "SELECT r.athlete.country, COUNT(r) as silverCount " +
                "FROM Result r " +
                "WHERE r.position = 2 " +
                "GROUP BY r.athlete.country " +
                "ORDER BY silverCount ASC";
        TypedQuery<Object[]> query = entityManager.createQuery(jpql, Object[].class);
        return query.getResultList();
    }

    public Object[] getAthleteWithMostMedals(){
        String jpql = "SELECT r.athlete, COUNT(r) AS medalCount " +
                "FROM Result r " +
                "GROUP BY r.athlete " +
                "ORDER BY medalCount DESC";
        TypedQuery<Object[]> query = entityManager.createQuery(jpql, Object[].class);
        query.setMaxResults(1);
        return query.getSingleResult();
    }

    public Object[] getAthleteWithMAxPoints(){
        String jpql = "SELECT r.athlete, SUM(r.points) AS totalPoints " +
                "FROM Result r " +
                "GROUP BY r.athlete " +
                "ORDER BY totalPoints DESC";
        TypedQuery<Object[]> query = entityManager.createQuery(jpql, Object[].class);
        query.setMaxResults(1);
        return query.getSingleResult();
    }

    public List<Object[]> getTopNMedalTally(int n){
        String jpql = "SELECT r.athlete.country, COUNT(r) as medalCount " +
                "FROM Result r " +
                "GROUP BY r.athlete.country " +
                "ORDER BY medalCount DESC";
        TypedQuery<Object[]> query = entityManager.createQuery(jpql, Object[].class);
        query.setMaxResults(n);
        return query.getResultList();
    }

    public List<Object[]> getTopNMedalTallyForEvent(int n, Long eventId){
        String jpql = "SELECT r.athlete.country, COUNT(r) AS medalCount " +
                "FROM Result r " +
                "WHERE r.event.id = :eventId " +
                "GROUP BY r.athlete.country " +
                "ORDER BY medalCount DESC";
        TypedQuery<Object[]> query = entityManager.createQuery(jpql, Object[].class);
        query.setParameter("eventId", eventId);
        query.setMaxResults(n);
        return query.getResultList();
    }
}
