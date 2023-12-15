package com.todo.app.rest.controlador;

import com.todo.app.rest.modelo.Task;
import com.todo.app.rest.repositorio.ToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ToDoController {
    @Autowired
    private ToDoRepository todorepository;

    @GetMapping(value = "/tasks")
    public List<Task> getTasks(){
        return todorepository.findAll();
    }

    @PostMapping(value = "/savetask")
    public String saveTask(@RequestBody Task task){
        todorepository.save(task);
        return "Saved task";
    }

    @PutMapping(value = "/modifytask/{tsk}")
    public String modifyTask(@PathVariable long tsk, @RequestBody Task t){
        Task task = todorepository.findById(tsk).get();
        task.setTitulo(t.getTitulo());
        task.setDescripcion(t.getDescripcion());
        todorepository.save(task);
        return "Successful modification";
    }

    @DeleteMapping(value = "/deletetask/{tsk}")
    public String deleteTask(@PathVariable long tsk){
        Task task = todorepository.findById(tsk).get();
        todorepository.delete(task);
        return "Deleted task";
    }
}
