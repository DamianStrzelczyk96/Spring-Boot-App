package com.strzelczyk.Springbootapp.api;

import com.strzelczyk.Springbootapp.DAO.Item;
import com.strzelczyk.Springbootapp.DAO.Orderz;
import com.strzelczyk.Springbootapp.manager.ItemManager;
import com.strzelczyk.Springbootapp.manager.OrderManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/item")
public class ItemApi {
    int orderId = 1;
    List<Item> items = new ArrayList<>();

    private OrderManager orderManager;

    @Autowired
    public void NewOrderApi(OrderManager orderManager) {
        this.orderManager = orderManager;
    }


    private ItemManager itemManager;

    @Autowired
    public ItemApi(ItemManager itemManager) {
        this.itemManager = itemManager;
    }


    //Wyswietla wszystkie przedmioty zapisane na liscie
    @GetMapping("/all")
    public Iterable<Item> getAll() {
        return itemManager.findAll();
    }

    //Wyswietla dany przedmiot poprzez wskazanie konkretnego ID
    @GetMapping
    public Optional<Item> getById(@RequestParam Long index) {
        return itemManager.findById(index);
    }

    //Dodaje przedmiot
    @PostMapping
    public Item addItem(@RequestBody Item item) {
        return itemManager.save(item);
    }
    //Aktualizuje dany przedmiot
    @PutMapping
    public Item updateItem(@RequestBody Item item) {
        return itemManager.save(item);
    }
    //Usuwa przedmiot
    @DeleteMapping
    public void deleteItem(@RequestParam Long index) {
        itemManager.deleteById(index);
    }

    //Dodaje przedmiot do zamowienia
    @GetMapping("/addToOrder")
    public List<Item> addItemToOrder(@RequestParam Long index){
        items.add(itemManager.findItem(index));
        return items;
    }
    //Zapisuje permamentnie zamowienie
    @GetMapping("/saveOrder")
    public boolean saveOrderById(){

        orderManager.saveList(items, orderId);
        orderId++;
        items.clear();
        return true;
    }
    //Sprawdza aktualne zamowienie
    @GetMapping("/checkActualOrder")
    public List<Item> checkActualOrder(){
        List<Item>newItems =  itemManager.updateActualOrder(items);
        items.clear();
        items = newItems;
        return items;
    }
    //Sprawdza aktualny koszt danego zamownienia
    @GetMapping("/actualOrderCost")
    public double checkTotalCostOfActualOrder(){
     List<Item>newItems =  itemManager.updateActualOrder(items);
     items.clear();
     items = newItems;

     return itemManager.totalCostOfActualOrder(items);

    }



}

