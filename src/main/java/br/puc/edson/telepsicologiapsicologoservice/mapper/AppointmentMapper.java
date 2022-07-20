package br.puc.edson.telepsicologiapsicologoservice.mapper;

import br.puc.edson.telepsicologiapsicologoservice.dto.RequestDto;
import br.puc.edson.telepsicologiapsicologoservice.model.Appointment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AppointmentMapper {

    AppointmentMapper INSTANCE = Mappers.getMapper( AppointmentMapper.class );

    @Mapping(source = "date", target = "date", dateFormat = "dd/MM/yyyy")
    @Mapping(source = "date", target = "hour", dateFormat = "HH:mm")
    RequestDto toRequestDto(Appointment appointment);

}
