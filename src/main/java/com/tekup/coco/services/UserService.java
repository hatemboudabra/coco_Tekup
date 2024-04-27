package com.tekup.coco.services;

import com.tekup.coco.entity.Role;
import com.tekup.coco.entity.User;
import com.tekup.coco.services.register.RegistationRequest;

import java.util.List;
import java.util.Map;

public interface UserService {
    User saveUser(User user);
    List<User> findAllUsers();
    User findUserByUsername (String username);
    Role addRole(Role role);
    User registerUser(RegistationRequest request);
    User addRoleToUser(String username, String rolename);
    public User getUserById(Long userId);
}
