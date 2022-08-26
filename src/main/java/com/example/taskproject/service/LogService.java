package com.example.taskproject.service;

import com.example.taskproject.DTO.LogDTO;
import com.example.taskproject.DTO.LogResponce;
import com.example.taskproject.Entity.LogEntity;
import com.example.taskproject.repo.LogRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.example.taskproject.DTO.Commands.ADD_LOGS;
import static com.example.taskproject.DTO.Commands.GET_LOGS;

@Service
public class LogService {

    private final LogRepo repo;

    public LogService(com.example.taskproject.repo.LogRepo repo) {
        this.repo = repo;
    }

    public static Map<Long, String> LogRepo = new HashMap();

    public LogResponce logProcess(LogDTO dto){
        switch(dto.getCommands()) {
            case ADD_LOGS -> {
                LogEntity logEntity = new LogEntity();
                logEntity.setContent(dto.getContent());

                repo.save(logEntity);
                return null;
            }
            case GET_LOGS -> {
                 List<LogEntity> entityList =  repo.findAll();

                 LogResponce logResponce = new LogResponce();
                 logResponce.setContents(new ArrayList<>());

                for (LogEntity entity:entityList) {
                    logResponce.getContents().add(entity.getContent());
                }
                return logResponce;
            }
            default -> System.out.println("Error");
        }
        return null;
    }


}
