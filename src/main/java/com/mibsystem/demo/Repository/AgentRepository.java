package com.mibsystem.demo.Repository;

import com.mibsystem.demo.Models.Actors.Agent;
import com.mibsystem.demo.Models.Equipment;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface AgentRepository extends CrudRepository<Agent, Integer> {
    @Override
    Optional<Agent> findById(Integer integer);

    @Override
    Agent save(Agent s);

    @Override
    boolean existsById(Integer integer);

    @Override
    Iterable<Agent> findAll();

    @Override
    Iterable<Agent> findAllById(Iterable<Integer> iterable);

    @Override
    void delete(Agent agent);

    @Override
    void deleteAll(Iterable<? extends Agent> iterable);

    @Override
    void deleteAll();

    @Override
    void deleteById(Integer integer);

    @Override
    long count();

    <S extends Agent> Iterable<S> saveAll(Iterable<S> iterable);
}