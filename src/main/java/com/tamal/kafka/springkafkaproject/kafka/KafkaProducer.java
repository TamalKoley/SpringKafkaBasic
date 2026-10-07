package com.tamal.kafka.springkafkaproject.kafka;

import com.tamal.kafka.springkafkaproject.config.ProducerMessageConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducer {

    private static final Logger LOGGER= LoggerFactory.getLogger(KafkaProducer.class);
    private final KafkaTemplate<String , ProducerMessageConfig> kafkaTemplate;

    public KafkaProducer(KafkaTemplate<String, ProducerMessageConfig> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(ProducerMessageConfig message){
        LOGGER.info("Message Sent : {}", message);
        kafkaTemplate.send("firsttopic",message);
    }

}
