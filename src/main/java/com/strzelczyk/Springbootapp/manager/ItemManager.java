package com.strzelczyk.Springbootapp.manager;

import com.strzelczyk.Springbootapp.DAO.Item;
import com.strzelczyk.Springbootapp.DAO.ItemRepo;
import com.strzelczyk.Springbootapp.exception.ItemError;
import com.strzelczyk.Springbootapp.exception.ItemExceptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ItemManager {

    private ItemRepo itemRepo;

    @Autowired
    public ItemManager(ItemRepo itemRepo) {
        this.itemRepo = itemRepo;
    }
    public Optional<Item> findById(Long id) {
        return itemRepo.findById(id);
    }

    public Iterable<Item> findAll() {
        return itemRepo.findAll();
    }

    public Item save(Item item) {
        return itemRepo.save(item);
    }
    public void deleteById(Long id) {
        itemRepo.deleteById(id);
    }

    public Item findItem(Long id){
        List<Item>items = new ArrayList<>();
                itemRepo.findAll().forEach(items::add);
        if(items.size()==0){
            throw new ItemExceptions(ItemError.ITEM_LIST_IS_EMPTY);
        }
                Item returnItem = new Item();
        for (Item item:items
             ) {if(item.getId().equals(id)){
                 returnItem=item;
        }}

try {
    if(returnItem.getName().equals("null")){}
}catch (NullPointerException e){
    throw new ItemExceptions(ItemError.ITEM_DOES_NOT_EXIST);
}


        return  returnItem;
    }

    public List<Item> updateActualOrder(List<Item> items){
        if(items.size()==0){
            throw new ItemExceptions(ItemError.ORDER_LIST_IS_EMPTY);
        }


        List<Item> newItems = new ArrayList<>();
        for (Item item:items
        ) {newItems.add(findItem(item.getId()));
        }

        return  newItems;
    }


    public double totalCostOfActualOrder(List<Item> items){
        if(items.size()==0){
            throw new ItemExceptions(ItemError.ORDER_LIST_IS_EMPTY);
        }

    double total = 0;
        for (Item item:items
             ) {total = total + item.getPrice();
        }

            return total;

    }

}
