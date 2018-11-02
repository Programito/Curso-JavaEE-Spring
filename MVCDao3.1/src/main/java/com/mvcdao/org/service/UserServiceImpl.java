package com.mvcdao.org.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mvcdao.org.dao.IUserDao;
import com.mvcdao.org.models.UserBean;

@Service
public class UserServiceImpl implements IUserService {
	@Autowired
	private IUserDao userDao;

	@Override
	public void saveUser(UserBean user) {
		userDao.save(user);
	}
	
	@Override
	public List<UserBean> findByUsername(String username){
		return userDao.findByUsername(username);
	}

	@Override
	public boolean existUser(String username) {
		return userDao.findByUsername(username).size()>=1;
	}

	@Override
	public boolean login(String username, String password) {
		boolean correcto=false;
		List<UserBean> userBeans=userDao.findByUsername(username);
		if(userBeans!=null && userBeans.size()>0) {
			UserBean userbean= userDao.findByUsername(username).get(0);
			if(userbean!=null && userbean.getPassword().equals(password)) {
				correcto=true;
			}
		
		}
		return correcto;
	}
	
}
