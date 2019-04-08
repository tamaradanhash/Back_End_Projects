package com.example.facebook.endpoints;

import com.example.facebook.logic.FacebookManager;
import com.example.facebook.persistence.Person;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/persons")
@RequiredArgsConstructor
public class FacebookEndpoint {
    private final FacebookManager manager;

    @GetMapping
    public List<Person> get() {
        return manager.getAll();
    }

    @GetMapping("/friends/with")
    public List<Person> getSocialPersons() {
        return manager.getAllWithAtLeastOneFriend();
    }

    @GetMapping("/friends/without")
    public List<Person> getAntiSocialPersons() {
        return manager.getAllWithoutFriends();
    }

    @PostMapping
    public Person post(@RequestBody Person person) {
        return manager.add(person);
    }

    @PutMapping("/{id1}/friend/{id2}")
    public String updateFriends(@PathVariable Long id1, @PathVariable Long id2) {
        return manager.connectTwoFriendsByIds(id1, id2);
    }

    @PutMapping("/{id1}/unfriend/{id2}")
    public String updateUnfriend(@PathVariable Long id1, @PathVariable Long id2) {
        return manager.disconnectTwoFriendsByIds(id1, id2);
    }
}
//Behaviour:
//        GET to /persons -> returns all Persons.
//        GET to /persons/friends/with -> returns all Persons that have at least one friend.
//        GET to /persons/friends/without -> returns all Persons that have no friends.
//        POST a Person to /persons -> saves the new Person. Post the Person with only the name.
//        PUT to /persons/{id1}/friend/{id2} -> connects the two Persons with id1 and id2 as friends.
//        PUT to /persons/{id1}/unfriend/{id2} -> disconnects the friendship between the two Persons with id1 and id2.
