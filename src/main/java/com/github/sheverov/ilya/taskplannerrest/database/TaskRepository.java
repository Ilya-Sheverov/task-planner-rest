package com.github.sheverov.ilya.taskplannerrest.database;

import com.github.sheverov.ilya.taskplannerrest.entity.Task;
import java.sql.Timestamp;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task,Integer> {

    Optional<Task> findByIdAndVersion(Integer id, Timestamp version);
}
