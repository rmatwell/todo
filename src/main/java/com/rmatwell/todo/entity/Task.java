package com.rmatwell.todo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @author Richard Atwell
 */

@Data
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "TASK_TBL")
public class Task {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;
    private String name;
    private String description;
    private boolean complete;

    public Task(long id, String name, String description){
        this.name = name;
        this.description = description;
        this.complete = false;
    }


}
