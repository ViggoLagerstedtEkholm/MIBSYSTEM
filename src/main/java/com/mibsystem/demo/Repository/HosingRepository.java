package com.mibsystem.demo.Repository;

import com.mibsystem.demo.Models.Housing;
import com.mibsystem.demo.Models.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface HosingRepository extends CrudRepository<Housing, Integer> {
    Optional<Housing> findByAddress(String username);

    Optional<Housing> findbyId(Long id);

    Boolean existsById(Long id);
}
