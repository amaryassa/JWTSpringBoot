package com.tokenjwt.task.dao;

import com.tokenjwt.task.entities.Task;

import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.data.rest.core.annotation.RepositoryRestResource;

// @RepositoryRestResource 

public interface TaskRepository extends JpaRepository<Task, Long> {

}