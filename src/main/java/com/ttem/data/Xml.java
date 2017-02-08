package com.ttem.data;

import com.ttem.dao.User;

import java.util.ArrayList;
import java.util.List;

public class Xml extends Data{

    @Override
    public User selectUserById(final int id) {
        return new User(id);
    }

    @Override
    public List<User> selectAllUsers() {
        return new ArrayList<>();
    }
}
