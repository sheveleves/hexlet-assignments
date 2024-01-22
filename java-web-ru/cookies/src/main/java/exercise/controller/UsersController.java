package exercise.controller;

import org.apache.commons.lang3.StringUtils;
import exercise.util.Security;
import exercise.model.User;
import exercise.util.NamedRoutes;

import java.util.Collections;

import exercise.repository.UserRepository;
import io.javalin.http.NotFoundResponse;
import io.javalin.http.Context;


public class UsersController {

    public static void build(Context ctx) throws Exception {
        ctx.render("users/build.jte");
    }

    // BEGIN
    public static void create(Context ctx) {
        String firstName = ctx.formParam("firstName");
        String lastName = ctx.formParam("lastName");
        String email = ctx.formParam("email");
        String password = ctx.formParam("password");
        String encryptPassword = Security.encrypt(password);
        String token = Security.generateToken();
        User user = new User(firstName, lastName, email, encryptPassword, token);
        UserRepository.save(user);
        ctx.cookie("token", token);
        ctx.redirect("/users/" + String.valueOf(user.getId()));
    }

    public static void show(Context ctx) {
        Long id = ctx.pathParamAsClass("id", Long.class).get();
        User user = UserRepository.find(id)
                .orElseThrow(() -> new NotFoundResponse("User not found"));
        String token = ctx.cookie("token");
        if (user.getToken().equals(token)) {
            ctx.render("users/show.jte", Collections.singletonMap("user", user));
        } else {
            ctx.redirect(NamedRoutes.buildUserPath());
        }
    }
    // END
}
