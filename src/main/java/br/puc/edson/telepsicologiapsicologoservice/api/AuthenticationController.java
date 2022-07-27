package br.puc.edson.telepsicologiapsicologoservice.api;


import br.puc.edson.telepsicologiapsicologoservice.dto.LoginDto;
import br.puc.edson.telepsicologiapsicologoservice.dto.LoginResponseDto;
import br.puc.edson.telepsicologiapsicologoservice.dto.PsychologistDto;
import br.puc.edson.telepsicologiapsicologoservice.service.PsychologistService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
@AllArgsConstructor
public class AuthenticationController {

    private final PsychologistService service;


    @PostMapping("/login")
    ResponseEntity<LoginResponseDto> login(LoginDto form){
        return service.findByEmail(form.getEmail())
                .map(psychologist -> LoginResponseDto.builder().userId(psychologist.getCrp()).build())
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(HttpStatus.UNAUTHORIZED).build());
    }


}
