package com.example.phonebook.logic;

import com.example.phonebook.presistence.Contact;
import com.example.phonebook.repository.PhoneBookRepository;
import lombok.Setter;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.NONE;

@SpringBootTest(webEnvironment = NONE)
@ConfigurationProperties("dataset.contacts")
class PhoneBookManagerTest {
    @Autowired
    PhoneBookRepository repository;

    @Autowired
    PhoneBookManager manager;

    @Setter
    Contact contact1;

    @Setter
    Contact contact2;

    @Setter
    Contact contact3;

    @BeforeEach
    void before(){
        repository.deleteAll();
        repository.save(contact1);
        repository.save(contact2);

    }


    @Test
    void findAll() {
        List<Contact> all = manager.findAll();
        assertThat(all.size()).isEqualTo(2);
    }

    @Test
    void save() {
        Contact contact = manager.save(contact3);
        assertThat(contact.getName()).isEqualTo("omar");
    }

    @Test
    void findByAddress() {
        List<Contact> contacts = manager.findByAddress("stefan");
        assertThat(contacts.size()).isEqualTo(2);
        assertThat(contacts).contains(contact1);
    }
}