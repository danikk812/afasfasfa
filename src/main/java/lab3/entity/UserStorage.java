package lab3.entity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class UserStorage {
    private static UserStorage instance;
    private final List<User> users;

    private UserStorage(List<User> users) {
        this.users = Collections.synchronizedList(users);
    }

    public static UserStorage getInstance() {
        if (instance == null) {
            instance = new UserStorage(new ArrayList<>());
        }
        return instance;
    }

    public List<User> getUsers() {
        return users;
    }

    public void add(User user) {
        users.add(user);
    }

    public Optional<User> getUser(String email, String password) {
        return users.stream()
                .filter(user -> user.getEmail().equals(email))
                .filter(user -> user.getPassword().equals(password))
                .findAny();
    }
}
