package com.tamal.kafka.springkafkaproject.kafka;

import com.tamal.kafka.springkafkaproject.Data.UserData;
import com.tamal.kafka.springkafkaproject.Database.DatabaseAdapter;
import com.tamal.kafka.springkafkaproject.SpringKafkaProjectApplication;
import com.tamal.kafka.springkafkaproject.config.ProducerMessageConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumer.class);
    private final DatabaseAdapter databaseAdapter;

    public KafkaConsumer(DatabaseAdapter databaseAdapter){
        this.databaseAdapter=databaseAdapter;
    }


    @KafkaListener(topics="firsttopic",groupId ="myGroup" )
    public void consumerService(ProducerMessageConfig message){
        LOGGER.info("Message received --> {}",message);
        UserData user = new UserData(
                message.firstName(),
                message.lastName(),
                message.email()
        );
        databaseAdapter.save(user);

    }

}
