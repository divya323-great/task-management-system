package com.divya.service;

import java.util.List;
import com.divya.model.Task;

public interface TaskService {

    List<Task> getAllTasks();

    void saveTask(Task task);

    Task getTaskById(Long id);

    void deleteTaskById(Long id);

}