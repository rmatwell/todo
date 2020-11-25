package com.rmatwell.todo.controller;

import com.rmatwell.todo.entity.TaskList;
import com.rmatwell.todo.service.TaskListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Richard Atwell
 */

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class TaskListController {

    @Autowired
    private final TaskListService service;

    public TaskListController(TaskListService service){
        this.service = service;
    }

    @PostMapping("/task-list")
    public TaskList addTaskList(@RequestBody TaskList taskList){
        return service.saveTaskList(taskList);
    }

    @GetMapping("/task-list")
    public List<TaskList> findAllTaskLists(){
        return service.getTaskLists();
    }




}
