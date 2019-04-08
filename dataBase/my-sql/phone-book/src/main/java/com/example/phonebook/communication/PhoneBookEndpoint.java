package com.example.phonebook.communication;

import com.example.phonebook.logic.PhoneBookManager;
import com.example.phonebook.presistence.Contact;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/contacts")
public class PhoneBookEndpoint {

    private final PhoneBookManager manager;

    @GetMapping
    List<Contact> getAll() {
        return manager.findAll();
    }

    @PostMapping
    Contact post(@RequestBody Contact contact){
        return manager.save(contact);
    }

    @GetMapping("/address/{address}")
    List<Contact> get(@PathVariable String address){
        return manager.findByAddress(address);
    }
}
