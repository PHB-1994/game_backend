package com.my.gamebackend.user.controller;

import com.my.gamebackend.user.model.dto.User;
import com.my.gamebackend.user.model.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    /**
     * 모든 사용자 조회
     * @return 서비스에서 작업한 결과를 반환하고, 반한된 결과 상태를 프론트엔드에 전달
     */
    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        log.info("전체 사용자 목록 조회 요청");
        List<User> users = userService.getAllUser();
        return ResponseEntity.ok(users);
    }

    /**
     * 사용자 프로필 조회
     * @param userId
     * @return
     */
    @GetMapping("/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable("userId") String userId) {
        log.info("사용자 조회 요청 : {}", userId);
        User user = userService.getUserById(userId);
        if(user == null){
            log.warn("사용자를 찾을 수 없음");
            return ResponseEntity.notFound().build();
        }
        log.info("사용자 조회 성공 : {}", user.getUserName());
        return ResponseEntity.ok(user);
    }
}
