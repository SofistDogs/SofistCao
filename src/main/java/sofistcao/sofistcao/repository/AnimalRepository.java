package sofistcao.sofistcao.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class AnimalRepository {
    @Autowired
    JdbcTemplate jdbc;

    /*
     * public List<Animal> findAll() {
     * return jdbc.query("SELECT * FROM animal", this::mapper);
     * }
     */
}
