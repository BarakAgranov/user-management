package com.barak.user;

import com.barak.user.dto.UserCreateDto;
import com.barak.user.dto.UserUpdateDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
@Component
public interface IUserMapper {

    User createDtoToUser(UserCreateDto createDTO);

    User updateDtoToUser(UserUpdateDto updateDTO, @MappingTarget User user);
}
