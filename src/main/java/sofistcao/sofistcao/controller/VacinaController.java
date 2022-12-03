package sofistcao.sofistcao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class VacinaController {
    @GetMapping("/cadastroVacina")
    public String cadastroVacina() {
        return "cadastroVacina";
    }

    @GetMapping("/consultaVacinas")
    public String consultaVacina() {
        return "consultaVacinas";
    }

}
