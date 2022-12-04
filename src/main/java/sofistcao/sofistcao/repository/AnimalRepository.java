package sofistcao.sofistcao.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import sofistcao.sofistcao.model.Animal;

@Repository
public class AnimalRepository {
    @Autowired
    JdbcTemplate jdbc;

    @Autowired
    ClienteRepository cliRepo;

    public void save(Animal animal) {
        String sql = "insert into animal(NOME_ANIMAL, ESPECIE, RACA, DATA_NASC, SEXO_ANIMAL, CLIENTE_ID_CLIENTE) values (?,?,?,?,?,?);";
        jdbc.update(sql, animal.getNome_animal(), animal.getEspecie(),
                animal.getRaca(), animal.getData_nasc(), animal.getSexo_animal(),
                animal.getTutor().getId_cliente());
    }

    public List<Animal> findAll() {
        return jdbc.query("select * from animal;",
                (registro, contador) -> {
                    Animal animal = new Animal();
                    animal.setId_animal(registro.getLong("ID_ANIMAL"));
                    animal.setNome_animal(registro.getString("NOME_ANIMAL"));
                    animal.setEspecie(registro.getString("ESPECIE"));
                    animal.setRaca(registro.getString("RACA"));
                    animal.setData_nasc(registro.getString("DATA_NASC"));
                    animal.setSexo_animal(registro.getString("SEXO_ANIMAL"));
                    animal.setTutor(cliRepo.findById(registro.getLong("CLIENTE_ID_CLIENTE")));
                    return animal;
                });
    }

}
