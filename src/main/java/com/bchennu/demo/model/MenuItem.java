package com.bchennu.demo.model;

public class MenuItem {

    private String name;
    private Money price;
    private MenuType isVeg;

    public MenuItem(String name, Money price, MenuType isVeg) {
        this.name = name;
        this.price = price;
        this.isVeg = isVeg;
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

    public MenuType getIsVeg() {
        return isVeg;
    }

    public void setIsVeg(MenuType isVeg) {
        this.isVeg = isVeg;
    }
}

