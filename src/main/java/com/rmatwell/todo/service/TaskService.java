package com.rmatwell.todo.service;

import com.rmatwell.todo.entity.Task;
import com.rmatwell.todo.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public List<Task> saveTasks(List<Task> tasks){
        return repository.saveAll(tasks);
    }

    public List<Task> getTasks(){
        return repository.findAll();
    }

    public Task getTaskById(long id){
        return repository.findById(id).orElse(null);
    }

    public Task getTaskByName(String name){
        return repository.findByName(name);
    }

    public String deleteTask(long id){
        repository.deleteById(id);
        return "Task \"" + id + "\" deleted";
    }

    public Task updateTask(Task task){
        Task existingTask = repository.findById(task.getId()).orElse(null);
        existingTask.setName(task.getName());
        existingTask.setDescription(task.getDescription());
        return repository.save(existingTask);
    }





}
