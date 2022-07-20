package br.puc.edson.telepsicologiapsicologoservice.mapper;

import br.puc.edson.telepsicologiapsicologoservice.dto.PsychologistDto;
import br.puc.edson.telepsicologiapsicologoservice.model.Psychologist;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PsychologistMapper {

    PsychologistMapper INSTANCE = Mappers.getMapper( PsychologistMapper.class );

    PsychologistDto modelToDto(Psychologist psychologist);
}
