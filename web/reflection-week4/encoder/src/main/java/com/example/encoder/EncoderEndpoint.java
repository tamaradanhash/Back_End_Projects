package com.example.encoder;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/encode")
public class EncoderEndpoint {
    @PostMapping
    String get(@RequestBody String message){

        return message;
    }
}
