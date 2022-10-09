package br.puc.edson.telepsicologiapsicologoservice.api;


import br.puc.edson.telepsicologiapsicologoservice.dto.PsychologistDto;
import br.puc.edson.telepsicologiapsicologoservice.mapper.PsychologistMapper;
import br.puc.edson.telepsicologiapsicologoservice.service.PsychologistService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/psychologist")
@AllArgsConstructor
@CrossOrigin
public class PsychologistController {

    private final PsychologistService service;

    @GetMapping("/")
    List<PsychologistDto> listAll() {
        return service.listAll()
                .stream()
                .map(PsychologistMapper.INSTANCE::modelToDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{crp}")
    public ResponseEntity<PsychologistDto> findByCrp(@PathVariable String crp) {
        return service.findByCrp(crp)
                .map(PsychologistMapper.INSTANCE::modelToDto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
