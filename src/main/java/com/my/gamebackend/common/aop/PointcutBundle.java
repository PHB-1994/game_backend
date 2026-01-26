package com.my.gamebackend.common.aop;
/*
        id 'org.springframework.boot' version '3.5.9'
        implementation 'org.springframework.boot:spring-boot-starter-aop'


        모듈 사용할 때 캐시 무효화 -> 동기화까지 모두 작업했지만, import 에서 빨간 에러가 발생할 때
        대부분 java - springboot - module 호환성 문제
        본인의 주 언어와 프레임워크 버전이 너무 최신 버전은 아닌지 확인
        되도록이면 대중화 되어 있는 버전 숫자를 사용하는 것이 안전하다.

        id 'org.springframework.boot' version '4.0.2'
        ↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓
        id 'org.springframework.boot' version '3.5.9'
 */

import org.aspectj.lang.annotation.Pointcut;

public class PointcutBundle {

    @Pointcut("execution(* com.my.gamebackend..*Controller*.*(..))")
    public void controllerPointCut(){}

    @Pointcut("execution(* com.my.gamebackend..*ServiceImpl*.*(..))")
    public void serviceImplPointCut(){}
}