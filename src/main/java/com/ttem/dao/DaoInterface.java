package com.ttem.dao;

import java.util.List;

public interface DaoInterface {
	
	User selectUserById(final int id);

	List<User> selectAllUsers();
}

