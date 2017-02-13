package com.ttem.data;

import com.ttem.dao.DaoInterface;
import com.ttem.dao.User;
import java.util.List;

public abstract class Data implements DaoInterface{

    public abstract User selectUserById(int id);

    public abstract List<User> selectAllUsers();
}
