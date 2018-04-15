package com.kokonatsuDream.userfront.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kokonatsuDream.userfront.domain.Appointment;
import com.kokonatsuDream.userfront.service.AppointmentService;

@RestController
@RequestMapping("/api/appointment")
@PreAuthorize("hasRole('ADMIN')")
public class AppointmentResource {

	@Autowired
	private AppointmentService appointmentService;
	
	@RequestMapping("/all")
	public List<Appointment> findAppointmentList(){
		List<Appointment> appointmentList = appointmentService.findAll();
		
		return appointmentList;
	}
}
