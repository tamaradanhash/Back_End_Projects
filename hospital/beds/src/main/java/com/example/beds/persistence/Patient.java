package com.example.beds.persistence;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Patient {


    private String id;
    private String name;
    private String symptoms;
    private String diagnosis;
    private String treatment;

}
