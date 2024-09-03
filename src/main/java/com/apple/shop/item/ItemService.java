package com.apple.shop.item;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;

    public void saveItem(String title, Integer price){
        Item item = new Item();
        item.setTitle(title);
        item.setPrice(price);
        itemRepository.save(item);
    }

    // ID로 항목 조회
    public Item findById(Integer id) {
        return itemRepository.findById(id).orElse(null);
    }

    // 기존 항목 업데이트
    public void updateItem(Integer id, String title, Integer price) {
        Item item = findById(id);
        if (item != null) {
            item.setId(id);
            item.setTitle(title);
            item.setPrice(price);
            itemRepository.save(item);
        }
    }

    public void deleteItem(Integer id) {
        Item item = findById(id);
        if (item != null) {
            itemRepository.delete(item);
        } else {
            throw new EntityNotFoundException("Item not found with id: " + id);
        }
    }

}
