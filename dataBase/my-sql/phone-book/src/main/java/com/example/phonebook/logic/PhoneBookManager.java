package com.example.phonebook.logic;

import com.example.phonebook.presistence.Contact;
import com.example.phonebook.repository.PhoneBookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class PhoneBookManager {
    private final PhoneBookRepository repository;

    public List<Contact> findAll() {
        return repository.findAll();
    }

    public Contact save(Contact contact) {
        return repository.save(contact);
    }

    public List<Contact> findByAddress(String address){

        return repository.findAllByAddress_NameLike(address);
    }
}
