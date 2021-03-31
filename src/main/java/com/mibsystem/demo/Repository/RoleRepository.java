package com.mibsystem.demo.Repository;

import com.mibsystem.demo.Models.Role;
import com.mibsystem.demo.Models.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface RoleRepository extends CrudRepository<Role, Integer> {
    Optional<Role> findByName(Roles name);
}
