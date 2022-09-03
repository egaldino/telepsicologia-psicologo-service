package br.puc.edson.telepsicologiapsicologoservice.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TokenValidationRequestDto {

    private String token;
}
