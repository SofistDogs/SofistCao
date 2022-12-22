package sofistcao.sofistcao.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
    public String mostrarCadastroProcedimento(@RequestParam(value = "id", required = false) Long cod, Model model) {
        model.addAttribute("animal", repository2.findById(cod));
        model.addAttribute("vacina", repository3.findAll());
        model.addAttribute("procedimento", new Procedimento());
        return "vacinarAnimal";
    }

    @PostMapping("/vacinarAnimal")
    public String gravarNovoProcedimento(Procedimento procedimento) {
        repository.save(procedimento);
        return "redirect:/vacinacaoAnimal";
    }

    @GetMapping("/vacinacaoAnimal")
    public String MostrarRelatorioProcedimento(Model model) {
        List<Procedimento> lista = repository.findAll();
        model.addAttribute("procedimentos", lista);
        return "vacinacaoAnimal";
    }

    @GetMapping("/vacinacaoPorAnimal")
    public String mostrarVacinasPorAnimal(@RequestParam(value = "id", required = false) Long cod, Model model) {
        List<Procedimento> listaPorAnimal = repository.findAllByID(cod);
        model.addAttribute("procedimentos", listaPorAnimal);
        model.addAttribute("animal", repository2.findById(cod));
        return "vacinacaoPorAnimal";
    }

}
