package com.rmatwell.todo.service;

import com.rmatwell.todo.entity.Task;
import com.rmatwell.todo.entity.TaskList;
import com.rmatwell.todo.repository.TaskListRepository;
import com.rmatwell.todo.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Richard Atwell
 */
@Service
public class TaskListService {

    @Autowired
    private TaskListRepository repository;

    public TaskList saveTaskList(TaskList taskList){
        return repository.save(taskList);
    }

    public List<TaskList> getTaskLists(){
        return repository.findAll();
    }
}
