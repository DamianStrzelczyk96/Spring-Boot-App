package com.strzelczyk.Springbootapp.manager;


import com.strzelczyk.Springbootapp.DAO.Item;
import com.strzelczyk.Springbootapp.DAO.Orderz;
import com.strzelczyk.Springbootapp.DAO.OrderRepo;
import com.strzelczyk.Springbootapp.exception.ItemError;
import com.strzelczyk.Springbootapp.exception.ItemExceptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrderManager {
    private OrderRepo orderRepo;

    @Autowired
    public OrderManager(OrderRepo orderRepo) {
        this.orderRepo = orderRepo;
    }


    public  Iterable<Orderz> findAll(){return orderRepo.findAll();
    }

    public Optional<Orderz> findById(Long id) {
        return orderRepo.findById(id);
    }

    public double getTotalCostById(Long id){
        double cost = 0;
        List<Orderz> orderzs = getOrderByIdOrder(id);
        for (Orderz orderz : orderzs
        ) {
            cost = cost + orderz.getPrice();
        }
        return cost;
    }

    public List<Orderz> getOrderByIdOrder(Long id){

        List<Orderz> orderzs = new ArrayList<>();
        orderRepo.findAll().forEach(orderzs::add);
        if(orderzs.size()==0){
            throw new ItemExceptions(ItemError.YOU_DO_NOT_HAVE_ANY_ORDERS);
        }
        List<Orderz> newOrderzs = new ArrayList<>();
        for (Orderz orderz : orderzs
        ) {if(orderz.getOrderID()==id){
            newOrderzs.add(orderz);}
        }
        if(newOrderzs.size()==0){
            throw new ItemExceptions(ItemError.ORDER_WITH_THAT_ID_DOES_NOT_EXIST);
        }
        return newOrderzs;
    }


    public Orderz save(Orderz orderz) {
        return orderRepo.save(orderz);
    }


    public void saveList(List<Item> items, int orderId) {
        if(items.size()==0){
            throw new ItemExceptions(ItemError.ORDER_LIST_IS_EMPTY);
        }
        for (Item item:items
        ) {
            Orderz orderz = new Orderz(item.getName(),item.getPrice(),orderId);
            orderRepo.save(orderz);
        }

    }
}


