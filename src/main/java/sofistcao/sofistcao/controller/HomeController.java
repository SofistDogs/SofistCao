package sofistcao.sofistcao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/home")
    public String home() {
        return "home";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/cadastroCliente")
    public String cadastroCliente() {
        return "cadastroCliente";
    }

    @GetMapping("/cadastroAnimal")
    public String cadastroAnimal() {
        return "cadastroAnimal";
    }

    @GetMapping("/cadastroVacina")
    public String cadastroVacina() {
        return "cadastroVacina";
    }

    @GetMapping("/consultaAnimal")
    public String consultaAnimal() {
        return "consultaAnimal";
    }

    @GetMapping("/consultaVacinas")
    public String consultaVacina() {
        return "consultaVacinas";
    }

    @GetMapping("/consultaClientes")
    public String consultaCliente() {
        return "consultaClientes";
    }

    @GetMapping("/vacinacaoAnimal")
    public String vacinacaoAnimal() {
        return "vacinacaoAnimal";
    }

}
