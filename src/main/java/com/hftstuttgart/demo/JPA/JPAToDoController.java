package com.hftstuttgart.demo.JPA;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("/v2")
public class JPAToDoController {

    @Autowired
    ToDoItemRepository todoItemRepository;

    // Add new item to list using path variables
    @Operation(summary = "Creates a Todo Item with path variable task and default priority")
    @ApiResponses(value = 
    {
        @ApiResponse(responseCode = "201", description = "Todo has been created" , content = @Content)
    })
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/{task}")
    public ToDo createAndAddTodoItem(@PathVariable String task){

        ToDo todo = new ToDo(task);
        todoItemRepository.save(todo);

        return todo;
    }

	//Create Todo with Json
    @Operation(summary = "Creates a Todo Item with a JSON object as request paramter")
    @ApiResponses(value = 
    {
        @ApiResponse(responseCode = "201", description = "Todo has been created" , content = @Content)
    })
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/")
    public ToDo addTodoItem(@RequestBody ToDo todo){

        todoItemRepository.save(todo);
        return todo;
    }

    // List all elements in ArrayList
    @Operation(summary = "Returns a list of ToDo items")
    @GetMapping(value = "/", produces = "application/json")
    @ApiResponses(value = 
                    {
                        @ApiResponse(responseCode = "200", description = "List all items" , content = @Content)
                    })
    @ResponseStatus(HttpStatus.OK)
    public List<ToDo> getTodoItems(){

        return todoItemRepository.findAll();
    }

    //Change Todo
    @Operation(summary = "Changes a Todo Item, set new task")
    @ApiResponses(value = 
    {
        @ApiResponse(responseCode = "201", description = "Todo has been changed" , content = @Content)
    })
    @ResponseStatus(HttpStatus.CREATED)
    @PutMapping(produces = "application/json", path = "/{itemId}")
    ToDo changeTodoItem(@PathVariable String itemId, @PathVariable String newTask){

        ToDo newTodo = new ToDo(newTask);      

        return newTodo;
    }

	//Delete Todo
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(produces = "application/json", path = "/{itemId}")
    ToDo deleteTodoItem(@PathVariable String itemId){

        todoItemRepository.deleteById(itemId);

        return null;
    }

    
}
