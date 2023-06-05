package com.itvedant.todoapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.itvedant.todoapp.entities.Task;

@Repository
public interface TaskRepository 
	extends JpaRepository<Task, Integer>{

}
