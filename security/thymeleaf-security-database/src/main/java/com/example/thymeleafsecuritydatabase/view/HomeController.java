package com.example.thymeleafsecuritydatabase.view;

import com.example.thymeleafsecuritydatabase.security.UserPrincipal;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {

  @GetMapping
  String page() {
    return "home";
  }

  @ModelAttribute("principal")
  UserPrincipal principal(@AuthenticationPrincipal UserPrincipal principal) {
    return principal;
  }

}
