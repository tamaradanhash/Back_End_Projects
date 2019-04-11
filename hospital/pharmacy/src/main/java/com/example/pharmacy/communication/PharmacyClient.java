package com.example.pharmacy.communication;

import com.example.pharmacy.persistence.Patient;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequiredArgsConstructor
public class PharmacyClient {
  private final RestTemplate restTemplate;
  @Value("server.url")
  private String url;

  public Patient post(Patient patient) {
    return restTemplate.postForObject(url, patient, Patient.class);
  }
}
