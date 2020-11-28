package com.rmatwell.todo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;
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
@Table(name = "task_lists")
public class TaskList {

    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    @Column(name = "list")
    private String list;

    private String title;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "list")
    private List<Task> tasks;

}
