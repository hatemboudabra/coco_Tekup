package com.tekup.coco;

import com.tekup.coco.entity.Role;
import com.tekup.coco.entity.User;
import com.tekup.coco.services.UserService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Properties;

@SpringBootApplication
public class CocoApplication {
	//@Autowired
//	UserService userService;

	public static void main(String[] args) {
		SpringApplication.run(CocoApplication.class, args);
	}



}
