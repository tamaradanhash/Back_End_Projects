package com.example.accountancy.endpoints;

import com.example.accountancy.dto.PatientDTO;
import com.example.accountancy.logic.Accountant;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/patients")
@RequiredArgsConstructor
public class PatientEndpoint {
  private final Accountant accountant;

  @PostMapping
  public void post(@RequestBody PatientDTO patientDTO) {
    accountant.post(patientDTO);
  }
}
