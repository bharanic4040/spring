package com.bchennu.demo.model;

public class OrderItem {

     private String name;
     private Money price;
     private int quantity;

     public OrderItem(String name, Money price, int quantity) {
          this.name = name;
          this.price = price;
          this.quantity = quantity;
     }

     public String getName() {
          return name;
     }

     public void setName(String name) {
          this.name = name;
     }

     public Money getPrice() {
          return price;
     }

     public void setPrice(Money price) {
          this.price = price;
     }

     public int getQuantity() {
          return quantity;
     }

     public void setQuantity(int quantity) {
          this.quantity = quantity;
     }
}
