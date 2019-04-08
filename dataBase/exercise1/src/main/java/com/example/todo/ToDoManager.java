package com.example.todo;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ToDoManager {
    private final ToDoRepository repository;

    public List<ToDo> findAll() {
        return repository.findAll();
    }


    public Optional<ToDo> findById(String id) {
        return repository.findById(id);
    }

    public ToDo save(ToDo toDo) {
        return repository.save(toDo);
    }

    public ToDo update(String id) {
        Optional<ToDo> optionalToDo = repository.findById(id);
        if (optionalToDo.isPresent()) {
            ToDo toDo = optionalToDo.get();
            toDo.setDone(true);

            repository.save(toDo);
            return toDo;
        }
        return null;
    }

    public void delete(String id) {
        repository.findById(id).ifPresent(toDo -> repository.delete(toDo));
    }

}
