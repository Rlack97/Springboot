package com.apple.shop.item;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

// 자동으로 테이블을 생성해주는 anotaion. 클래스명이 테이블명이된다.
@Entity
@Getter
@Setter
public class Item {
    // 컬럼 만드는 법 = 변수선언

    // 데이터 구분을 위한 컬럼
    // 외부 사용을 위한 public 추가
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    // 컬럼별 설정 가능 (빈칸불가능, 유일값, 컬럼타입 직접지정, 글자제한 설정)
    // @Column(nullable = false, unique = true, columnDefinition = "TEXT", length = 1000)
    // 외우지 말고, 필요하면 찾아쓰자

    private String title;
    // int 대신 Integer 사용 必 20억 이상일 경우 Long (숫자 + L 형태)
    private Integer price;
}