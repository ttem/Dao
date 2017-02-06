package com.ttem.dao;

public class Dao {

    private static Dao ourInstance = new Dao();

    public static Dao getInstance() {
        return ourInstance;
    }

    private Dao() {
    }
}
