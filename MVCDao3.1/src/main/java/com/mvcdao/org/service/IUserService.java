package com.mvcdao.org.service;

import java.util.List;

import com.mvcdao.org.models.UserBean;

public interface IUserService {
	public void saveUser(UserBean user);
	public List<UserBean> findByUsername(String username);
	public boolean existUser(String username);
	public boolean login(String username, String password);
}
