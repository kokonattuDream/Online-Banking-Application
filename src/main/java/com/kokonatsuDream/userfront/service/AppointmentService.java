package com.kokonatsuDream.userfront.service;

import java.util.List;

import com.kokonatsuDream.userfront.domain.Appointment;

public interface AppointmentService {
	Appointment createAppointment(Appointment appointment);

    List<Appointment> findAll();

    Appointment findAppointment(Long id);

    void confirmAppointment(Long id);
}
