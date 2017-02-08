package com.ttem.data;

import com.ttem.dao.User;

import java.util.ArrayList;
import java.util.List;

public class Xml extends Data{

    private final static Xml instance = new Xml();

    private Xml() {
    }

    public static Xml getInstance() {
        return Xml.instance;
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
