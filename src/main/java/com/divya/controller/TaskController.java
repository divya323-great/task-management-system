package com.divya.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.divya.model.Task;
import com.divya.service.TaskService;

@Controller
public class TaskController {

    @Autowired
    private TaskService taskService;

    // HOME PAGE
    @GetMapping("/")
    public String viewHomePage(Model model){

        model.addAttribute("listTasks", taskService.getAllTasks());

        return "index";
    }

    // CREATE TASK PAGE
    @GetMapping("/showNewTaskForm")
    public String showNewTaskForm(Model model){

        Task task = new Task();

        model.addAttribute("task", task);

        return "createTask";
    }

    @PostMapping("/saveTask")
    public String saveTask(@ModelAttribute("task") Task task,
                           @RequestParam("userInfo") String userInfo){

        String[] userParts = userInfo.split("-");

        String userName = userParts[0];
        String userId = userParts[1];

        if(task.getId() == null){

            task.setCreatedByName(userName);
            task.setCreatedById(userId);
            task.setCreatedOn(LocalDateTime.now());

            task.setLastUpdatedByName(userName);
            task.setLastUpdatedById(userId);
        }
        else{

            Task existingTask = taskService.getTaskById(task.getId());

            task.setCreatedByName(existingTask.getCreatedByName());
            task.setCreatedById(existingTask.getCreatedById());
            task.setCreatedOn(existingTask.getCreatedOn());

            task.setLastUpdatedByName(userName);
            task.setLastUpdatedById(userId);
        }

        task.setLastUpdatedOn(LocalDateTime.now());

        taskService.saveTask(task);

        return "redirect:/";
    }

    // EDIT TASK PAGE
    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable Long id, Model model){

        Task task = taskService.getTaskById(id);

        model.addAttribute("task", task);

        return "editTask";
    }

    // DELETE TASK
    @GetMapping("/deleteTask/{id}")
    public String deleteTask(@PathVariable Long id){

        taskService.deleteTaskById(id);

        return "redirect:/";
    }
}