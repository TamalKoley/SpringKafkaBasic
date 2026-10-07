package com.tamal.kafka.springkafkaproject.Database;

import com.tamal.kafka.springkafkaproject.Data.UserData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DatabaseAdapter extends JpaRepository<UserData,Integer> {
}
