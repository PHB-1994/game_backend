package com.my.gamebackend.user.model.service;

import com.my.gamebackend.user.model.dto.User;
import com.my.gamebackend.user.model.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

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
        log.info("사용자 조회 : {}", userId);
        return userMapper.findByUserId(userId);
    }

    /**
     * 모든 사용자 조회
     * 클라이언트가 모든 유저 정보 조회를 UI 에서 요청하고
     * @return 해당 결과를 전달
     */
    @Override
    public List<User> getAllUser() {
        return userMapper.findAllUsers();
    }
    
    @Override
    public boolean updateProfileImage(String userId, String profileImageUrl) {
        log.info("프로필 이미지 업데이트 - 사용자 : {}, URL : {}", userId, profileImageUrl);
        int result = userMapper.updateProfileImage(userId, profileImageUrl);
        // 업데이트 한 결과가 0 이라면 boolean 결과로 false 가 return 에서 반환될 것이고
        // 업데이트 한 결과가 1 이상이라면 boolean 결과로 true 가 return 에서 반환될 것이다.
        return result > 0;
    }

    /**
     * 새 사용자 추가
     * @param user flutter 에서 유저가 작성한 유저 정보 받아오고
     * @return 저장 결과 유무를 반환
     */
    @Override
    public boolean createUser(User user) {
        log.info("사용자 생성 : {}", user);
        int result = userMapper.insertUser(user);
        // 만약에 성공적으로 유저를 DB 에서 저장했다면 true 반환
        // 저장한 기록이 없다면 0 을 반환하여 true false 형태로 controller 에
        // 했어요. 안했어요 결과를 전달
        return result > 0;
    }
}
