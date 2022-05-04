package hello.itemservice.domain.item;

import org.junit.jupiter.api.AfterEach;

import static org.junit.jupiter.api.Assertions.*;

class ItemRepositoryTest {
    ItemRepository itemRepository = new ItemRepository();

    @AfterEach  //테스트를 끝날때마다 실행
    void afterEach(){
        itemRepository.clearStore();
    }


}