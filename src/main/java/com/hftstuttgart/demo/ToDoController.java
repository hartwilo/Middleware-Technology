package com.hftstuttgart.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import jakarta.ws.rs.Path;

@RestController
@RequestMapping("/todos")
public class ToDoController {

ArrayList<ToDo> todos = new ArrayList<ToDo>();


//Add a new ToDo-Item to list

@ResponseStatus(HttpStatus.CREATED)
@PostMapping("/{task}")
public ToDo createToDo(@PathVariable int id, String task, int priority){

    ToDo todo = new ToDo(id, task, priority);
    todos.add(todo);

    return todo;
}

@ResponseStatus(HttpStatus.OK)
@RequestMapping("/")
public List<ToDo> getToDos(){
    return todos;
}

@ResponseStatus(HttpStatus.OK)
@PutMapping("/{id}")
public ToDo updateToDo(@PathVariable int id, String task){
    ToDo todo = todos.get(id);
    todo.setTask(task);
    todos.set(id, todo);
    return todo;
}

@ResponseStatus(HttpStatus.NO_CONTENT)
@DeleteMapping("/{id}")
public ToDo deleteToDo(@PathVariable int id){
    todos.remove(id);
    return null;
}
}



    

