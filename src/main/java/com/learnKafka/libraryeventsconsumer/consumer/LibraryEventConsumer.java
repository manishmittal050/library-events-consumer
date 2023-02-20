package com.learnKafka.libraryeventsconsumer.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.learnKafka.libraryeventsconsumer.service.LibraryEventService;

@Component
public class LibraryEventConsumer {

	Logger log = LoggerFactory.getLogger(LibraryEventConsumer.class);
	
	@Autowired
	LibraryEventService eventService;
	
	@KafkaListener(topics = {"library-events"})
	public void onMessage(ConsumerRecord<Integer, String> consumerRecord) throws JsonMappingException, JsonProcessingException {
		
		log.info("consumer record is {} ", consumerRecord.value());
		eventService.processEvent(consumerRecord);
		
		
	}

}
