package sofistcao.sofistcao.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data

@NoArgsConstructor
@AllArgsConstructor

public class Vacina {

    private Long id_vacina;

    private Double periodicidade;

    private String tipo_vacina, desc_vacina;
}
