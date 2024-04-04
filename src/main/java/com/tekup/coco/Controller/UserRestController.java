package com.tekup.coco.Controller;

import com.tekup.coco.entity.User;
import com.tekup.coco.services.UserService;
import com.tekup.coco.services.register.RegistationRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@Tag(name = "Test")

public class UserRestController {
    @Autowired
    UserService userService;
    @Operation(description = "user")

    @GetMapping("all")
    public List<User> getAllUsers() {
        return userService.findAllUsers();
    }
    @Operation(description = "user")

    @PostMapping("register")
   public User register(@RequestBody RegistationRequest request){
        return userService.registerUser(request);

   }

}
