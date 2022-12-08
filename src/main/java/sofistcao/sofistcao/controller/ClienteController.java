package sofistcao.sofistcao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import sofistcao.sofistcao.model.Cliente;
import sofistcao.sofistcao.repository.ClienteRepository;

@Controller
public class ClienteController {

    @Autowired
    ClienteRepository repository;

    @GetMapping("/cadastroCliente")
    public String exibeFormCadastroCliente(Model model) {
        model.addAttribute("cliente", new Cliente());
        return "cadastroCliente";
    }

    @PostMapping("/cadastroCliente")
    public String gravaNovoCliente(Cliente cliente) {
        repository.save(cliente);
        return "redirect:/home";
    }

    @GetMapping("/consultaClientes")
    public String consultaCliente(Model model) {
        model.addAttribute("clientes", repository.findAll());
        return "consultaClientes";
    }

    @GetMapping("editaCliente")
    public String mostraFormEditaCliente(@RequestParam(value = "id", required = false) Long cod, Model model) {
        System.out.println(cod);
        Cliente cliente = repository.findById(cod);
        model.addAttribute("cliente", cliente);
        return "editaCliente";
    }

    @PostMapping("gravaclientemodificado")
    public String gravaClienteModificado(Cliente cliente) {
        repository.saveModification(cliente);
        return "redirect:/home";
    }

}
