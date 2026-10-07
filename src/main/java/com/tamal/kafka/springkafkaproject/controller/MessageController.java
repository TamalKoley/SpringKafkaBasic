package com.tamal.kafka.springkafkaproject.controller;

import com.tamal.kafka.springkafkaproject.config.ProducerMessageConfig;
import com.tamal.kafka.springkafkaproject.kafka.KafkaProducer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/producer")
public class MessageController {
    private final KafkaProducer kafkaProducer;

    public MessageController(KafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    //http:localhost:8080/api/v1/producer/publish?message=hello world
    @PostMapping("/publish")
    public ResponseEntity<String> publish(@RequestBody ProducerMessageConfig message){
        kafkaProducer.sendMessage(message);
        return  ResponseEntity.ok("message sent to the topic");

    }
}
