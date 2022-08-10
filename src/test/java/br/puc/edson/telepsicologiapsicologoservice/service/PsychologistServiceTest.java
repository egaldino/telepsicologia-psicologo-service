package br.puc.edson.telepsicologiapsicologoservice.service;

import br.puc.edson.telepsicologiapsicologoservice.model.Psychologist;
import br.puc.edson.telepsicologiapsicologoservice.repository.PsychologistRepository;
import org.jeasy.random.EasyRandom;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
class PsychologistServiceTest {

    @Mock
    private PsychologistRepository repository;

    @Mock
    private DataCryptoService dataCryptoService;

    @InjectMocks
    private PsychologistService service;

    @Test
    public void shouldListAllPsychologists(){
        EasyRandom generator = new EasyRandom();
        List<Psychologist> databaseReturn = generator.objects(Psychologist.class, 5)
                .collect(Collectors.toList());
        when(repository.findAll()).thenReturn(databaseReturn);

        when(dataCryptoService.decrypt(anyString())).thenAnswer(answer -> answer.getArguments()[0]);

        List<Psychologist> result = service.listAll();

        assertEquals(databaseReturn.size(), result.size());
        for(int i=0; i < result.size(); i++){
            assertEquals(databaseReturn.get(i).getCrp(),result.get(i).getCrp());
            assertEquals(databaseReturn.get(i).getName(),result.get(i).getName());
        }

    }

}