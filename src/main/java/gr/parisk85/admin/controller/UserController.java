package gr.parisk85.admin.controller;

import gr.parisk85.admin.model.Credentials;
import gr.parisk85.admin.model.User;
import gr.parisk85.admin.service.UserService;
import gr.parisk85.admin.service.impl.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private SecurityService securityService;

    @GetMapping
    public ResponseEntity<List<User>> findAll() {
        return ResponseEntity
                .ok()
                .body(userService.findAll());
    }

    @PostMapping(value = "/register")
    public void register(@RequestBody User user) {
        userService.save(user);
    }

    @PostMapping(value = "/login")
    public void login(@RequestBody Credentials credentials) {
        securityService.login(credentials.getUsername(), credentials.getPassword());
    }

    @GetMapping(value = "/logout")
    public void logout(HttpServletRequest request) {
        securityService.logout(request);
    }
}
