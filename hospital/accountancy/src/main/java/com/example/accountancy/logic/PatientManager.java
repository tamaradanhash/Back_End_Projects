package com.example.accountancy.logic;

import com.example.accountancy.repositories.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PatientManager {
  private final PatientRepository repository;

}
