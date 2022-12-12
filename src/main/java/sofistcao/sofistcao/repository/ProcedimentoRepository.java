package sofistcao.sofistcao.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import sofistcao.sofistcao.model.Procedimento;

@Repository
public class ProcedimentoRepository {
    @Autowired
    JdbcTemplate jdbc;

    @Autowired
    VacinaRepository vacinaRepo;

    @Autowired
    AnimalRepository animalRepo;

    public void save(Procedimento procedimento) {
        
        System.out.println(procedimento.getAnimal().getId_animal());
        System.out.println(procedimento.getVacina().getId_vacina());
        String sql = "insert into vacinas_animal(DATA_VACINACAO, OBSERVACOES, VACINA_ID_VACINA, VACINA_ID_ANIMAL) values (?,?,?,?);";
        jdbc.update(sql, procedimento.getData_vacinacao(), procedimento.getObservacoes(),
                procedimento.getVacina().getId_vacina(), procedimento.getAnimal().getId_animal());
    }

    public List<Procedimento> findAll() {
        return jdbc.query("select * from vacinas_animal;",
                (registro, contador) -> {
                    Procedimento procedimento = new Procedimento();
                    procedimento.setData_vacinacao(registro.getString("DATA_VACINACAO"));
                    procedimento.setObservacoes(registro.getString("OBSERVACOES"));
                    procedimento.setVacina(vacinaRepo.findById(registro.getLong("VACINA_ID_VACINA")));
                    procedimento.setAnimal(animalRepo.findById(registro.getLong("VACINA_ID_ANIMAL")));
                    return procedimento;
                });
    }

}
