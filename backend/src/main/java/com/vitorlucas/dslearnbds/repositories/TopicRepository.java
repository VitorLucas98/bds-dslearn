package com.vitorlucas.dslearnbds.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vitorlucas.dslearnbds.entities.Topic;

public interface TopicRepository extends JpaRepository<Topic, Long>{

}
