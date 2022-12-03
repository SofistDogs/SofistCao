package sofistcao.sofistcao.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;

@Controller
public class Procedimento {
    @GetMapping("/vacinarAnimal")
    public String vacinarAnimal() {
        return "vacinarAnimal";
    }

    @GetMapping("/vacinacaoAnimal")
    public String vacinacaoAnimal() {
        return "vacinacaoAnimal";
    }
}
