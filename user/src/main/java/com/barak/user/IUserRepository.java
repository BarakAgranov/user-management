package com.barak.user;

import com.barak.clients.dto.UserGetOneDto;
import com.barak.user.dto.UserGetAllDto;
import com.barak.user.dto.UserGetFatDto;
import com.barak.user.dto.UserGetSlimDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IUserRepository extends JpaRepository<User, Long> {

    boolean existsByEmail(String email);

    boolean existsByEmailAndPassword(String email, String password);

    @Query("select new com.barak.user.dto.UserGetAllDto(u.id, u.firstName, u.lastName) from User u")
    List<UserGetAllDto> getAllUsersDto();

    @Query("select new com.barak.user.dto.UserGetSlimDto(u.id, u.email, u.firstName, u.lastName) from User u where u.id = ?1")
    UserGetSlimDto getUserSlimDtoById(long userId);

    @Query("select new com.barak.user.dto.UserGetFatDto(u.id, u.email, u.password, u.firstName, u.lastName, u.userType) from User u where u.id = ?1")
    UserGetFatDto getUserFatDtoById(long id);


}
