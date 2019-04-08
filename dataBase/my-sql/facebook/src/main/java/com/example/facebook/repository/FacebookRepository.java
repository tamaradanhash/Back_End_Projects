package com.example.facebook.repository;

import com.example.facebook.persistence.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FacebookRepository extends JpaRepository<Person, Long> {
    List<Person> findByFriendsNotNull();

    List<Person> findByFriends_Empty();
}
