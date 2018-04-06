package com.kokonatsuDream.userfront.Dao;

import com.kokonatsuDream.userfront.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends CrudRepository<User, Long>{
	User findByUserName(String username);
	User findByEmail(String email);
}
