package sofistcao.sofistcao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

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

}
