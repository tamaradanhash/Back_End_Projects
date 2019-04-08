package com.example.todo;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/todos")
public class ToDoEndpoint {
    private final ToDoManager manager;

    @GetMapping
    List<ToDo> get() {
        return manager.findAll();
    }

    @GetMapping("/{id}")
    Optional<ToDo> getToDo(@PathVariable String id) {
        return manager.findById(id);
    }

    @PostMapping
    ToDo post(@RequestBody ToDo toDo) {
        return manager.save(toDo);
    }

    @PutMapping("/{id}/done")
    ToDo update(@PathVariable String id) {
        return manager.update(id);
    }

    @DeleteMapping("/{id}")
    void delete(@PathVariable String id) {
        manager.delete(id);
    }
}
