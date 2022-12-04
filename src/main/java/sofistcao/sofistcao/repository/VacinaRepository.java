package sofistcao.sofistcao.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import sofistcao.sofistcao.model.Vacina;

@Repository
public class VacinaRepository {
    @Autowired
    JdbcTemplate jdbc;

    public void save(Vacina vacina) {
        String sql = "insert into vacina(NOME_VACINA, PERIODICIDADE, TIPO_VACINA, DESC_VACINA) values (?,?,?,?);";
        jdbc.update(sql, vacina.getNome_vacina(), vacina.getPeriodicidade(), vacina.getTipo_vacina(), vacina.getDesc_vacina());
    }

    public List<Vacina> findAll() {
        return jdbc.query("SELECT * FROM vacina", this::mapper);
    }

    public Vacina findById(Long id) {
        return jdbc.queryForObject("SELECT * from vacina where id_vacina=?", this::mapper, id);
    }

    private Vacina mapper(ResultSet registro, int contador) throws SQLException {
        return new Vacina(registro.getLong("ID_VACINA"), registro.getDouble("PERIODICIDADE"),
                registro.getString("NOME_VACINA"), registro.getString("TIPO_VACINA"), registro.getString("DESC_VACINA"));
    }

}
