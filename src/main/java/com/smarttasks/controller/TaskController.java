package com.smarttasks.controller;

import com.smarttasks.model.Task;
import com.smarttasks.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class TaskController {
    @Autowired
    private TaskService service;

    @GetMapping("/")
    public String viewHomePage(Model model) {
        model.addAttribute("tasks", service.getAllTasks());
        return "index";
    }

    @PostMapping("/add")
    public String addTask(Task task) {
        service.save(task);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteTask(@PathVariable Long id) {
        service.deleteById(id);
        return "redirect:/";
    }
}