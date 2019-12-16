package com.tokenjwt.task.dao;

import com.tokenjwt.task.entities.AppRole;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<AppRole, Long> {
    public AppRole findByRoleName(String roleName);
}