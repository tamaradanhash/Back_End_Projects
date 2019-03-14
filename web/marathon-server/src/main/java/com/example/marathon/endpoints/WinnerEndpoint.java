package com.example.marathon.endpoints;

import com.example.marathon.RunnersRepository;
import com.example.marathon.domain.Runner;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RequiredArgsConstructor
@RestController
@RequestMapping("/winner")
public class WinnerEndpoint {
    private final RunnersRepository runnersRepository;
    @GetMapping
    public Runner getWinner(){
       return runnersRepository.getFastestRunner().orElse(null);
    }
}
