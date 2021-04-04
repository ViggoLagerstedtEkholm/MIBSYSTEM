package com.mibsystem.demo.Repository;

import com.mibsystem.demo.Models.Announcement;
import org.springframework.data.repository.CrudRepository;

public interface AnnouncementRepository extends CrudRepository<Announcement, Integer> {
    @Override
    <S extends Announcement> S save(S s);

    @Override
    Iterable<Announcement> findAll();

    @Override
    void deleteById(Integer integer);

    @Override
    boolean existsById(Integer integer);
}
