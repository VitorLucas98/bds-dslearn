package com.vitorlucas.dslearnbds.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vitorlucas.dslearnbds.entities.Enrollment;
import com.vitorlucas.dslearnbds.entities.EnrollmentPK;

public interface EnrollmentRepository extends JpaRepository<Enrollment, EnrollmentPK>{

}
