package sofistcao.sofistcao.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Procedimento {
    private Long id_procedimento;
    private String data_vacinacao, observacoes;
    private Animal animal;
    private Vacina vacina;
}
