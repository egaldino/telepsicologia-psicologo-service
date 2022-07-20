package br.puc.edson.telepsicologiapsicologoservice.api;


import br.puc.edson.telepsicologiapsicologoservice.dto.PsychologistDto;
import br.puc.edson.telepsicologiapsicologoservice.service.PsychologistService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/psychologist")
@AllArgsConstructor
public class PsychologistController {

    private final PsychologistService service;

    @GetMapping("/")
    List<PsychologistDto> listAll() {
        return service.listAll();
    }

}
