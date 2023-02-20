package com.learnKafka.libraryeventsconsumer.service;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.learnKafka.libraryeventsconsumer.entities.LibraryEvent;
import com.learnKafka.libraryeventsconsumer.repos.LibraryEventRepository;

@Service
public class LibraryEventService {
	
	Logger log = LoggerFactory.getLogger(LibraryEventService.class);

	@Autowired
	ObjectMapper mapper;
	
	@Autowired
	LibraryEventRepository eventRepository;
	
	public void processEvent(ConsumerRecord<Integer, String> consumerRecord) throws JsonMappingException, JsonProcessingException {
		LibraryEvent libraryEvent = mapper.readValue(consumerRecord.value(), LibraryEvent.class);
		log.info("libraryEvent is {} ", libraryEvent);
		
		save(libraryEvent);
	}

	private void save(LibraryEvent libraryEvent) {
		libraryEvent.getBook().setLibraryEvent(libraryEvent);
		
		eventRepository.save(libraryEvent);
		log.info("Successfully persisted the library event");
	}

}
