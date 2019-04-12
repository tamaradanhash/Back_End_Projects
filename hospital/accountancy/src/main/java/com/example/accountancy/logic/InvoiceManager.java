package com.example.accountancy.logic;

import com.example.accountancy.dto.PatientDTO;
import com.example.accountancy.persistence.Invoice;
import com.example.accountancy.persistence.Kind;
import com.example.accountancy.persistence.Patient;
import com.example.accountancy.repositories.InvoiceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class InvoiceManager {
  private final InvoiceRepository repository;


  public Invoice create(PatientDTO patientDTO, Patient patient) {
    return Invoice.builder()
                  .patient(patient)
                  .kind(getKind(patientDTO))
                  .symptoms(patientDTO.getSymptoms())
                  .diagnosis(patientDTO.getDiagnosis())
                  .provided(getProvided(patientDTO))
                  .timestamp(LocalDateTime.now())
                  .cost(0.0)
                  .paid(false)
                  .build();
  }

  public void save(Invoice invoice) {
    repository.save(invoice);
  }

  public List<Invoice> findAll() {
    return repository.findAll();
  }

  public void updateToPaid(Long id) {
    Invoice invoice = repository.findById(id).get();
    invoice.setPaid(true);
    repository.save(invoice);
  }

  private String getProvided(PatientDTO patientDTO) {
    if (!Objects.equals(patientDTO.getMedicine(), null)) {
      return patientDTO.getMedicine();
    }
    return patientDTO.getTreatment();
  }

  private Kind getKind(PatientDTO patientDTO) {
    if (!Objects.equals(patientDTO.getMedicine(), null)) {
      return Kind.MEDICINE;
    }
    return Kind.TREATMENT;
  }
}
