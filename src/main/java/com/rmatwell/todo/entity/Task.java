package com.rmatwell.todo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Richard Atwell
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "TASK_TBL")
public class Task {

    @Id
    @GeneratedValue
    private int id;
    private String title;
    private String Description;
}
