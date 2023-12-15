package com.todo.app.rest.repositorio;

import com.todo.app.rest.modelo.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ToDoRepository extends JpaRepository<Task, Long> {
}
