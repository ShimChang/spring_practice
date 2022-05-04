package hello.itemservice.domain.item;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository //componentscan의 대상이 됨
public class ItemRepository {
    private static final Map<Long, Item> store = new HashMap<>();
    private static Long sequence=0L;

    public Item save(Item item){
        item.setId(++sequence);
        store.put(item.getId(), item);
        return item;
    }
    public Item findById(Long id){
        return store.get(id);
    }
    public List<Item> findAll(){
        return new ArrayList<>(store.values());
        // 직접 반환하지 않고 arrayList로 감싸서 반환하는 이유는 arrayList에 값을 넣더라도 실제 store에는 영향을 주지 않는다
    }
    public void update(Long itemId,Item updateParam){
        Item findItem = findById(itemId);
        findItem.setItemName(updateParam.getItemName());
        findItem.setPrice(updateParam.getPrice());
        findItem.setQuantity(updateParam.getQuantity());
    }
    public void clearStore(){
        store.clear();
    }
}
