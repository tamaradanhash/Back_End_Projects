package com.example.pharmacy.repositories;

import com.example.pharmacy.persistence.Patient;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PharmacyRepository extends MongoRepository<Patient, String> {
}
