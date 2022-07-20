package br.puc.edson.telepsicologiapsicologoservice.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class RequestDto {

    private String id;
    private String name;
    private String date;
    private String hour;

}
