package com.vitorlucas.dslearnbds.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vitorlucas.dslearnbds.entities.Reply;
@Repository
public interface ReplyRepository extends JpaRepository<Reply, Long>{

}
