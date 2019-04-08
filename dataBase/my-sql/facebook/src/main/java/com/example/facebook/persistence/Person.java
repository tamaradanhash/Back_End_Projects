package com.example.facebook.persistence;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.List;

@EqualsAndHashCode(exclude = "friends")
@Data
@Entity
public class Person {
    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true)
    private String name;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Person> friends;

}

