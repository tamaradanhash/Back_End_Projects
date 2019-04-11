package com.example.accountancy.repositories;

import com.example.accountancy.persistence.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {
}
