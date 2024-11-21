package ru.kolomiets.SpringSem3homeTask.services;

import org.springframework.stereotype.Service;
import ru.kolomiets.SpringSem3homeTask.models.User;

@Service
public class UserService {
    private NotificationService notificationService;

    // Внедрение зависимостей через конструктор
    public UserService(NotificationService notificationService){
        this.notificationService = notificationService;
    }

    public User createUser(String name, int age, String email){
        User user = new User();
        user.setName(name);
        user.setAge(age);
        user.setEmail(email);

        //Отправляем уведомление о создании нового пользователя
        notificationService.notifyUser(user);

        return user;
    }
}
