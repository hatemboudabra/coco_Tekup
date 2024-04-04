package com.tekup.coco.repository;

import com.tekup.coco.Dto.UserDto;
import com.tekup.coco.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User,Long> {
    User findByUsername(String username);
    Optional<User> findByEmail(String email);

    Optional<User> findById(UserDto userId);
}
