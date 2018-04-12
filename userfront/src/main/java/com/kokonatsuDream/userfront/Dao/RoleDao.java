package com.kokonatsuDream.userfront.Dao;

import org.springframework.data.repository.CrudRepository;

import com.kokonatsuDream.userfront.domain.security.Role;

public interface RoleDao extends CrudRepository<Role, Integer>{
	Role findByName(String name);
}
