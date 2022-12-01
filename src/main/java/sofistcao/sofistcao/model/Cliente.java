package sofistcao.sofistcao.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data

@NoArgsConstructor
@AllArgsConstructor
public class Cliente {

    private Long id_cliente;

    private String nome_cliente, login, senha;
}
