package com.rmatwell.todo.repository;

import com.rmatwell.todo.entity.TaskList;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

/**
 * @author Richard Atwell
 */
public interface TaskListRepository extends JpaRepository<TaskList, String>{
}
