package sofistcao.sofistcao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ClienteController {
    @GetMapping("/cadastroCliente")
    public String cadastroCliente() {
        return "cadastroCliente";
    }

    @GetMapping("/consultaClientes")
    public String consultaCliente() {
        return "consultaClientes";
    }

}
