package com.example.markettotable;

import java.util.ArrayList;

public class TinyDb {
    private static TinyDb instance;
    private ArrayList<Foods> dataList;


    private TinyDb() {
        dataList = new ArrayList<>();
    }

    public static TinyDb getInstance() {
        if (instance == null) {
            instance = new TinyDb();
        }
        return instance;
    }

    public ArrayList<Foods> getDataList() {
        return dataList;
    }

    public void addToDataList(String name, String price, int path,Store store) {
        dataList.add(new Foods(name,price,path,store));
    }


}


