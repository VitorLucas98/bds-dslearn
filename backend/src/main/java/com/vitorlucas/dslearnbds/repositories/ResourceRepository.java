package com.vitorlucas.dslearnbds.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vitorlucas.dslearnbds.entities.Resource;

public interface ResourceRepository extends JpaRepository<Resource, Long>{

}
