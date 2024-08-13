// 파일 경로 기입 .으로 경로를 구분하므로 폴더가 3개인 셈
package com.apple.shop;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

// 상품관련 컨트롤러 (비슷한 api는 모아두는게 좋음)
@Controller
public class ItemController {
    @GetMapping("/list")
    String products(Model model) {
        model.addAttribute("name","김찬빈");
        return "list.html";
    }
}
