package com.example.markettotable;

public class Foods {
    String foodname;
    String price;
    int path;
    int amount;

    public Foods(String foodname, String price, int path, int amount) {
        this.foodname = foodname;
        this.price = price;
        this.path = path;
        this.amount = amount;
    }

    public String getFoodname() {
        return foodname;
    }

    public void setFoodname(String foodname) {
        this.foodname = foodname;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getPath() {
        return path;
    }

    public void setPath(int path) {
        this.path = path;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
