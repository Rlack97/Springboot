// 파일 경로 기입 .으로 경로를 구분하므로 폴더가 3개인 셈
package com.apple.shop.item;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Objects;
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
    // new 선언을 절약하기 위한 변수 선언
    private final ItemService itemService;


    @PostMapping("/com/apple/shop/item")
    String addPost(String title, Integer price) {

//        @RequestParam Map<String,String> formData
//        String title = formData.get("title");
//        Integer price = Integer.parseInt(formData.get("price"));

        //itemService에서 불러온 함수
        System.out.println(title);
        System.out.println(price);
        itemService.saveItem(title, price);

        return "redirect:/list";
    }

    @GetMapping("/detail/{id}")
    String detail(@PathVariable Integer id, Model model) {
//            throw new Exception("에러의 에러;");
            // 데이터가 없는 경우를 대비한 Optional
            Optional<Item> item = itemRepository.findById(id);
            if (item.isPresent()) {
                model.addAttribute("item", item.get());
                return "detail.html";
            } else {
                return "redirect:/list";
            }
    }

    // 수정 페이지로 이동
    @GetMapping("/edit/{id}")
    String edit(@PathVariable Integer id, Model model) {
        Optional<Item> item = itemRepository.findById(id);
        if (item.isPresent()) {
            model.addAttribute("data", item.get());
            return "edit.html";
        } else {
            return "redirect:/list";
        }
    }

    // db 수정
    @PostMapping("/edit")
    String editPost( Integer id,  String title,  Integer price) {
        itemService.updateItem(id, title, price);
        return "redirect:/list";
    }

    //같은 컨트롤러 파일의 다른 곳에서 에러가 나는 경우 실행하는 함수
//    @ExceptionHandler(Exception.class)
//    public ResponseEntity<String> handler(){
//        return ResponseEntity.status(400).body("니잘못");
//
//    }
    @DeleteMapping("/delete/{id}")
    String delete(@PathVariable Integer id){
        System.out.println(id);
        itemService.deleteItem(id);
        return "redirect:/list";
    }
}



