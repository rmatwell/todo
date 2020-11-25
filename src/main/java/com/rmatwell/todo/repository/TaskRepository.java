package com.rmatwell.todo.repository;

import com.rmatwell.todo.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

/**
 * @author Richard Atwell
 */
public interface TaskRepository extends JpaRepository<Task, Long> {
}
