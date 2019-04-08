package com.example.pharmacy;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface PharmacyRepository extends MongoRepository<Patient, String> {
}
