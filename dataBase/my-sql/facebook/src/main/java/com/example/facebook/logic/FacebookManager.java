package com.example.facebook.logic;

import com.example.facebook.persistence.Person;
import com.example.facebook.repository.FacebookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FacebookManager {

    private final FacebookRepository repository;

    public List<Person> getAll() {
        return repository.findAll();
    }

    public List<Person> getAllWithAtLeastOneFriend() {
        return repository.findByFriendsNotNull();
    }

    public List<Person> getAllWithoutFriends() {
        return repository.findByFriends_Empty();
    }

    public Person add(Person person) {
        return repository.save(person);
    }


    public String connectTwoFriendsByIds(Long id1, Long id2) {
        Person person1 = repository.findById(id1).get();
        Person person2 = repository.findById(id2).get();
        person1.getFriends().add(person2);
        person2.getFriends().add(person1);
        repository.save(person1);
        repository.save(person2);

        return person1.getName() + " and " + person2.getName() + " are now friends";
    }

    public String disconnectTwoFriendsByIds(Long id1, Long id2) {
        Person person1 = repository.findById(id1).get();
        Person person2 = repository.findById(id2).get();
        List<Person> friends1 = person1.getFriends();
        List<Person> friends2 = person2.getFriends();
        if (!friends1.isEmpty() && !friends2.isEmpty()) {
            friends1.remove(person2);
            friends2.remove(person1);
        } else {
            return null;
        }
        repository.save(person1);
        repository.save(person2);
        return person1.getName() + " is no longer friend with " + person2.getName();
    }
}
