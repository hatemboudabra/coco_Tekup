package com.tekup.coco.repository;

import com.tekup.coco.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepo extends JpaRepository<Role,Long> {
    Role findByRole(String role);
}
