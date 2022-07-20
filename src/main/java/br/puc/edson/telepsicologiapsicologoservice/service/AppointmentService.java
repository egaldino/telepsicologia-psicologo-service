package br.puc.edson.telepsicologiapsicologoservice.service;

import br.puc.edson.telepsicologiapsicologoservice.dto.RequestDto;
import br.puc.edson.telepsicologiapsicologoservice.mapper.AppointmentMapper;
import br.puc.edson.telepsicologiapsicologoservice.model.Appointment;
import br.puc.edson.telepsicologiapsicologoservice.repository.AppointmentRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AppointmentService {

    private final AppointmentRepository repository;

    public List<RequestDto> getAppointmentsRequests(String psychologistId) {
        return getAppointmentsByStatus(psychologistId, Appointment.AppointmentStatus.REQUESTED);
    }

    public List<RequestDto> getAppointmentsSchedulled(String psychologistId) {
        return getAppointmentsByStatus(psychologistId, Appointment.AppointmentStatus.SCHEDULED);
    }

    public List<RequestDto> getAppointmentsDone(String psychologistId) {
        return getAppointmentsByStatus(psychologistId, Appointment.AppointmentStatus.DONE);
    }

    private List<RequestDto> getAppointmentsByStatus(String psychologistId, Appointment.AppointmentStatus requested) {
        return repository.findByPsychologistIdAndStatus(psychologistId, requested)
                .stream()
                .map(AppointmentMapper.INSTANCE::toRequestDto)
                .collect(Collectors.toList());
    }
}
