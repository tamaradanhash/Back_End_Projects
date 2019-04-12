package com.example.accountancy.logic;

import com.example.accountancy.dto.PatientDTO;
import com.example.accountancy.persistence.Patient;
import com.example.accountancy.repositories.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PatientManager {
  private final PatientRepository repository;

  public Patient creat(PatientDTO patientDTO) {
    return Patient.builder()
                  .uuid(patientDTO.getId())
                  .name(patientDTO.getName())
                  .build();
  }

  public void store(Patient patient) {
    repository.save(patient);
  }
}
