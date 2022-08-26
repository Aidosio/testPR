package com.example.taskproject.DTO;

import lombok.Getter;

public enum Commands {
    ADD_LOGS("addLog"),
    GET_LOGS("logs");

    @Getter
    private String name;

    Commands(String name) {
        this.name = name;
    }
}
