package com.example.marathon.endpoints;

import com.example.marathon.RunnersRepository;
import com.example.marathon.domain.Runner;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/runners")
public class RunnerEndpoint {
    private final RunnersRepository runnersRepository;
    @GetMapping
    public List<Runner> getRunners(){
        return runnersRepository.getAll();
    }
    @PostMapping
    public Runner addRunner(@RequestBody Runner runner){
        runnersRepository.addRunner(runner);
        return runner;
    }
}
