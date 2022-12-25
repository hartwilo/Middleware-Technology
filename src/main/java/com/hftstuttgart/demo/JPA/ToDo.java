package com.hftstuttgart.demo.JPA;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ToDo {

    @Id
    private String task;
    private int priority = 3;

    public ToDo(String task, int priority) {
        this.task = task;
        this.priority = priority;
    }

    public ToDo(String task) {
        this.task = task;
    }

    public ToDo() {
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
        return "ToDo [task=" + task + ", priority=" + priority + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((task == null) ? 0 : task.hashCode());
        result = prime * result + priority;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ToDo other = (ToDo) obj;
        if (task == null) {
            if (other.task != null)
                return false;
        } else if (!task.equals(other.task))
            return false;
        if (priority != other.priority)
            return false;
        return true;
    }

    

        
}
