package com.example.magic8ball.controller;

import com.example.magic8ball.logic.MagicBallManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@RequiredArgsConstructor
@Controller
@RequestMapping("")
public class MagicBallController {
  private final MagicBallManager manager;

  @ModelAttribute("message")
  public String getMessage() {
    return manager.getMessage();
  }

  @GetMapping
  public String page() {
    return "magicball";
  }

}
