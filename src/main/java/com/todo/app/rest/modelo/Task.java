package com.todo.app.rest.modelo;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(schema = "TasksCrud")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    private String titulo;
    @Column
    private String descripcion;
}
