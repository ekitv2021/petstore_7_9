package com.itvedant.todoapp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itvedant.todoapp.entities.Task;
import com.itvedant.todoapp.repositories.TaskRepository;

@Service
public class TaskService {
	@Autowired
	private TaskRepository taskRepository;
	
	public void addTask(Task task) {
		this.taskRepository.save(task);
	}
	
	public List<Task> getAll(){
		return this.taskRepository.findAll();
	}
	
	public void deleteTask(Integer id) {
		this.taskRepository.deleteById(id);
	}
	
	public Task getById(Integer id) {
		return this.taskRepository.findById(id).get();
	}
	
	public void updateTask(Task task) {
		this.taskRepository.save(task);
	}
}
