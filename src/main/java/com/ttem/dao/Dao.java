package com.ttem.dao;

import com.ttem.data.Data;
import com.ttem.data.SourceType;

import java.util.List;

public class Dao implements DaoInterface{

    private static Dao ourInstance = new Dao();

    private SourceType sourceType;
    private Data data;

    public static Dao getInstance() {
        return ourInstance;
    }

    private Dao() {
    }

    public User selectUserById(final int id) {
        return this.data.selectUserById(id);
    }

    public List<User> selectAllUsers() {
        return this.data.selectAllUsers();
    }
}
