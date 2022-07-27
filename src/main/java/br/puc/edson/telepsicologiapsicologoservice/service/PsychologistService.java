package br.puc.edson.telepsicologiapsicologoservice.service;

import br.puc.edson.telepsicologiapsicologoservice.dto.PsychologistDto;
import br.puc.edson.telepsicologiapsicologoservice.mapper.PsychologistMapper;
import br.puc.edson.telepsicologiapsicologoservice.model.Psychologist;
import br.puc.edson.telepsicologiapsicologoservice.repository.PsychologistRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PsychologistService {

    private final PsychologistRepository repository;

    public List<PsychologistDto> listAll() {
        return repository.findAll()
                .stream()
                .map(PsychologistMapper.INSTANCE::modelToDto)
                .collect(Collectors.toList());
    }

    public Optional<Psychologist> findByEmail(String email) {
        return repository.findByEmail(email);
    }
}
