package com.example.drhouseadmission;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class PatientClient {
    private final RestTemplate restTemplate;
    @Value("${server.url}")
    private String url;

    public Patient post(Patient patient) {
        patient.setId(UUID.randomUUID().toString());
        restTemplate.postForObject(url, patient, Patient.class);
        return patient;
    }

}
