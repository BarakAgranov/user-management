package com.barak.user;

import com.barak.user.dto.UserCreateDto;
import com.barak.user.exceptions.ApplicationException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.ApplicationContext;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
@EnableEurekaClient
public class UserApplication {
    public static void main(String[] args) throws ApplicationException {
        ApplicationContext context = SpringApplication.run(UserApplication.class, args);

        UserController userController = context.getBean(UserController.class);

        for (UserCreateDto request: REQUESTS
             ) {
            userController.signup(request);
        }
    }

    final static List<UserCreateDto> REQUESTS = Arrays.asList(
            new UserCreateDto("agranov9@gmail.com","123456789", "barak", "agranov"),
            new UserCreateDto("udi@walla.com","432155349", "udi", "balabait"),
            new UserCreateDto("tai@yahoo.com","234112549", "tai", "orbach")
    );
}
