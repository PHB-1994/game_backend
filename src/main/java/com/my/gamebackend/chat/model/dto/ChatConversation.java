package com.my.gamebackend.chat.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * 대화방 정보
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChatConversation {
    private Long id;                    // 대화방 고유 ID
    private String userId;              // 사용자 고유 ID
    private LocalDateTime createdAt;    // 대화방 생성 시간
    private LocalDateTime updatedAt;    // 대화방 마지막 업데이트 시간
}
