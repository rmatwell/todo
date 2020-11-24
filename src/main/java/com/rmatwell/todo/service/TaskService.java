package com.rmatwell.todo.service;

import com.rmatwell.todo.entity.Task;
import com.rmatwell.todo.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.rmatwell.todo.exceptions.TaskNotFoundException;

import java.util.List;
import java.util.UUID;

/**
 * @author Richard Atwell
 */

@Service
public class TaskService {
    @Autowired
    private TaskRepository repository;

    public Task saveTask(Task task){
        return repository.save(task);
    }


    public List<Task> getTasks(){
        return repository.findAll();
    }

    public Task getTaskById(UUID id){
        Task task = repository.findById(id)
        .orElseThrow(() -> new TaskNotFoundException("Employee not exist with id :" + id));
        return task;
    }

    public String deleteTask(UUID id){
        repository.deleteById(id);
        return "Task \"" + id + "\" deleted";
    }

    public Task updateTask(Task newTask, UUID id) {
        return repository.findById(id)
                .map(existingTask -> {
                    existingTask.setContent(newTask.getContent());
                    existingTask.setColId(newTask.getColId());
                     return repository.save(existingTask);
                })
                .orElseGet(() -> {
                    newTask.setId(id);
                    return repository.save(newTask);
                });
    }
}
