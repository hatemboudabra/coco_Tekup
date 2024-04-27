package com.tekup.coco.services.ServiceImpl;

import com.tekup.coco.entity.AnnonceCovoiturage;
import com.tekup.coco.entity.Role;
import com.tekup.coco.entity.User;
import com.tekup.coco.repository.AnnonceCovoiturageRepo;
import com.tekup.coco.repository.RoleRepo;
import com.tekup.coco.repository.UserRepo;
import com.tekup.coco.services.UserService;
import com.tekup.coco.services.exceptions.EmailAlreadyExistsException;
import com.tekup.coco.services.register.RegistationRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Transactional
@Service
public class UserServiceImpl implements UserService {
        @Autowired
        UserRepo userRep;
        @Autowired
        RoleRepo roleRep;
        @Autowired
        BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
        public User saveUser(User user) {
            user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
            return userRep.save(user);
        }
    @Override
    public List<User> findAllUsers() {
        return userRep.findAll();
    }

    @Override
        public User addRoleToUser(String username, String rolename) {
            User usr = userRep.findByUsername(username);
            Role r = roleRep.findByRole(rolename);
            usr.getRoles().add(r);
            return usr;
        }
        @Override
        public Role addRole(Role role) {
            return roleRep.save(role);
        }

    @Override
    public User registerUser(RegistationRequest request) {
        Optional<User> optionalUser = userRep.findByEmail(request.getEmail());
        if (optionalUser.isPresent()){
            throw new EmailAlreadyExistsException("email deja utilisé");
        }
        User newUser =new User();
        newUser.setEmail(request.getEmail());
        newUser.setUsername(request.getUsername());
        newUser.setPassword(bCryptPasswordEncoder.encode(request.getPassword()));
        newUser.setEnabled(false);
        userRep.save(newUser);
        Role r =roleRep.findByRole("USER");
        List<Role> roles =new ArrayList<>();
        roles.add(r);
        newUser.setRoles(roles);
        return userRep.save(newUser);
    }

    @Override
        public User findUserByUsername(String username) {
            return userRep.findByUsername(username);
        }



    public User getUserById(Long userId) {
        return userRep.findById(userId).orElse(null);
    }


    }

