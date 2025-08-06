package com.store.car.message;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.store.car.dto.CarPostDTO;
import com.store.car.service.CarPostService;

@Component
public class KafkaConsumerMessage {
	
	private final Logger LOG = LoggerFactory.getLogger(KafkaConsumerMessage.class);
	
	@Autowired
	private CarPostService carPostService;
	
	@KafkaListener(topics = "car-post-topic", groupId = "store-posts-group")
	public void listening(CarPostDTO carPost) {
		LOG.info("Received new car information: {}", carPost);
		carPostService.newPostDetails(carPost);
	}

}
