package com.example.marcopolo;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/say")
@RequiredArgsConstructor
public class MarcoEndpoint {

    private final MarcoClient marco;

    @GetMapping("/{message}")
    String get(@PathVariable String message){
       return marco.getMessage(message);

    }

}
