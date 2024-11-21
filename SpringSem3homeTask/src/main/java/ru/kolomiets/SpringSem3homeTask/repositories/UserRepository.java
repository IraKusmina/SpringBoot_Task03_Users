package ru.kolomiets.SpringSem3homeTask.repositories;

import jdk.jfr.DataAmount;
import org.springframework.stereotype.Component;
import ru.kolomiets.SpringSem3homeTask.models.User;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserRepository {
    private List<User> users = new ArrayList<>();

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
