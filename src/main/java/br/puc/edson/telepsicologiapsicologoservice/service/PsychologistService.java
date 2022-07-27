package br.puc.edson.telepsicologiapsicologoservice.service;

import br.puc.edson.telepsicologiapsicologoservice.model.Psychologist;
import br.puc.edson.telepsicologiapsicologoservice.repository.PsychologistRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PsychologistService {

    private final PsychologistRepository repository;

    public List<Psychologist> listAll() {
        return repository.findAll();
    }

    public Optional<Psychologist> findByEmail(String email) {
        return repository.findByEmail(email);
    }

    public Optional<Psychologist> findByCrp(String crp) {
        return repository.findByCrp(crp);
    }
}
