package com.kokonatsuDream.userfront.Dao;

import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;
import com.kokonatsuDream.userfront.domain.User;

@Repository
public interface UserDao extends CrudRepository<User, Long>{
	User findByUsername(String username);
	User findByEmail(String email);
}
