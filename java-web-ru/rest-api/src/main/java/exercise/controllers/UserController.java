package exercise.controllers;

import io.javalin.http.Context;
import io.javalin.apibuilder.CrudHandler;
import io.ebean.DB;

import java.util.List;
import java.util.Objects;

import exercise.domain.User;
import exercise.domain.query.QUser;

import org.apache.commons.validator.routines.EmailValidator;
import org.apache.commons.lang3.StringUtils;

public class UserController implements CrudHandler {

    public void getAll(Context ctx) {
        // BEGIN
        List<User> users = new QUser()
                .orderBy()
                .id.asc()
                .findList();
        String json = DB.json().toJson(users);
        ctx.json(json);
        // END
    }


    public void getOne(Context ctx, String id) {

        // BEGIN
        User user = new QUser()
                .id.equalTo(Long.parseLong(id))
                .findOne();
        String json = DB.json().toJson(user);
        ctx.json(json);
        // END
    }

    public void create(Context ctx) {

        // BEGIN
        User user = ctx.bodyValidator(User.class)
                .check(it -> !Objects.equals(it.getFirstName(), ""), "FirstName cannot be empty!")
                .check(it -> !Objects.equals(it.getLastName(), ""), "LastName cannot be empty!")
                .check(it -> EmailValidator.getInstance().isValid(it.getEmail()), "Email is not correct!")
                .check(it -> it.getPassword().length() > 3, "Password must not be shorter than 4 digits!")
                .check(it -> StringUtils.isNumeric(it.getPassword()), "Password must contain only numbers!")
                .get();
        user.save();
        // END
    }


    public void update(Context ctx, String id) {
        // BEGIN
        String body = ctx.body();
        User user = DB.json().toBean(User.class, body);
        new QUser()
                .id.equalTo(Long.parseLong(id))
                .asUpdate()
                .set("firstName", user.getFirstName())
                .set("lastName", user.getLastName())
                .set("email", user.getEmail())
                .set("password", user.getPassword())
                .update();
        // END
    }


    public void delete(Context ctx, String id) {
        // BEGIN
        new QUser()
                .id.equalTo(Long.parseLong(id))
                .delete();
        // END
    }

}
