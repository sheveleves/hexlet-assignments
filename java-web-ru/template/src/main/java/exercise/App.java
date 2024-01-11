package exercise;

import io.javalin.Javalin;
import java.util.List;
import io.javalin.http.NotFoundResponse;
import exercise.model.User;
import exercise.dto.users.UserPage;
import exercise.dto.users.UsersPage;
import io.javalin.validation.Validator;

import java.util.Collections;
import java.util.Map;

public final class App {

    // Каждый пользователь представлен объектом класса User
    private static final List<User> USERS = Data.getUsers();

    public static Javalin getApp() {

        var app = Javalin.create(config -> {
            config.plugins.enableDevLogging();
        });

        // BEGIN
        app.get("/users", ctx -> {
            String header = "Users";
            UsersPage usersPage = new UsersPage(USERS, header);
            ctx.render("users/index.jte", Collections.singletonMap("page", usersPage));
        });

        app.get("/users/{id}", ctx -> {
            Long id = ctx.pathParamAsClass("id", Long.class).get();
            User user = USERS.stream()
                    .filter(map -> map.getId() == id)
                    .findFirst()
                    .orElse(null);
            if (user == null) {
                throw new NotFoundResponse("User not found");
            }
            UserPage userPage = new UserPage(user);
            ctx.render("users/show.jte", Collections.singletonMap("page", userPage));
        });
        // END

        app.get("/", ctx -> {
            ctx.render("index.jte");
        });

        return app;
    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070);
    }
}
