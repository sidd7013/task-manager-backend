package com.codewithsiddhesh.taskmanagerbackend.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.codewithsiddhesh.taskmanagerbackend.Entities.Task;

public interface TaskRepository extends JpaRepository<Task, Long>{
}
