package com.barak.group;

import com.barak.group.Group.GroupBuilder;
import com.barak.group.dto.GroupCreateDto;
import com.barak.group.dto.GroupUpdateDto;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-04-03T13:13:29+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.2 (Oracle Corporation)"
)
@Component
public class IGroupMapperImpl implements IGroupMapper {

    @Override
    public Group createDtoToGroup(GroupCreateDto createDTO) {
        if ( createDTO == null ) {
            return null;
        }

        GroupBuilder group = Group.builder();

        group.name( createDTO.getName() );
        group.creatorId( createDTO.getCreatorId() );

        return group.build();
    }

    @Override
    public Group updateDtoToGroup(GroupUpdateDto updateDTO, Group group) {
        if ( updateDTO == null ) {
            return null;
        }

        group.setId( updateDTO.getId() );
        if ( updateDTO.getName() != null ) {
            group.setName( updateDTO.getName() );
        }

        return group;
    }
}
