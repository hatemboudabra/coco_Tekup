package com.tekup.coco.Controller;

import com.tekup.coco.entity.User;
import com.tekup.coco.repository.UserRepo;
import com.tekup.coco.services.ServiceImpl.AnnonceCovoiturageServiceImpl;
import com.tekup.coco.services.UserService;
import com.tekup.coco.services.register.RegistationRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
@Tag(name = "Test")
public class UserRestController {
    @Autowired
    UserService userService;
    @Autowired
    UserRepo userRepo;
    @GetMapping("all")
    public List<User> getAllUsers() {
        return userService.findAllUsers();
    }
    @Operation(description = "user")
    @PostMapping("register")
   public User register(@RequestBody RegistationRequest request){
        return userService.registerUser(request);

   }
    @GetMapping("/{username}")
    public User getUserByUsername(@PathVariable String username) {
        return userRepo.findByUsername(username);
    }
}
