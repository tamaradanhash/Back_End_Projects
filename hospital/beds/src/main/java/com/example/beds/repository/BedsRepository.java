package com.example.beds.repository;

import com.example.beds.persistence.Patient;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BedsRepository extends MongoRepository<Patient, String> {
}
