package com.example.markettotable;

public class Foods {
    String foodname;
    String price;
    int path;
    Store store;

    public Foods(String foodname, String price, int path, Store store) {
        this.foodname = foodname;
        this.price = price;
        this.path = path;
        this.store = store;
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

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }
}
