package com.apple.shop;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

// 모든 컨트롤러의 에러 핸들링을 위한 파일
//@ControllerAdvice
//public class MyExceptionHandler {
//
//    // 에러 타입에 맞는 별도 핸들러 실행가능
//    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
//    public ResponseEntity<String> handler404(){
//        return ResponseEntity.status(400).body("에러남2");
//    }
//
//    @ExceptionHandler(Exception.class)
//    public ResponseEntity<String> handler(){
//        System.out.println();
//        return ResponseEntity.status(400).body("에러남");
//    }
//}
