package com.github.sheverov.ilya.taskplannerrest.database;

import com.github.sheverov.ilya.taskplannerrest.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task,Integer> {

}
