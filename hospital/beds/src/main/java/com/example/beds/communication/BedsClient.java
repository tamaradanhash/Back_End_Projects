package com.example.beds.communication;

import com.example.beds.persistence.Patient;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequiredArgsConstructor
public class BedsClient {
  private final RestTemplate restTemplate;
  @Value("server.url")
  private String url;

  public Patient post(Patient patient) {
    return restTemplate.postForObject(url, patient, Patient.class);
  }
}
