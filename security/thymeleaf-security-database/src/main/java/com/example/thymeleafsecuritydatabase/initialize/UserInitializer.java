package com.example.thymeleafsecuritydatabase.initialize;

import com.example.thymeleafsecuritydatabase.persistence.domain.User;
import com.example.thymeleafsecuritydatabase.persistence.repository.UserRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Set;

@Configuration
public class UserInitializer {

  @Bean
  ApplicationRunner initializeUser(PasswordEncoder encoder, UserRepository repository) {
    return args -> {
      User user = createUser(encoder);
      if (repository.existsByUsername(user.getUsername())) {
        return;
      }
      repository.save(user);
    };
  }

  private User createUser(PasswordEncoder encoder) {
    return User.builder()
               .name("Mr. User")
               .username("user")
               .password(encoder.encode("user"))
               .authorities(Set.of("USER"))
               .build();
  }

}
