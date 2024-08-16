package com.apple.shop;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class test {
    private Integer age;
    private String name;
    public void 한살더하기() {
        if (this.age < 99) {
            this.age += 1;
        } else {
            System.out.println("저런! 나이를 먹고 죽어버렸군요!");
        }
    }
    public void 나이설정(Integer a) {
        if (0 <= a && a < 100) {
            this.age = a;
        } else {
            System.out.println("사람 나이를 입력해주십시오");
        }
    }

    public static void main(String[] args) {
        var a = new test();  // var는 메서드 내에서만 사용 가능합니다.
        a.setName("김찬빈");
        a.setAge(30);
        a.나이설정(99);
        a.한살더하기();
        System.out.println(a.getAge());
        System.out.println(a.getName());
    }
}



