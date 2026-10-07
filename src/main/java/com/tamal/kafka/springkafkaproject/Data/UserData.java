package com.tamal.kafka.springkafkaproject.Data;

import jakarta.persistence.*;

@Entity
@Table(name = "userdata")
public class UserData {

    @Id
    @SequenceGenerator(
            name = "userIdSequence",
            sequenceName = "userIdSequence"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "userIdSequence"
    )
    private Integer id;
    private String firstName;
    private String lastname;
    private String email;

    public UserData(String firstName, String lastname, String email) {
        this.firstName = firstName;
        this.lastname = lastname;
        this.email = email;
    }

    public UserData() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
