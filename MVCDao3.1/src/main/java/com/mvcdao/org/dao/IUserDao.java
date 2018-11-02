package com.mvcdao.org.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;



import com.mvcdao.org.models.UserBean;

public interface IUserDao extends CrudRepository<UserBean, Long> {
	//@Query("select u from users u where u.username=sdfsdf1123")
	//public UserBean findByUsername( String username);
	
	public List<UserBean> findByUsername(String username);
}
