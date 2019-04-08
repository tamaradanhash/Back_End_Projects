package com.example.beds.logic;

import com.example.beds.repository.BedsRepository;
import com.example.beds.persistence.Patient;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Service
@RequiredArgsConstructor
@RestController
public class Nurse {
    private final RestTemplate restTemplate;
    private final BedsRepository repository;
    private List<String> treatments = Arrays.asList("love", "happiness", "positivity", "friends", "family");
    @Value("server.url")
    private String url;

    public Patient save(Patient patient) {
        Random random = new Random();
        int position = random.nextInt(treatments.size());
        patient.setTreatment(treatments.get(position));

        return repository.save(patient);
    }

    public Patient post(Patient patient) {
        return restTemplate.postForObject(url, patient, Patient.class);
    }
}
