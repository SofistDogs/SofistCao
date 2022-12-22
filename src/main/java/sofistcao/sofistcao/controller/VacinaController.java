package sofistcao.sofistcao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import sofistcao.sofistcao.model.Vacina;
import sofistcao.sofistcao.repository.VacinaRepository;

@Controller
public class VacinaController {

    @Autowired
    VacinaRepository repository;

    @GetMapping("/cadastroVacina")
    public String mostraCadastroVacina(Model model) {
        model.addAttribute("vacina", new Vacina());
        return "cadastroVacina";
    }

    @PostMapping("/cadastroVacina")
    public String gravaNovaVacina(Vacina vacina) {
        repository.save(vacina);
        return "redirect:/consultaVacinas";
    }

    @GetMapping("/consultaVacinas")
    public String consultaVacina(Model model) {
        model.addAttribute("vacinas", repository.findAll());
        return "consultaVacinas";
    }

    @GetMapping("editaVacina")
    public String mostraFormEditaVacina(@RequestParam(value = "id", required = false) Long cod, Model model) {
        System.out.println(cod);
        Vacina vacina = repository.findById(cod);
        model.addAttribute("vacina", vacina);
        return "editaVacina";
    }

    @PostMapping("gravavacinamodificado")
    public String gravaVacinaModificado(Vacina vacina) {
        repository.saveModification(vacina);
        return "redirect:/consultaVacinas";
    }

}
