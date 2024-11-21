package ru.kolomiets.SpringSem3homeTask.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.kolomiets.SpringSem3homeTask.models.User;
import ru.kolomiets.SpringSem3homeTask.services.RegistrationService;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private RegistrationService service;

    @GetMapping
    public List<User> userList(){
        return service.getDataProcessingService().getRepository().getUsers();
    }

    @PostMapping(value = "/all", consumes = "application/json")
    public String userAddFromBody(@RequestBody User user){
        service.getDataProcessingService().getRepository().getUsers().add(user);
        return "User added from body";
    }
}
