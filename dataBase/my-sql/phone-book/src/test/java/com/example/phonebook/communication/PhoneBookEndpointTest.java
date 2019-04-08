package com.example.phonebook.communication;

import com.example.phonebook.logic.PhoneBookManager;
import com.example.phonebook.presistence.Contact;
import com.example.phonebook.repository.PhoneBookRepository;
import lombok.Getter;
import lombok.Setter;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@ConfigurationProperties("dataset")
@SpringBootTest(webEnvironment = RANDOM_PORT)
class PhoneBookEndpointTest {
    @Setter
    @Getter
    List<Contact> contacts;


    @Getter
    @Setter
    Contact contact = new Contact();


    @SpyBean
    PhoneBookManager manager;

    @MockBean
    PhoneBookRepository repository;

    @Autowired
    TestRestTemplate restTemplate;

    private String url = "/contacts";

    @Test
    void getAll() {
        when(repository.findAll())
                .thenReturn(contacts);
        restTemplate.getForObject(url, Contact[].class);
        verify(manager).findAll();
        verify(manager, times(1)).findAll();
    }

    @Test
    void post() {
        when(repository.save(contact))
                .thenReturn(contact);
        restTemplate.postForObject(url, contact, Contact.class);
        verify(manager).save(contact);

    }

    @Test
    void get() {
    }
}