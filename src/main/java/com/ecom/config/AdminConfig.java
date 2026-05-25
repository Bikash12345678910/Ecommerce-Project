package com.ecom.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.ecom.model.UserDtls;
import com.ecom.repository.UserRepository;

@Configuration
public class AdminConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {

        String email = "bikashkumarsau0012@gmail.com";

        UserDtls adminAccount = userRepository.findByEmail(email);

        if (adminAccount == null) {

            UserDtls admin = new UserDtls();

            admin.setName("Admin");
            admin.setEmail(email);
            admin.setMobileNumber("8710059145");
            admin.setPassword(passwordEncoder.encode("bikash"));
            admin.setRole("ROLE_ADMIN");
            admin.setIsEnable(true);
            admin.setAccountNonLocked(true);
            admin.setProfileImage("default.jpg");

            userRepository.save(admin);

            System.out.println("Admin Created Successfully");
        }
    }
}