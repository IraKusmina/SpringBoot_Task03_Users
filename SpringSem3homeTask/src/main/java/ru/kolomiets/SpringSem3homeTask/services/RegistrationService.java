package ru.kolomiets.SpringSem3homeTask.services;

import org.springframework.stereotype.Service;
import ru.kolomiets.SpringSem3homeTask.models.User;

@Service
public class RegistrationService {

    private UserService userService;

    private DataProcessingService dataProcessingService;

    private NotificationService notificationService;

    public DataProcessingService getDataProcessingService() {
        return dataProcessingService;
    }

    public RegistrationService(DataProcessingService dataProcessingService, UserService userService, NotificationService notificationService){
        this.dataProcessingService = dataProcessingService;
        this.userService = userService;
        this.notificationService = notificationService;
    }

    public void processRegistration(String name, int age, String email){
        User createUser = userService.createUser(name, age, email);
        dataProcessingService.addUser(createUser);
    }
}
