package com.hftstuttgart.demo.JPA;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ToDoItemRepository extends JpaRepository<ToDo, String>{
    
}
