package com.example.magic8ball.logic;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;


@Service
public class MagicBallManager {

  private List<String> messages = Arrays.asList("ballnumber1", "ballnumber2", "ballnumber3", "ballnumber4", "ballnumber5", "ballnumber6", "ballnumber7", "ballnumber8");

  public String getMessage() {
    Collections.shuffle(messages);
    return messages.get(0);
  }
}
