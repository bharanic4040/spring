package com.bchennu.demo.repositories;

import com.bchennu.demo.model.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order,Long> {
}
