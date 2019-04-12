package com.example.pharmacy.logic;

import com.example.pharmacy.persistence.Patient;
import com.example.pharmacy.repositories.PharmacyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Service
@RestController
@RequiredArgsConstructor
public class Pharmacist {
  private final PharmacyRepository repository;

  private List<String> medicines = Arrays.asList("call family", "hang out with friends", "a night out with lots of fun");

  public Patient save(Patient patient) {
    Random random = new Random();
    int position = random.nextInt(medicines.size());
    patient.setMedicine(medicines.get(position));
    return repository.save(patient);
  }
}
