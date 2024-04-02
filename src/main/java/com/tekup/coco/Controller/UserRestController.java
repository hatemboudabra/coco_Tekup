package com.tekup.coco.Controller;

import com.tekup.coco.entity.User;
import com.tekup.coco.services.UserService;
import com.tekup.coco.services.register.RegistationRequest;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class UserRestController {
    @Autowired
    UserService userService;

    @GetMapping("all")
    public List<User> getAllUsers() {
        return userService.findAllUsers();
    }

    @PostMapping("register")
   public User register(@RequestBody RegistationRequest request){
        return userService.registerUser(request);

   }

}
