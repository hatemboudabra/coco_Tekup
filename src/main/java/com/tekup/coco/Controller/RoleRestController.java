package com.tekup.coco.Controller;

import com.tekup.coco.entity.Role;
import com.tekup.coco.entity.User;
import com.tekup.coco.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
public class RoleRestController {
    @Autowired
    UserService userService;
    @PostMapping("/addRole/{username}/{rolename}")
    public ResponseEntity<User> addRoleToUser(@PathVariable String username, @PathVariable String rolename) {

        User updatedUser = userService.addRoleToUser(username, rolename);

        if (updatedUser != null) {
            return new ResponseEntity<>(updatedUser, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("/add")
    public ResponseEntity<Role> addRole(@RequestBody Role role) {
        Role savedRole = userService.addRole(role);
        return new ResponseEntity<>(savedRole, HttpStatus.CREATED);
    }
}

