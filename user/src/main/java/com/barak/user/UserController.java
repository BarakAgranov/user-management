package com.barak.user;

import com.barak.user.exceptions.ApplicationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("api/v1/users")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public void signup(@RequestBody SignupRequest signupRequest) throws ApplicationException {
        log.info("user signup request {}", signupRequest);
        userService.signup(signupRequest);
    }

    @DeleteMapping(path = "{userId}")
    public void deleteUser(@PathVariable("userId") long userId) throws ApplicationException {
        log.info("user deletion request {}", userId);
        userService.deleteUser(userId);
    }

    @GetMapping
    public List<User> getAllUsers() throws ApplicationException {
        log.info("get all users request");
        return userService.getAllUsers();
    }

    @GetMapping(path = "{userId}")
    public User getUserById(@PathVariable("userId") long userId) throws ApplicationException {
        log.info("get one user request {}", userId);
        return userService.getUserById(userId);
    }
}
