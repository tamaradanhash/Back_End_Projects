package com.example.drhousediagnose;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RequiredArgsConstructor
@RestController
@RequestMapping("/patients")
public class PatientsEndpoint {
    private final DrHouse drHouse;
    @PostMapping
    Patient post(@RequestBody Patient patient){

        return drHouse.giveDiagnosis(patient);
    }
}
