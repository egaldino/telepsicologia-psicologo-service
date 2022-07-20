package br.puc.edson.telepsicologiapsicologoservice.service;

import br.puc.edson.telepsicologiapsicologoservice.dto.PsychologistDto;
import br.puc.edson.telepsicologiapsicologoservice.dto.RequestDto;
import br.puc.edson.telepsicologiapsicologoservice.model.Appointment;
import br.puc.edson.telepsicologiapsicologoservice.model.Psychologist;
import br.puc.edson.telepsicologiapsicologoservice.repository.AppointmentRepository;
import br.puc.edson.telepsicologiapsicologoservice.repository.PsychologistRepository;
import org.jeasy.random.EasyRandom;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
class AppointmentServiceTest {

    @Mock
    private AppointmentRepository repository;

    @InjectMocks
    private AppointmentService service;

    @Test
    public void shouldGetAppointmentsRequests(){
        String psychologistId = "crp";

        EasyRandom generator = new EasyRandom();
        List<Appointment> databaseReturn = generator
                .objects(Appointment.class, 10)
                .peek(appointment -> appointment.setStatus(Appointment.AppointmentStatus.REQUESTED))
                .collect(Collectors.toList());

        when(repository.findByPsychologistIdAndStatus(psychologistId, Appointment.AppointmentStatus.REQUESTED)).thenReturn(databaseReturn);

        List<RequestDto> result = service.getAppointmentsRequests(psychologistId);

        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter hourFormatter = DateTimeFormatter.ofPattern("HH:mm");

        assertEquals(databaseReturn.size(), result.size());
        for(int i=0; i < result.size(); i++){
            assertEquals(databaseReturn.get(i).getId(),result.get(i).getId());
            assertEquals(databaseReturn.get(i).getName(),result.get(i).getName());
            assertEquals(dateFormatter.format(databaseReturn.get(i).getDate()),result.get(i).getDate());
            assertEquals(hourFormatter.format(databaseReturn.get(i).getDate()),result.get(i).getHour());
        }
    }

    @Test
    public void shouldGetAppointmentsScheduled(){
        String psychologistId = "crp";

        EasyRandom generator = new EasyRandom();
        List<Appointment> databaseReturn = generator
                .objects(Appointment.class, 10)
                .peek(appointment -> appointment.setStatus(Appointment.AppointmentStatus.SCHEDULED))
                .collect(Collectors.toList());

        when(repository.findByPsychologistIdAndStatus(psychologistId, Appointment.AppointmentStatus.SCHEDULED)).thenReturn(databaseReturn);

        List<RequestDto> result = service.getAppointmentsSchedulled(psychologistId);

        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter hourFormatter = DateTimeFormatter.ofPattern("HH:mm");

        assertEquals(databaseReturn.size(), result.size());
        for(int i=0; i < result.size(); i++){
            assertEquals(databaseReturn.get(i).getId(),result.get(i).getId());
            assertEquals(databaseReturn.get(i).getName(),result.get(i).getName());
            assertEquals(dateFormatter.format(databaseReturn.get(i).getDate()),result.get(i).getDate());
            assertEquals(hourFormatter.format(databaseReturn.get(i).getDate()),result.get(i).getHour());
        }
    }

    @Test
    public void shouldGetAppointmentsDone(){
        String psychologistId = "crp";

        EasyRandom generator = new EasyRandom();
        List<Appointment> databaseReturn = generator
                .objects(Appointment.class, 10)
                .peek(appointment -> appointment.setStatus(Appointment.AppointmentStatus.DONE))
                .collect(Collectors.toList());

        when(repository.findByPsychologistIdAndStatus(psychologistId, Appointment.AppointmentStatus.DONE)).thenReturn(databaseReturn);

        List<RequestDto> result = service.getAppointmentsDone(psychologistId);

        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter hourFormatter = DateTimeFormatter.ofPattern("HH:mm");

        assertEquals(databaseReturn.size(), result.size());
        for(int i=0; i < result.size(); i++){
            assertEquals(databaseReturn.get(i).getId(),result.get(i).getId());
            assertEquals(databaseReturn.get(i).getName(),result.get(i).getName());
            assertEquals(dateFormatter.format(databaseReturn.get(i).getDate()),result.get(i).getDate());
            assertEquals(hourFormatter.format(databaseReturn.get(i).getDate()),result.get(i).getHour());
        }
    }

}