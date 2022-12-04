package sofistcao.sofistcao.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Animal {
    private Long id_animal;

    private String nome_animal, raca, data_nasc, sexo_animal, especie;

    private Cliente tutor;

}
