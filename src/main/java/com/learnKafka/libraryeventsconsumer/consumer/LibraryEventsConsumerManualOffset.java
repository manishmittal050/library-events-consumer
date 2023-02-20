package com.learnKafka.libraryeventsconsumer.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.listener.AcknowledgingMessageListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

//@Component
public class LibraryEventsConsumerManualOffset implements AcknowledgingMessageListener<Integer, String>{

Logger log = LoggerFactory.getLogger(LibraryEventConsumer.class);

	@Override
	@KafkaListener(topics = {"library-events"})
	public void onMessage(ConsumerRecord<Integer, String> data, Acknowledgment acknowledgment) {
		log.info("consumer record is {} ", data);
		acknowledgment.acknowledge();
		
	}
}
