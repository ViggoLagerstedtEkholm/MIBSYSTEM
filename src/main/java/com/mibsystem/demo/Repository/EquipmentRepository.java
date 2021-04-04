package com.mibsystem.demo.Repository;

import com.mibsystem.demo.Models.Equipment;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface EquipmentRepository extends CrudRepository<Equipment, Integer> {
    Optional<Equipment> findById(Long integer);

    @Override
    Equipment save(Equipment s);

    boolean existsById(Long integer);

    @Override
    Iterable<Equipment> findAll();

    @Override
    Iterable<Equipment> findAllById(Iterable<Integer> iterable);

    @Override
    void delete(Equipment Equipment);

    @Override
    void deleteAll(Iterable<? extends Equipment> iterable);

    @Override
    void deleteAll();

    @Override
    void deleteById(Integer integer);

    @Override
    long count();

    @Override
    <S extends Equipment> Iterable<S> saveAll(Iterable<S> iterable);
}