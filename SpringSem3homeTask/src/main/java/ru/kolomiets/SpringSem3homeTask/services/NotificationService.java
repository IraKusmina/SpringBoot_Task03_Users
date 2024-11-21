package ru.kolomiets.SpringSem3homeTask.services;

import org.springframework.stereotype.Service;
import ru.kolomiets.SpringSem3homeTask.models.User;

@Service
public class NotificationService {
    public void notifyUser(User user){
        System.out.println("A new user has been created: " + user.getName());
    }
}
