package sofistcao.sofistcao.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import sofistcao.sofistcao.model.Cliente;

@Repository
public class ClienteRepository {
    @Autowired
    JdbcTemplate jdbc;

    public void save(Cliente cliente) {
        String sql = "insert into cliente(NOME_CLIENTE, LOGIN, SENHA) values (?,?,?);";
        jdbc.update(sql, cliente.getNome_cliente(), cliente.getLogin(), cliente.getSenha());
    }

    public List<Cliente> findAll() {
        return jdbc.query("SELECT * FROM cliente", this::mapper);
    }

    public Cliente findById(Long id) {
        return jdbc.queryForObject("SELECT * from cliente where id_cliente=?", this::mapper, id);
    }

    private Cliente mapper(ResultSet registro, int contador) throws SQLException {
        return new Cliente(registro.getLong("ID_CLIENTE"), registro.getString("NOME_CLIENTE"),
                registro.getString("LOGIN"), registro.getString("SENHA"));
    }

}
