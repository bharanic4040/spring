package com.bchennu.demo.service;

import com.bchennu.demo.model.Order;
import com.bchennu.demo.repositories.OrderRepository;
import com.bchennu.demo.repositories.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.Collections;
import java.util.Optional;

@Transactional
public class OrderService {

    @Autowired
    private DeliveryService deliveryService;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private RestaurantRepository restaurantRepository;


    public Iterable<Order> findAll() {
        return Collections.emptyList();
    }


    public void createOrderSaga(Order order){
        //find the restaurant

        //create order

        Order newOrder = new Order(order.getUserId(),order.getRestaurantId(),order.getOrderItems());

        //allocate driver
        deliveryService.allocateDriver(order);

        

    }

    public Optional<Order> findById(Long id) {

        return orderRepository.findById(id);
    }



}
