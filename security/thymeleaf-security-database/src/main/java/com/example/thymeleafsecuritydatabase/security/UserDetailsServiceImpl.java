package com.example.thymeleafsecuritydatabase.security;

import com.example.thymeleafsecuritydatabase.persistence.domain.User;
import com.example.thymeleafsecuritydatabase.persistence.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

  private final UserRepository repository;

  @Override
  public UserDetails loadUserByUsername(String username) {
    Optional<User> user = repository.findOneByUsername(username);
    if (user.isEmpty()) {
      throw new UsernameNotFoundException(username);
    }
    return new UserPrincipal(user.get());
  }
}
