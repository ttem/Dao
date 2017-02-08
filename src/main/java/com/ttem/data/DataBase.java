package com.ttem.data;

import com.ttem.dao.User;

import java.util.ArrayList;
import java.util.List;

public class DataBase extends Data{

    private final static DataBase instance = new DataBase();

    private DataBase() {

    }

    public static DataBase getInstance() {
        return DataBase.instance;
    }

    @Override
    public User selectUserById(final int id) {
        return new User(id);
    }

    @Override
    public List<User> selectAllUsers() {
        return new ArrayList<>();
    }
}
