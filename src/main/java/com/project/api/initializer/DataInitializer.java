package com.project.api.initializer;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.project.api.entities.User;
import com.project.api.enums.UserRole;
import com.project.api.repositories.UserRepository;

@Configuration
public class DataInitializer {
	@Bean
    public CommandLineRunner initSuperuser(
            UserRepository userRepository,
            PasswordEncoder passwordEncoder) {
        
        return args -> {
            String adminUname = "cjalonzaga";

            // Check if the superuser already exists
            if (userRepository.findByUsername(adminUname) == null) {
                

                User superuser = new User();
                superuser.setFirstName("Cris");
                superuser.setLastName("Alonzaga");
                superuser.setUsername("cjalonzaga");
                superuser.setEmail("cjalonzaga@gmail.com");
                superuser.setPassword(passwordEncoder.encode("admin123"));
                superuser.setUserRole(UserRole.ADMIN);
                superuser.setValid(true);

                userRepository.save(superuser);
                System.out.println("Superuser created successfully!");
            }
        };
    }
}
