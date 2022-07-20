package br.puc.edson.telepsicologiapsicologoservice.repository;

import br.puc.edson.telepsicologiapsicologoservice.model.Appointment;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AppointmentRepository extends MongoRepository<Appointment, String> {

    List<Appointment> findByPsychologistIdAndStatus(String psychologistId, Appointment.AppointmentStatus status);
}
