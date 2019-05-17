package com.example.thymeleafsecuritydatabase.persistence.domain;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

import static javax.persistence.FetchType.EAGER;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
  @Id
  @GeneratedValue
  private Long id;

  @NonNull
  @Size(min = 2, max = 30)
  private String name;

  @Column(unique = true)
  private String username;

  private String password;

  @ElementCollection(fetch = EAGER)
  private Set<String> authorities = new HashSet<>();
}
