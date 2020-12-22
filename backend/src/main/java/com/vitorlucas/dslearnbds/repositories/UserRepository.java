package com.vitorlucas.dslearnbds.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vitorlucas.dslearnbds.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
