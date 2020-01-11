package com.bchennu.demo.model;

import java.time.LocalDateTime;
import java.util.List;

import static com.bchennu.demo.model.OrderState.*;

public class Order extends BaseEntity {

    private String userId;

    private String restaurantId;

    private List<OrderItem> orderItems;

    private Address deliveryAddress;

    private PaymentInfo paymentInfo;

    private OrderState state;

    private LocalDateTime orderDate;

    private Driver driver;

    public Order(String userId, String restaurantId, List<OrderItem> orderItems){
        super();
        this.userId=userId;
        this.restaurantId=restaurantId;
        this.orderItems=orderItems;
        this.orderDate=LocalDateTime.now();

    }

    public void approveOrder(){
        switch(state) {
            case ORDER_PENDING:
                this.setState(ORDER_APPROVED);
                break;

            default:
                throw new UnsupportedOperationException("Wrong state of order");
        }
    }

    public void rejectOrder(){
        switch(state) {
            case ORDER_PENDING:
                this.setState(ORDER_REJECTED);
                break;

            default:
                throw new UnsupportedOperationException("Wrong state of order");
        }
    }


    public String getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(String restaurantId) {
        this.restaurantId = restaurantId;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    public Address getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(Address deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public PaymentInfo getPaymentInfo() {
        return paymentInfo;
    }

    public void setPaymentInfo(PaymentInfo paymentInfo) {
        this.paymentInfo = paymentInfo;
    }

    public OrderState getState() {
        return state;
    }

    public void setState(OrderState state) {
        this.state = state;
    }

    public Money getOrderTotal() {
        double orderTotal=0;
        for(OrderItem item:orderItems) orderTotal += item.getQuantity() * item.getPrice().getAmount();
        return new Money(orderTotal);
    }

    public String getUserId() {
        return userId;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }
}
