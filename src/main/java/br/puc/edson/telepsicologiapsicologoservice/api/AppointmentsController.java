package br.puc.edson.telepsicologiapsicologoservice.api;


import br.puc.edson.telepsicologiapsicologoservice.dto.RequestDto;
import br.puc.edson.telepsicologiapsicologoservice.service.AppointmentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
@AllArgsConstructor
public class AppointmentsController {

    private final AppointmentService service;

    @GetMapping("/requests/{psychologistId}")
    List<RequestDto> getAppointmentsRequests(@PathVariable String psychologistId) {
        return service.getAppointmentsRequests(psychologistId);
    }

    @GetMapping("/scheduled/{psychologistId}")
    List<RequestDto> getAppointmentsSchedulled(@PathVariable String psychologistId) {
        return service.getAppointmentsSchedulled(psychologistId);
    }

    @GetMapping("/pastAppointments/{psychologistId}")
    List<RequestDto> getAppointmentsDone(@PathVariable String psychologistId) {
        return service.getAppointmentsDone(psychologistId);
    }

}
