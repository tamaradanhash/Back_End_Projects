package com.example.polo;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/polo")
public class PoloEndpoint {
    private  String marco = "Marco";
//    private String message;
//    @GetMapping("{message}")
//    String get(@PathVariable String message){
//        return message;
//    }

    @PostMapping()
    public String post(@RequestBody String message){

        if (marco.equals(message)){
            return "Polo";
        }
        return "what";
    }
}
