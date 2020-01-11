package com.bchennu.demo.controllers;

import com.bchennu.demo.exception.OrderNotFoundException;
import com.bchennu.demo.model.Order;
import com.bchennu.demo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping(value = "/", produces = "application/json")
    public ResponseEntity<List<Order>> findAllOrders() {

        List<Order> orders = (List<Order>) orderService.findAll();
       /* if (Order.size() == 0) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }*/
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<Order> findById(@PathVariable("id") Long id) {

        Order order = orderService.findById(id).orElseThrow(() -> new OrderNotFoundException(id));
        if (order == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(order, HttpStatus.OK);

    }

    @PostMapping(value = "/create", headers = "Accept=application/json")
    public ResponseEntity<Void> createOrder(@RequestBody Order order, UriComponentsBuilder ucBuilder) {
        System.out.println("Creating Order ");
        orderService.createOrderSaga(order);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/order/{id}").buildAndExpand(order.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }


}
