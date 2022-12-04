package sofistcao.sofistcao.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import sofistcao.sofistcao.controller.Procedimento;

@Repository
public class ProcedimentoRepository {
    @Autowired
    JdbcTemplate jdbc;
    
}
