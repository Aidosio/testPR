package com.example.taskproject.controller;

import com.example.taskproject.DTO.LogDTO;
import com.example.taskproject.DTO.LogResponce;
import com.example.taskproject.service.LogService;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LogController {

    private final LogService service;

    public LogController(LogService service) {
        this.service = service;
    }

    @PostMapping("/logs")
    public LogResponce logs (@RequestBody LogDTO dto){
        return service.logProcess(dto);
    }
}
