package com.leshko.diplom.controller;

import com.leshko.diplom.domain.Job;
import com.leshko.diplom.domain.User;
import com.leshko.diplom.repos.JobRepo;
import com.leshko.diplom.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Map;
import java.util.UUID;

@Controller
public class MainController {
    @Autowired
    private JobRepo jobRepo;

    @Autowired
    private UserRepo userRepo;


    @Value("${upload.path}")
    private String uploadPath;

    @GetMapping("/")
    public String greeting(Map<String, Object> model) {
        return "greeting";
    }

    @GetMapping("/main")
    public String main(@RequestParam(required = false, defaultValue = "") String filter, Model model) {
        Iterable<Job> jobs;

        if (filter != null && !filter.isEmpty()) {
            jobs = jobRepo.findByTag(filter);
        } else {
            jobs = jobRepo.findAll();
        }

        model.addAttribute("jobs", jobs);
        model.addAttribute("filter", filter);

        return "main";
    }

    @GetMapping("cabinet/{username}")
    public String getUserCabinet(@PathVariable String username, Model model) {
        User user = userRepo.findByUsername(username);
        model.addAttribute("user", user);
        return "cabinet";
    }

    @PostMapping("/editCabinet/{username}")
    public String saveUserChanges(
            @PathVariable String username,
            @RequestParam String firstName,
            @RequestParam(required = false, defaultValue = "") String secondName,
            @RequestParam(required = false, defaultValue = "") String lastName,
            @RequestParam(required = false, defaultValue = "") String city,
            @RequestParam String gender,
            @RequestParam(required = false, defaultValue = "") String email,
            @RequestParam(required = false, defaultValue = "") String linkedIn,
            @RequestParam(required = false, defaultValue = "") String technology,
            @RequestParam(required = false, defaultValue = "") String education,
            @RequestParam(required = false, defaultValue = "") String phoneNumber,
            @RequestParam(required = false, defaultValue = "") String position,
            @RequestParam(required = false, defaultValue = "") String language,
            @RequestParam(required = false, defaultValue = "") String about,
            Model model) {
        Date changeDate = new Date();
        User user = userRepo.findByUsername(username);
        user.setFirstName(firstName);
        user.setSecondName(secondName);
        user.setLastName(lastName);
        user.setCity(city);
        user.setGender(gender);
        user.setEmail(email);
        user.setLinkedIn(linkedIn);
        user.setTechnology(technology);
        user.setEducation(education);
        user.setPhoneNumber(phoneNumber);
        user.setPosition(position);
        user.setLanguage(language);
        user.setAbout(about);
        user.setChangeDate(changeDate.toString());
        userRepo.save(user);
        model.addAttribute("user", user);
        return "cabinet";
    }

    @GetMapping("cabinet/editCabinet/{username}")
    public String changeUserCabinet(@PathVariable String username, Model model) {
        User user = userRepo.findByUsername(username);
        model.addAttribute("user", user);
        return "editCabinet";
    }

    @Secured("ADMIN")
    @GetMapping("main/deleteJob/{id}")
    public String deleteJob(@PathVariable long id, Model model) {
        jobRepo.deleteById(id);
        model.addAttribute("jobs", jobRepo.findAll());
        return "redirect:/main";
    }

    @GetMapping("main/getJobById/{id}")
    public String getJobById(@PathVariable long id, Model model) {
        Job job = jobRepo.getOne(id);
        model.addAttribute("job", job);
        return "acceptJob";
    }

    @PostMapping("/main")
    public String add(
            @AuthenticationPrincipal User user,
            @RequestParam String jobName,
            @RequestParam String text,
            @RequestParam String tag, Map<String, Object> model) throws IOException {
        Job job = new Job(jobName, text, tag, user);

        jobRepo.save(job);

        Iterable<Job> jobs = jobRepo.findAll();

        model.put("jobs", jobs);

        return "main";
    }

    @PostMapping("/main/upload")
    public String handleFileUpload(
                @RequestParam("file") MultipartFile file) throws IOException {
        if (file != null && !file.getOriginalFilename().isEmpty()) {
            File uploadDir = new File(uploadPath);

            if (!uploadDir.exists()) {
                uploadDir.mkdir();
            }

            String uuidFile = UUID.randomUUID().toString();
            String resultFilename = uuidFile + "." + file.getOriginalFilename();

            file.transferTo(new File(uploadPath + "/" + resultFilename));

        }
        return "redirect:/main";
    }
}
