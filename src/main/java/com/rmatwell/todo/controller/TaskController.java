package com.rmatwell.todo.controller;

import com.rmatwell.todo.entity.Task;
import com.rmatwell.todo.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

/**
 * @author Richard Atwell
 */
@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class TaskController {

    @Autowired
    private final TaskService service;

    public TaskController(TaskService service) {
        this.service = service;
    }

    @PostMapping("/task")
    public Task addTask(@RequestBody Task task){
        return service.saveTask(task);
    }

    @GetMapping("/task")
    public List<Task> findAllTasks(){
        return service.getTasks();
    }

    @GetMapping("/task/{id}")
    public Task findTaskById(@PathVariable UUID id){
        return service.getTaskById(id);
    }

    @PutMapping("/task/{id}")
    public Task updateTask(@RequestBody Task task, @PathVariable UUID id){
        return service.updateTask(task, id);
    }

    @DeleteMapping("/task/{id}")
    @ResponseStatus(HttpStatus.RESET_CONTENT)
    public void deleteTask(@PathVariable UUID id){
        this.service.deleteTask(id);
    }

}
