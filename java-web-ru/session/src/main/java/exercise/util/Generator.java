package exercise.util;

import java.util.List;
import java.util.ArrayList;
import exercise.model.User;
import static exercise.util.Security.encrypt;

public class Generator {

    public static List<User> getUsers() {
        List<User> users = new ArrayList<>();

        users.add(new User(1L, "admin", Security.encrypt("secret")));
        users.add(new User(2L, "mike", Security.encrypt("superpass")));
        users.add(new User(3L, "kate", Security.encrypt("strongpass")));

        return users;
    }
}
