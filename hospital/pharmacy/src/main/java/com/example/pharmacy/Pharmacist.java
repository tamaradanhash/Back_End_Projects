package com.example.pharmacy;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Service
@RestController
@RequiredArgsConstructor
public class Pharmacist {
    private final PharmacyRepository repository;

    private final RestTemplate restTemplate;

    private List<String> medicines= Arrays.asList("call family","a kiss from a lover","hang out with friends","a night out with lots of fun");

    @Value("server.url")
    private String url;


    public Patient save(Patient patient){
        Random random = new Random();
        int position = random.nextInt(medicines.size());
        patient.setMedicine(medicines.get(position));
        return repository.save(patient);
    }
}
