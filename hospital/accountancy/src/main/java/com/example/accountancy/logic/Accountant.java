package com.example.accountancy.logic;

import com.example.accountancy.dto.PatientDTO;
import com.example.accountancy.persistence.Invoice;
import com.example.accountancy.persistence.Patient;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;

import java.util.Map;

@ConfigurationProperties("dataset")
@Service
@RequiredArgsConstructor
public class Accountant {
  private final InvoiceManager invoiceManager;
  private final PatientManager patientManager;

  @Setter
  private Map<String, Double> costs;

  public void post(PatientDTO patientDTO) {
    Patient patient = patientManager.creat(patientDTO);
    patientManager.store(patient);
    Invoice invoice = invoiceManager.create(patientDTO, patient);
    Double costs = calculateCosts(invoice);
    invoice.setCost(costs);
    invoiceManager.save(invoice);
  }

  private Double calculateCosts(Invoice invoice) {
    return costs.getOrDefault(invoice.getProvided(), null);
  }
}
