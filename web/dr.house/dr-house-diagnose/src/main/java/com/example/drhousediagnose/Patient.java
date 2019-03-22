package com.example.drhousediagnose;

import lombok.Data;

@Data
public class Patient {
    private String name;
    private String id;
    private String symptoms;
    private String diagnosis;
}
