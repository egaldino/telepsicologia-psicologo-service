package br.puc.edson.telepsicologiapsicologoservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@AllArgsConstructor
@Data
@Builder
public class Psychologist {

    @Id
    private String crp;
    private String crpHash;
    private String email;
    private String name;

}
