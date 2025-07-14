package com.smarttasks.service;

import com.smarttasks.model.Task;
import com.smarttasks.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    @Autowired
    private TaskRepository repo;

    public List<Task> getAllTasks() {
        return repo.findAll();
    }

    public Task save(Task task) {
        return repo.save(task);
    }

    public void deleteById(Long id) {
        repo.deleteById(id);
    }
}