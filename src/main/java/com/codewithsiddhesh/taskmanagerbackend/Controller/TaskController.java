package com.codewithsiddhesh.taskmanagerbackend.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codewithsiddhesh.taskmanagerbackend.Entities.Task;
import com.codewithsiddhesh.taskmanagerbackend.Repositories.TaskRepository;

@CrossOrigin("*")
@RequestMapping("/api/tasks")
@RestController
public class TaskController {
	
	@Autowired
	private TaskRepository taskRepository;
	
	private List<Task> tasks = new ArrayList<>();
	private Long idCounter = 1L;
	
	//GET all tasks
	@GetMapping
	public List<Task> getAllTasks(){
		return taskRepository.findAll();
	}
	
	//POST all tasks
	@PostMapping
	public Task addTask(@RequestBody Task task) {
		return taskRepository.save(task);
	}
	
	//Delete Task
	@DeleteMapping("/{id}")
	public void deleteTask(@PathVariable Long id) {
		taskRepository.deleteById(id);
	}
	
	@PutMapping("/{id}")
	public Task toggleTask(@PathVariable Long id, @RequestBody Task updatedTask) {
	    Task task = taskRepository.findById(id).orElseThrow(()-> new RuntimeException("Task not found"));
	    task.setText(updatedTask.getText());
	    System.out.println("Updating id:"+id);
	    task.setCompleted(updatedTask.isCompleted());   
	    return taskRepository.save(task);
	}
	
	
}
