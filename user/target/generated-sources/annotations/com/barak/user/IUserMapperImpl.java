package com.barak.user;

import com.barak.user.User.UserBuilder;
import com.barak.user.dto.UserCreateDto;
import com.barak.user.dto.UserUpdateDto;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-04-03T00:08:13+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.2 (Oracle Corporation)"
)
@Component
public class IUserMapperImpl implements IUserMapper {

    @Override
    public User createDtoToUser(UserCreateDto createDTO) {
        if ( createDTO == null ) {
            return null;
        }

        UserBuilder user = User.builder();

        user.email( createDTO.getEmail() );
        user.password( createDTO.getPassword() );
        user.firstName( createDTO.getFirstName() );
        user.lastName( createDTO.getLastName() );

        return user.build();
    }

    @Override
    public User updateDtoToUser(UserUpdateDto updateDTO, User user) {
        if ( updateDTO == null ) {
            return null;
        }

        user.setId( updateDTO.getId() );
        if ( updateDTO.getPassword() != null ) {
            user.setPassword( updateDTO.getPassword() );
        }
        if ( updateDTO.getFirstName() != null ) {
            user.setFirstName( updateDTO.getFirstName() );
        }
        if ( updateDTO.getLastName() != null ) {
            user.setLastName( updateDTO.getLastName() );
        }

        return user;
    }
}
