package com.vitorlucas.dslearnbds.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vitorlucas.dslearnbds.entities.Lesson;

public interface LessonRepository extends JpaRepository<Lesson, Long>{

}
