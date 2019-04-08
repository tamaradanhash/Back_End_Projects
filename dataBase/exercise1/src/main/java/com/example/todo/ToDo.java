package com.example.todo;

import lombok.Data;

@Data
public class ToDo {
    private String id;
    private String title;
    private boolean done;
}
