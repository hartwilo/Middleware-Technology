package com.hftstuttgart.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import jakarta.ws.rs.Path;

@RestController
@RequestMapping("/v1/")
public class ToDoController {

ArrayList<ToDo> todos = new ArrayList<ToDo>();


//Add a new ToDo-Item to list

@ResponseStatus(HttpStatus.CREATED)
@PostMapping("/addTodo")
public ToDo createToDo(@RequestBody ToDo todo){

    todos.add(todo);

    return todo;
}

@ResponseStatus(HttpStatus.OK)
@RequestMapping(value = "/")
public List<ToDo> getToDos(){
    return todos;
}

@ResponseStatus(HttpStatus.OK)
@PutMapping("/updateTodo")
public ToDo updateToDo(@RequestBody ToDo todo){
    ToDo newTodo = todos.get(todo.getId());
    newTodo.setTask(todo.getTask());
    newTodo.setPriority(todo.getPriority());
    todos.set(newTodo.getId(), newTodo);
    return newTodo;
}

@ResponseStatus(HttpStatus.NO_CONTENT)
@DeleteMapping("/deleteTodo")
public ToDo deleteToDo(@RequestParam int todoId){
    ToDo todo = todos.get(todoId);
    todos.remove(todo);
    return todo;
}
}



    

