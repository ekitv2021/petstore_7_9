package com.itvedant.todoapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import com.itvedant.todoapp.entities.Task;
import com.itvedant.todoapp.services.TaskService;

@Controller
public class TaskController {
	@Autowired
	private TaskService taskService;
	
	@GetMapping("/")
	public String index() {
		return "index.html";
	}	
	
	@GetMapping("/view")
	public String displayTask(Model model) {
//		Task task = new Task();
//		task.setId(1);
//		task.setTaskName("learn python");
//		task.setStatus("in progress");
//		
//		model.addAttribute("task", task);
//		
//		model.addAttribute("myname","ekwinder");
		
		model.addAttribute("allTask",this.taskService.getAll());
		
		return "view.html";
	}
	
	//when the form for adding is to be loaded in the browser
	@GetMapping("/add")
	public String addTask(Model model) {
//		System.out.println("new form will be loaded");
		model.addAttribute("newTask", new Task());
		return "add.html";
	}
	
	//when the user will click on the AddTask button, this method is called
	@GetMapping("/addtask")
	public String addTaskDone(@ModelAttribute Task newTask) {
		System.out.println("form data is read");
		System.out.println(newTask.getTaskName());
		this.taskService.addTask(newTask);
		return "redirect:/view";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteTask(@PathVariable Integer id) {
		this.taskService.deleteTask(id);
		return "redirect:/view";
	}
	
	@GetMapping("/update/{id}")
	public String updateTask(@PathVariable Integer id, Model model) {
		model.addAttribute("taskObj",this.taskService.getById(id));
		return "update.html";
	}
	
	@GetMapping("/updatetask")
	public String updateTaskDone(@ModelAttribute Task taskObj) {
		this.taskService.updateTask(taskObj);
		return "redirect:/view";
	}
}
