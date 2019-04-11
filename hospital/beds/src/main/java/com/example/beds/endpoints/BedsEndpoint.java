package com.example.beds.endpoints;

import com.example.beds.communication.BedsClient;
import com.example.beds.logic.Nurse;
import com.example.beds.persistence.Patient;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/patients")
@RequiredArgsConstructor
public class BedsEndpoint {
  private final Nurse nurse;
  private final BedsClient client;

  @PostMapping
  public Patient post(@RequestBody Patient patient) {
    client.post(patient);
    return nurse.save(patient);
  }
}
