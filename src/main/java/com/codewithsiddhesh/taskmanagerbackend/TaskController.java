package com.codewithsiddhesh.taskmanagerbackend;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RequestMapping("/tasks")
@RestController
public class TaskController {
	
	@Autowired
	private TaskRepository repo;
	
	//GET all tasks
	@GetMapping
	public List<Task> getAll(){
		return repo.findAll();
	}
	
	//POST all tasks
	@PostMapping
	public Task add(@RequestBody Task task) {
		return repo.save(task);
	}
	
}