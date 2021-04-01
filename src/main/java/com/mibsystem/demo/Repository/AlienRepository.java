package com.mibsystem.demo.Repository;
import com.mibsystem.demo.Models.Actors.Alien;
import com.mibsystem.demo.Models.Actors.User;
import com.mibsystem.demo.Models.Equipment;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface AlienRepository extends CrudRepository<Alien, Integer> {

    Optional<Alien> findByEmail(String username);

    @Override
    Optional<Alien> findById(Integer integer);

    @Override
    <S extends Alien> S save(S s);

    @Override
    boolean existsById(Integer integer);

    @Override
    Iterable<Alien> findAll();

    @Override
    Iterable<Alien> findAllById(Iterable<Integer> iterable);

    @Override
    void delete(Alien alien);

    @Override
    void deleteAll(Iterable<? extends Alien> iterable);

    @Override
    void deleteAll();

    @Override
    void deleteById(Integer integer);

    @Override
    long count();

    @Override
    <S extends Alien> Iterable<S> saveAll(Iterable<S> iterable);
}