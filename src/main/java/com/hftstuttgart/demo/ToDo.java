package com.hftstuttgart.demo;

public class ToDo {

    private int id;
    private String task;
    public int priority=3;


    public ToDo(int id, String task, int priority) {
        this.id = id;
        this.task = task;
        this.priority = priority;
    }


    public ToDo() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getTask() {
        return task;
    }


    public void setTask(String task) {
        this.task = task;
    }


    public int getPriority() {
        return priority;
    }


    public void setPriority(int priority) {
        this.priority = priority;
    }


    @Override
    public String toString() {
        return "ToDo [id=" + id + ", task=" + task + ", priority=" + priority + "]";
    }


    

    

    

    


    
    
}
