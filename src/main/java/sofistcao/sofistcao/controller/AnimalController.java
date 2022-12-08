package sofistcao.sofistcao.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import sofistcao.sofistcao.model.Animal;
import sofistcao.sofistcao.model.Procedimento;
import sofistcao.sofistcao.repository.AnimalRepository;
import sofistcao.sofistcao.repository.ClienteRepository;

@Controller
public class AnimalController {

    @Autowired
    AnimalRepository repository;

    @Autowired
    ClienteRepository repository2;

    @GetMapping("/cadastroAnimal")
    public String mostraCadastroAnimal(Model model) {
        model.addAttribute("animal", new Animal());
        model.addAttribute("cliente", repository2.findAll());
        return "cadastroAnimal";
    }

    @PostMapping("/cadastroAnimal")
    public String gravaNovoAnimal(Animal animal) {
        repository.save(animal);
        return "redirect:/home";
    }

    @GetMapping("/consultaAnimal")
    public String consultaAnimal(Model model) {
        List<Animal> lista = repository.findAll();
        model.addAttribute("animais", lista);
        return "consultaAnimal";
    }

    @GetMapping("editarAnimal")
    public String mostraFormEditaAniaml(@RequestParam(value = "id", required = false) Long cod, Model model) {
        System.out.println(cod);
        Animal animal = repository.findById(cod);
        model.addAttribute("anima", animal);
        model.addAttribute("cliente", repository2.findAll());
        return "editaAnimal";
    }

    @PostMapping("gravaanimalmodificado")
    public String gravaAnimalModificado(Animal animal) {
        repository.saveModification(animal);
        return "redirect:/home";
    }

}
