package com.example.drhouseadmission;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.web.client.RestTemplate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
class PatientsEndpointTest {

    @Autowired
    TestRestTemplate testRestTemplate;

    @MockBean
    RestTemplate restTemplate;

    private String url = "/patients";

    @Test
    void post() {
        Patient patient = new Patient();
        patient.setName("tamara");
        patient.setSymptoms("stressed");
        Patient actual = testRestTemplate.postForObject(url, patient, Patient.class);
        assertThat(actual.getName()).isEqualTo(patient.getName());
        assertThat(actual.getSymptoms()).isEqualTo(patient.getSymptoms());
        assertThat(actual.getId()).isNotEmpty();
    }
}