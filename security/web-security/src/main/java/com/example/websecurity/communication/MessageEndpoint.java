package com.example.websecurity.communication;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class MessageEndpoint {
  @GetMapping
  String message() {
    return "Hello there";
  }
}
