package com.barak.user;

import com.barak.user.dto.UserCreateDto;
import com.barak.user.dto.UserGetAllDto;
import com.barak.user.dto.UserGetSlimDto;
import com.barak.user.dto.UserUpdateDto;
import com.barak.user.exceptions.ApplicationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(path = "api/v1/users",
        produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public void signup(@RequestBody UserCreateDto createDto) throws ApplicationException {
        log.info("user signup request {}", createDto.getEmail());
        userService.signup(createDto);
    }

    @PutMapping
    public void updateUser(@RequestBody UserUpdateDto updateDto) throws ApplicationException {
        log.info("user update request {}", updateDto);
        userService.updateUser(updateDto);
    }

    @DeleteMapping(path = "{userId}")
    public void deleteUser(@PathVariable("userId") long userId) throws ApplicationException {
        log.info("user deletion request {}", userId);
        userService.deleteUser(userId);
    }

    @GetMapping
    public List<UserGetAllDto> getAllUsers() throws ApplicationException {
        log.info("get all users request");
        return userService.getAllUsers();
    }

    @GetMapping(path = "/{userId}")
    public UserGetSlimDto getUserById(@PathVariable("userId") long userId) throws ApplicationException {
        log.info("get one user request {}", userId);
        return userService.getSlimUserById(userId);
    }
}
