package br.puc.edson.telepsicologiapsicologoservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@AllArgsConstructor
@Data
public class Psychologist {

    @Id
    private String crp;
    private String email;
    private String name;

}
