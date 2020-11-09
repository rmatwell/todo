package com.rmatwell.todo.controller;

import com.rmatwell.todo.entity.Task;
import com.rmatwell.todo.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Richard Atwell
 */
@RestController
public class TaskController {

    @Autowired
    private TaskService service;

    @PostMapping("/api/add-task")
    public Task addTask(@RequestBody @ModelAttribute Task task){
        return service.saveTask(task);
    }

    @PostMapping("/api/add-tasks")
    public List<Task> addTask(@RequestBody List<Task> tasks){
        return service.saveTasks(tasks);
    }

    @GetMapping("/api/tasks")
    public List<Task> findAllTasks(){
        return service.getTasks();
    }

    @GetMapping("/api/task-by-id/{id}")
    public Task findTaskById(@PathVariable long id){
        return service.getTaskById(id);
    }

    @GetMapping("/api/task-by-name/{name}")
    public Task findTaskByTitle(@PathVariable String name){
        return service.getTaskByName(name);
    }

    @PutMapping("/api/update-task")
    public Task updateTask(@RequestBody @ModelAttribute Task task){
        return service.updateTask(task);
    }

    @DeleteMapping("/api/delete-task/{id}")
    public String deleteTask(@PathVariable long id){
        return service.deleteTask(id);
    }

}
