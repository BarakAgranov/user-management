package com.barak.group;

import com.barak.group.dto.GroupCreateDto;
import com.barak.group.dto.GroupUpdateDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
@Component
public interface IGroupMapper {

    Group createDtoToGroup(GroupCreateDto createDTO);

    Group updateDtoToGroup(GroupUpdateDto updateDTO, @MappingTarget Group group);

}
