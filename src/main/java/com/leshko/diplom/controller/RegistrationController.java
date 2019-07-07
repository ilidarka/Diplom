package com.leshko.diplom.controller;

import com.leshko.diplom.domain.enums.Role;
import com.leshko.diplom.domain.User;
import com.leshko.diplom.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Date;
import java.util.Collections;
import java.util.Map;

@Controller
public class RegistrationController {
    @Autowired
    private UserRepo userRepo;

    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(User user, Map<String, Object> model) {
        Date changeDate = new Date();
        User userFromDb = userRepo.findByUsername(user.getUsername());

        if (userFromDb != null) {
            model.put("message", "User exists!");
            return "registration";
        }

        user.setFirstName("");
        user.setSecondName("");
        user.setLastName("");
        user.setCity("");
        user.setGender("");
        user.setEmail("");
        user.setLinkedIn("");
        user.setTechnology("");
        user.setEducation("");
        user.setPhoneNumber("");
        user.setPosition("");
        user.setLanguage("");
        user.setAbout("");
        user.setChangeDate(changeDate.toString());
        user.setActive(true);
        user.setRoles(Collections.singleton(Role.USER));
        userRepo.save(user);

        return "redirect:/login";
    }
}
