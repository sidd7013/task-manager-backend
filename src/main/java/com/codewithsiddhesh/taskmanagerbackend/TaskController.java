package com.codewithsiddhesh.taskmanagerbackend;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;




@RestController
@RequestMapping("/tasks")
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
	
	@PutMapping("/{id}")
    public Task update(@PathVariable Long id, @RequestBody Task task) {
		Task existing = repo.findById(id).orElseThrow();
		existing.setTitle(task.getTitle());
		existing.setCompleted(task.isCompleted());
		return repo.save(existing);
   }

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		repo.deleteById(id);
	}


}