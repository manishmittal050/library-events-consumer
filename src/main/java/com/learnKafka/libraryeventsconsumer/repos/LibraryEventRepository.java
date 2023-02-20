package com.learnKafka.libraryeventsconsumer.repos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.learnKafka.libraryeventsconsumer.entities.LibraryEvent;

@Repository
public interface LibraryEventRepository extends CrudRepository<LibraryEvent, Integer>{

}
