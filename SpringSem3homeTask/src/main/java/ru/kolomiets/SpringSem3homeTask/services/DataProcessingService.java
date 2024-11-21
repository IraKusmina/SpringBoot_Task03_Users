package ru.kolomiets.SpringSem3homeTask.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kolomiets.SpringSem3homeTask.models.User;
import ru.kolomiets.SpringSem3homeTask.repositories.UserRepository;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DataProcessingService {

    @Autowired
    private UserRepository repository;


    public UserRepository getRepository() {
        return repository;
    }

    public List<User> sortUsersByAge(List<User> users){
        return users.stream()
                .sorted(Comparator.comparing(User::getAge))
                .collect(Collectors.toList());
    }

    public List<User> filterUsersByAge(List<User> users, int age){
        return users.stream()
                .filter(user -> user.getAge() > age)
                .collect(Collectors.toList());
    }

    public double calculateAverageAge(List<User> users){
        return users.stream()
                .mapToInt(User::getAge)
                .average()
                .orElse(0);
    }

    public void addUser(User user){
        repository.getUsers().add(user);
    }

}
