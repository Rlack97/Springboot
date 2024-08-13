package com.apple.shop;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDateTime;
import java.util.Date;

@Controller
public class BasicController {
    //  getmapping 내부에는 사용할 url입력
    @GetMapping("/")
    String response() {
        return "index.html";
    }
    //@ResponseBody는 return 뒤의 문자 데이터만 보내는 옵션
    // 즉 html을 직접 보내려면 빼 주면 됨

    @GetMapping("/about")
    @ResponseBody
        // return 뒤의 문자 데이터만 보내는 옵션
    String introduce() {
        return "소개페이지입니다";
    }

    // 숙제 - 날짜 및 시간 반환
    @GetMapping("/date")
    @ResponseBody
    // return 뒤의 문자 데이터만 보내는 옵션
    String DateTime() {
//        var now = new Date();
//        String nowTime = now.toString();
//        return nowTime;
        // 또는
        return LocalDateTime.now().toString();
    }
}
