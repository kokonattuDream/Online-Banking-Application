package com.kokonatsuDream.userfront.service.UserServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kokonatsuDream.userfront.Dao.UserDao;
import com.kokonatsuDream.userfront.domain.User;
import com.kokonatsuDream.userfront.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserDao userDao;
	
	public void saveUser(User user) {
		// TODO Auto-generated method stub
		userDao.save(user);
		
	}
	
	public User findByUsername(String username) {
		return userDao.findByUsername(username);
	}
	
	public User findByEmail(String email) {
		return userDao.findByEmail(email);
	}
	
	public boolean checkUserExists(String username, String email) {
		if(checkUsernameExists(username) || checkEmailExists(email)) {
			return true;
		} else {
			return false;
		}
	}

	public boolean checkEmailExists(String email) {
		// TODO Auto-generated method stub
		if(null != findByEmail(email)) {
			return true;
		} else {
			return false;
		}
	}

	public boolean checkUsernameExists(String username) {
		// TODO Auto-generated method stub
		if(null != findByUsername(username)) {
			return true;
		} else {
			return false;
		}
	}

	
}
