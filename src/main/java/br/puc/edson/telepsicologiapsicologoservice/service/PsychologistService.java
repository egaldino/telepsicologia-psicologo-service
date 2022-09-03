package br.puc.edson.telepsicologiapsicologoservice.service;

import br.puc.edson.telepsicologiapsicologoservice.model.Psychologist;
import br.puc.edson.telepsicologiapsicologoservice.repository.PsychologistRepository;
import lombok.RequiredArgsConstructor;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PsychologistService {

    private final PsychologistRepository repository;
    private final DataCryptoService dataCryptoService;

    public List<Psychologist> listAll() {
        return repository.findAll()
                .stream()
                .map(this::decrypt)
                .collect(Collectors.toList());
    }

    public Optional<Psychologist> findByCrp(String crp) {
        return repository.findByCrpHash(DigestUtils.sha256Hex(crp)).map(this::decrypt);
    }

    private Psychologist decrypt(Psychologist psychologist) {

        return Psychologist
                .builder()
                .crpHash(psychologist.getCrpHash())
                .crp(dataCryptoService.decrypt(psychologist.getCrp()))
                .email(dataCryptoService.decrypt(psychologist.getEmail()))
                .name(dataCryptoService.decrypt(psychologist.getName()))
                .build();
    }
}
