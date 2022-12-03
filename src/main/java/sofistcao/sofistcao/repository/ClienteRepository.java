package sofistcao.sofistcao.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ClienteRepository {
    @Autowired
    JdbcTemplate jdbc;

    /*
     * 
     * public List<Cliente> findAll() {
     * return jdbc.query("SELECT * FROM clientes", this::mapper);
     * }
     * 
     */

}
