package com.my.gamebackend.chat.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
* 챗봇 지식 FAQ 데이터
* 사용자가  안녕 이라고 하면 keywords 에서 검색
 * 매칭되면 answer 를 응답으로 반환
 * priority 가 높은 것을 우선 선택
* */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChatbotKnowledge {
    /*
    Long, Integer = 클래스 형태로 숫자 데이터를 받지 못하면 null 형태로 전달받는다.
    int           = 기본 예약어의 형태로 숫자 데이터를 받지 못하면 null 구분하지 못하여 0으로 받음
    id 가 0 일 때 0번 째 존재하는 데이터인지, 오류인지 알 수 없음

    Primary Key(id) Long
    우선순위         Integer
    카운터, 반복문   int
    나이, 수량       Integer
     */
    private long id;                    // 지식 고유 ID
    // private int id;                  // 지식 고유 ID
    private String category;            // 카테고리 (인사, 날씨, 시간 등)
    private String[] keywords;          // 키워드 배열 ["안녕", "하이", "헬로"]
    private String question;            // 질문이 "안녕하세요" 와 같은 응답 잠시 보유
    private String answer;              // 답변이 "안녕하세요" 와 같은 응답 잠시 보유
    private Integer priority;           // 우선 순위
    // private int priority;            // 우선 순위
    private Boolean isActive;           // 활성화 여부
    private LocalDateTime createdAt;    // 생성 시간
    private LocalDateTime updatedAt;    // 수정 시간
}
/*
예상 상황별 데이터
category : 인사
keywords : ["안녕", "하이", "헬로", "ㅎㅇ", "gm"]
question : "아..안녕이 나오게 생겼습니까?"
answer   : "안녕하세요! 무엇을 도와드릴까요?"
priority : 10
 */