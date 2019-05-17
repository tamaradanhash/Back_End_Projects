package com.example.accountancy.logic;

import com.example.accountancy.dto.PatientDTO;
import com.example.accountancy.persistence.Invoice;
import com.example.accountancy.persistence.Patient;
import lombok.Getter;
import lombok.Setter;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

@SpringBootTest(webEnvironment = WebEnvironment.NONE)
public class AccountantTest {

  @Autowired
  Accountant accountant;

  @MockBean
  InvoiceManager invoiceManager;
  @MockBean
  PatientManager patientManager;

  @Value("patientdto")
  PatientDTO patientdto;
  @Getter
  @Setter
  Patient patient = Patient.builder()
                           .name(patientdto.getName())
                           .uuid(patientdto.getId())
                           .build();


  @Test
  public void testPostOnePatient() {
    Invoice invoice = new Invoice();
    accountant.post(patientdto);
    when(patientManager.creat(patientdto))
        .thenReturn(patient);

    verify(patientManager).creat(patientdto);
    verify(patientManager).store(patient);

    verify(invoiceManager).create(patientdto, patient);
    verify(invoiceManager).save(invoice);  //might not work

  }
}