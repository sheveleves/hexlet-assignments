package exercise.controller;

import exercise.model.Person;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class WelcomeController {

    @GetMapping(path = "")
    public String welcome() {
        return "Welcome to Spring!";
    }
}
