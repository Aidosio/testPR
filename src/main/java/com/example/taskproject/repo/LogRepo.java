package com.example.taskproject.repo;

import com.example.taskproject.Entity.LogEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LogRepo extends JpaRepository<LogEntity, Long> {
}
