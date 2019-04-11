package com.example.polo;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/polo")
public class PoloEndpoint {
  private String marco = "Marco";

  @PostMapping()
  public String post(@RequestBody String message) {

    if (marco.equals(message)) {
      return "Polo";
    }
    return "what";
  }
}
