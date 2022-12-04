package sofistcao.sofistcao.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import sofistcao.sofistcao.model.Procedimento;
import sofistcao.sofistcao.repository.AnimalRepository;
import sofistcao.sofistcao.repository.ProcedimentoRepository;
import sofistcao.sofistcao.repository.VacinaRepository;

@Controller
public class ProcedimentoController {

    @Autowired
    ProcedimentoRepository repository;

    @Autowired
    AnimalRepository repository2;

    @Autowired
    VacinaRepository repository3;

    @GetMapping("/vacinarAnimal")
    public String mostrarCadastroProcedimento(Model model) {
        model.addAttribute("procedimento", new Procedimento());
        model.addAttribute("animal", repository2.findAll());
        model.addAttribute("vacina", repository3.findAll());
        return "vacinarAnimal";
    }

    @PostMapping("/vacinarAnimal")
    public String gravarNovoProcedimento(Procedimento procedimento) {
        repository.save(procedimento);
        return "redirect:/home";
    }

    @GetMapping("/vacinacaoAnimal")
    public String MostrarRelatorioProcedimento(Model model) {
        List<Procedimento> lista = repository.findAll();
        model.addAttribute("procedimentos", lista);
        return "vacinacaoAnimal";
    }
}
