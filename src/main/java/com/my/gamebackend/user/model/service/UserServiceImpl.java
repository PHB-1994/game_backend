package com.my.gamebackend.user.model.service;

import com.my.gamebackend.user.model.dto.User;
import com.my.gamebackend.user.model.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;

    /**
     * 사용자 id 로 조회
     * @param userId 매개변수로 선택한 유저의 아이디를 가져와서
     * @return 해당 유저아이디가 DB 에 존재하면 가져온 DB 데이터를 전달할 것이고,
     *         만약에 DB 에 존재하지 않으면 null 과 같은 데이터를 프론트엔드에 전달할 것이다.
     */
    @Override
    public User getUserById(String userId) {
        return null;
    }

    @Override
    public List<User> getAllUser() {
        return List.of();
    }

    @Override
    public boolean updateProfileImage(String userId, String profileImageUrl) {
        return false;
    }

    @Override
    public boolean createUser(User user) {
        return false;
    }
}
