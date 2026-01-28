package com.my.gamebackend.user.model.mapper;

import com.my.gamebackend.user.model.dto.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    User findByUserId(String userId);
    int updateProfileImage(String userId, String profileImageUrl);
    List<User> findAllUsers();
    int insertUser(User user);
}
