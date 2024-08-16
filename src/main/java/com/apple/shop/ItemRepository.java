// 테이블명 + 리포지토리
package com.apple.shop;

import org.springframework.data.jpa.repository.JpaRepository;

// JpaRepository <엔티티 명, id컬럼의 타입 >
public interface ItemRepository extends JpaRepository<Item, Integer> {
}
