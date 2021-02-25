package com.strzelczyk.Springbootapp.api;

import com.strzelczyk.Springbootapp.DAO.Orderz;
import com.strzelczyk.Springbootapp.manager.OrderManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/order")
public class OrderApi {

    private OrderManager orderManager;

    @Autowired
    public OrderApi(OrderManager orderManager) {
        this.orderManager = orderManager;
    }
    //Wyswietla wszystkie zapisane zamowienia
    @GetMapping("/all")
    public Iterable<Orderz> getAll() {
        return orderManager.findAll();
    }

    //Wyswietla konkretne zamowienie za pomoca podanego IdOrder
    @GetMapping
    public Optional<Orderz> getById(@RequestParam Long index) {
        return orderManager.findById(index);
    }
    //Dodaje zamowenie
    @PostMapping
    public Orderz addOrder(@RequestBody Orderz orderz) {
        return orderManager.save(orderz);
    }
    //Wyswietla koszt zapisanego zamowienia za pomoca IdOrder
    @GetMapping("/cost")
    public double getTotalCostById(@RequestParam Long index) {
        return orderManager.getTotalCostById(index);
    }
    //Wyswietla  zapisane zamowienie za pomoca IdOrder
    @GetMapping("/getOrderById")
    public List<Orderz> getOrderById(@RequestParam Long index) {
        return orderManager.getOrderByIdOrder(index);
    }


}
