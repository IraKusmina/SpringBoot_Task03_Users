package ru.kolomiets.SpringSem3homeTask.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.kolomiets.SpringSem3homeTask.models.User;
import ru.kolomiets.SpringSem3homeTask.services.DataProcessingService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    @Autowired
    private DataProcessingService service;

    @GetMapping
    public List<String> getAllTasks(){
        List<String> tasks = new ArrayList<>();
        tasks.add("sort");
        tasks.add("filter");
        tasks.add("calc");
        return tasks;
    }

    @GetMapping("/sort")
    public List<User> sortByUser(){
        return service.sortUsersByAge(service.getRepository().getUsers());
    }


    //filterUsersByAge
    @PostMapping("/filter/{age}")
    public List<User> filterByAge(@PathVariable("age") int age){
        return service.filterUsersByAge(service.getRepository().getUsers(), age);
    }

    //calculateAverageAGe
    @GetMapping("/calc")
    public double calculateAverageAge(){
        return service.calculateAverageAge(service.getRepository().getUsers());
    }
}
