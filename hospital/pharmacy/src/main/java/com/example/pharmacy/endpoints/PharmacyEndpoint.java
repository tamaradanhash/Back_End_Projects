package com.example.pharmacy.endpoints;

import com.example.pharmacy.logic.Pharmacist;
import com.example.pharmacy.persistence.Patient;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/patients")
public class PharmacyEndpoint {
  private final Pharmacist pharmacist;

  @PostMapping
  public Patient post(@RequestBody Patient patient) {
    return pharmacist.save(patient);
  }
}
