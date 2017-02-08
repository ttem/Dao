package com.ttem.data;

import com.ttem.dao.User;

import java.util.ArrayList;
import java.util.List;

public class WebService extends Data{

    public User selectUserById(final int id) {
        return new User(id);
    }

    public List<User> selectAllUsers() {
        return new ArrayList<>();
    }
}
