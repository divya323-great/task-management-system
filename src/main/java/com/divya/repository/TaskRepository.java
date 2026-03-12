package com.divya.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.divya.model.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {
}