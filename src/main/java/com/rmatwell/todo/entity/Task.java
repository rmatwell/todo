package com.rmatwell.todo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.UUID;

/**
 * @author Richard Atwell
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Task {

    @Id
    @GeneratedValue
    private UUID id;

    private String content;

    private UUID colId;

    public Task(String content, UUID colId){
        this.content = content;
        this.colId = colId;
    }

}
