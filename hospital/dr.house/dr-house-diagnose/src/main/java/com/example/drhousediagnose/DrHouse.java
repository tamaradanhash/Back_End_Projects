package com.example.drhousediagnose;

import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

@RestController
public class DrHouse {
    private List<String> diagnosis= Arrays.asList("Cancer","Flue","Lupus");
    private Random random=new Random();
    Patient giveDiagnosis(Patient patient){
        patient.setDiagnosis(diagnosis.get(random.nextInt(diagnosis.size())));
        return patient;
    }
}
