// 파일 경로 기입 .으로 경로를 구분하므로 폴더가 3개인 셈
package com.apple.shop;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

// 상품관련 컨트롤러 (비슷한 api는 모아두는게 좋음)
@Controller
@RequiredArgsConstructor // repository 등록용 롬복 annotation
public class ItemController {
    //JPA를 쓴 DB 입출력
    // 1. repository 생성 (interface파일)
    // 2. 원하는 클래스에 repository 등록
    private final ItemRepository itemRepository;
    // 만약 lombok 없이 하려면?
//    @Autowired
//    public ItemController(ItemRepository itemRepository) {
//        this.itemRepository = itemRepository;
//    }

    // 3. repository.입출력문법() 사용

    @GetMapping("/list")
    String products(Model model) {
        List<Item> result = itemRepository.findAll();

        model.addAttribute("items",result);
        return "list.html";
    }

    // 상품추가
    // 1. 이름/ 가격용 페이지와 폼
    // 2. 전송버튼 누르면 + 서버에서 검사 + db에 저장

    @GetMapping("/write")
    String write() {
        return "write.html";
    }


    @PostMapping("/item")
    String addPost(@ModelAttribute Item item) {

//        @RequestParam Map<String,String> formData
//        String title = formData.get("title");
//        Integer price = Integer.parseInt(formData.get("price"));
//
//        Item item = new Item();
//        item.setTitle(title);
//        item.setPrice(price);
//

        itemRepository.save(item);

        return "redirect:/list";
    }

    @GetMapping("/detail/{id}")
    String detail(@PathVariable Integer id, Model model){
        // 데이터가 없는 경우를 대비한 Optional
        Optional<Item> item = itemRepository.findById(id);
        if(item.isPresent()){
            model.addAttribute("item",item.get());
        } else{
            return "redirect:/list";
        }

        return "detail.html";
    }
}

