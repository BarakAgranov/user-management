package com.barak.user;

import com.barak.user.dto.*;
import com.barak.user.enums.ErrorType;
import com.barak.user.enums.UserType;
import com.barak.user.exceptions.ApplicationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.validation.Valid;

import java.util.List;


@Slf4j
@Service
public class UserService {

    private IUserRepository userRepository;
    private IUserMapper userMapper;

    final String ENCRYPTION_TOKEN_SALT = "Encrypted!As!Fuck!03052385";


    @Autowired
    public UserService(IUserRepository userRepository,
                       @Qualifier("IUserMapperImpl") IUserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }


    //TODO
//    public void login() {
//
//    }

    public void signup(@Valid UserCreateDto createDto) throws ApplicationException {

        /*
         * validate sign up request for having unique email
         */
        validateSignupRequest(createDto);

        String encryptedPassword = encryptPassword(createDto.getPassword());

        User user = userMapper.createDtoToUser(createDto);

        user.setPassword(encryptedPassword);

        user.setUserType(UserType.USER);

        try {
            userRepository.save(user);
            log.info("user signup request succeed {}", user.getEmail());
        } catch (Exception e) {
            log.info("user signup request failed {}", createDto.getEmail());

            throw e;

        }

    }

    @Transactional
    public void updateUser(@Valid UserUpdateDto userUpdateDto) throws ApplicationException {
        try {
            if (userRepository.existsById(userUpdateDto.getId())) {
                User user = userRepository.findById(userUpdateDto.getId()).get();
                user.setPassword(encryptPassword(userUpdateDto.getPassword()));
                userRepository.save(userMapper.updateDtoToUser(userUpdateDto, user));
            } else
                throw new ApplicationException(ErrorType.USER_DOES_NOT_EXIST,
                        "user with id: " + userUpdateDto.getId() + " does not exist");

        } catch (Exception e) {
            throw e;

        }
    }

    public void deleteUser(long userId) throws ApplicationException {
        try {
            userRepository.deleteById(userId);
            log.info("user deletion request succeed {}", userId);
        } catch (Exception e) {
            log.info("user deletion request failed {}", userId);
            throw e;
        }
    }

    public UserGetSlimDto getSlimUserById(long userId) throws ApplicationException {
        try {
            UserGetSlimDto user = userRepository.getUserSlimDtoById(userId);
            if (user != null) {
                return user;
            } else
                throw new ApplicationException(ErrorType.USER_DOES_NOT_EXIST, "user with id: " + userId + " does not exist");
        } catch (Exception e) {
            throw e;

        }
    }

    public UserGetFatDto getFatUserById(long userId) throws ApplicationException {
        try {
            UserGetFatDto user = userRepository.getUserFatDtoById(userId);
            if (user != null) {
                return user;
            } else
                throw new ApplicationException(ErrorType.USER_DOES_NOT_EXIST, "user with id: " + userId + " does not exist");

        } catch (Exception e) {
            throw e;

        }
    }

    public List<UserGetAllDto> getAllUsers() throws ApplicationException {
        try {
            return userRepository.getAllUsersDto();
        } catch (Exception e) {
            throw e;
        }
    }

    private void validateSignupRequest(UserCreateDto createDto) throws ApplicationException {
        try {
            if (userRepository.existsByEmail(createDto.getEmail())) {
                log.info("user signup request failed {}", createDto.getEmail());
                throw new ApplicationException(ErrorType.INVALID_EMAIL,
                        "user with email: " + createDto.getEmail() + " already exist");
            }
        } catch (Exception e) {
            if (e instanceof ApplicationException) {
                throw e;
            } else
                log.info("user signup request failed {}", createDto.getEmail());
            throw new ApplicationException(ErrorType.GENERAL_ERROR,
                    "general error occurs while trying to validate signup request for user: " + createDto.getEmail());
        }
    }

    private String encryptPassword(String password) {
        String textToEncrypt = password + ENCRYPTION_TOKEN_SALT;
        log.info("password encrypted");
        return textToEncrypt.hashCode() + "";
    }
}
