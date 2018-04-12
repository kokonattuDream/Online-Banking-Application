package com.kokonatsuDream.userfront.Dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.kokonatsuDream.userfront.domain.Appointment;


public interface AppointmentDao extends CrudRepository<Appointment, Long>{
	List<Appointment> findAll();
}
