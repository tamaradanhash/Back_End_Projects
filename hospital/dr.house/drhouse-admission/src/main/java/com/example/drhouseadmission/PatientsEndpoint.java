package com.example.drhouseadmission;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;
@RequiredArgsConstructor
@RestController
@RequestMapping("/patients")
public class PatientsEndpoint {
   private final PatientClient client;

    @PostMapping()
    Patient post(@RequestBody Patient patient){
       return client.post(patient);

    }
}
