package com.rmatwell.todo.service;

import com.rmatwell.todo.entity.Task;
import com.rmatwell.todo.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public Task getTaskById(int id){
        return repository.findById(id).orElse(null);
    }

    public Task getTaskByTitle(String title){
        return repository.findByTitle(title);
    }

    public String deleteTask(int id){
        repository.deleteById(id);
        return "Task \"" + id + "\" deleted";
    }

    public Task updateTask(Task task){
        Task existingTask = repository.findById(task.getId()).orElse(null);
        existingTask.setTitle(task.getTitle());
        existingTask.setDescription(task.getDescription());
        return repository.save(existingTask);
    }





}
