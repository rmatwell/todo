package com.rmatwell.todo.repository;

import com.rmatwell.todo.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Richard Atwell
 */

public interface TaskRepository extends JpaRepository<Task, Integer> {

    Task findByTitle(String title);
}
