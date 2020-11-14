package com.rmatwell.todo.service;

import com.rmatwell.todo.entity.Task;
import com.rmatwell.todo.repository.TaskRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
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


    public List<Task> getTasks(){
        return repository.findAll();
    }

    public Task getTaskById(long id){
        return repository.findById(id).orElse(null);
    }

    public String deleteTask(long id){
        repository.deleteById(id);
        return "Task \"" + id + "\" deleted";
    }

    public Task updateTask(Task newTask, long id) {
        return repository.findById(id)
                .map(existingTask -> {
                    existingTask.setName(newTask.getName());
                    existingTask.setDescription(newTask.getDescription());
                    existingTask.setComplete(newTask.isComplete());
                    return repository.save(existingTask);
                })
                .orElseGet(() -> {
                    newTask.setId(id);
                    return repository.save(newTask);
                });
    }
}
