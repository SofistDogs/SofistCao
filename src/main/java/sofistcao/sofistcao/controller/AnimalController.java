package sofistcao.sofistcao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AnimalController {
    @GetMapping("/cadastroAnimal")
    public String cadastroAnimal() {
        return "cadastroAnimal";
    }

    @GetMapping("/consultaAnimal")
    public String consultaAnimal() {
        return "consultaAnimal";
    }

}
