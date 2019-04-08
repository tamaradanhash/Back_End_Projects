package com.example.phonebook.repository;

import com.example.phonebook.presistence.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PhoneBookRepository extends JpaRepository<Contact,Long> {
    List<Contact> findAllByAddress_NameLike(String address);
}
