package com.barak.user;

import com.barak.user.enums.ErrorType;
import com.barak.user.enums.UserType;
import com.barak.user.exceptions.ApplicationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;


@Slf4j
@Service
public class UserService {

    private UserRepository userRepository;

    final String ENCRYPTION_TOKEN_SALT = "Encrypted!As!Fuck!03052385";

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    //TODO
//    public void login() {
//
//    }

    public void signup(SignupRequest signupRequest) throws ApplicationException {
        validateSignupRequest(signupRequest);
        String encryptedPassword = encryptPassword(signupRequest.getPassword());
        User user = User.builder()
                .email(signupRequest.getEmail())
                .password(encryptedPassword)
                .firstName(signupRequest.getFirstName())
                .lastName(signupRequest.getLastName())
                .build();

        if (signupRequest.getEmail().equals("agranov9@gmail.com")) {
            user.setUserType(UserType.ADMIN);
        }
        else user.setUserType(UserType.REGULAR);
        try {
            userRepository.save(user);
            log.info("user signup request succeed {}", signupRequest);
        } catch (Exception e) {
            if (e instanceof ApplicationException) {
                log.info("user signup request failed {}", signupRequest);
                throw e;
            }
            else {
                log.info("user signup request failed {}", signupRequest);
                throw new ApplicationException(ErrorType.GENERAL_ERROR, "general error occurs while trying signup user: " + signupRequest.getEmail());
            }
        }

    }

    public void deleteUser(long userId) throws ApplicationException {
        try {
            userRepository.deleteById(userId);
            log.info("user deletion request succeed {}", userId);
        } catch (Exception e) {
            log.info("user deletion request failed {}", userId);
            throw new ApplicationException(ErrorType.GENERAL_ERROR, "general error occurs while trying to delete user with id: " +userId);
        }
    }

    public User getUserById(long userId) throws ApplicationException {
        try {
            User user = userRepository.getById(userId);
            if (user != null) {
                return user;
            }
            else throw new ApplicationException(ErrorType.USER_DOES_NOT_EXIST, "user with id: " + userId + " does not exist");

        } catch (Exception e) {
            if (e instanceof ApplicationException) {
                throw e;
            }
            else {
                throw new ApplicationException(ErrorType.GENERAL_ERROR, "general error occurs while trying to find user with id: " +userId);
            }
        }
    }

    public List<User> getAllUsers() throws ApplicationException {
        try {
            return userRepository.findAll();
        } catch (Exception e){
            throw new ApplicationException(ErrorType.GENERAL_ERROR, "general error occurs while trying to find all users");
        }
    }

    private void validateSignupRequest(SignupRequest signupRequest) throws ApplicationException {
        try {
            if (userRepository.existsByEmail(signupRequest.getEmail())) {
                throw new ApplicationException(ErrorType.INVALID_EMAIL, "user with email: " + signupRequest.getEmail() + " already exist");
            }
        } catch (Exception e) {
            if (e instanceof ApplicationException) {
                throw e;
            } else throw new ApplicationException(ErrorType.GENERAL_ERROR, "general error occurs while trying to validate signup request for user: " + signupRequest.getEmail());
        }
    }

    private String encryptPassword(String password){
        String textToEncrypt = password + ENCRYPTION_TOKEN_SALT;
        log.info("password encrypted");
        return textToEncrypt.hashCode() + "";
    }
}
