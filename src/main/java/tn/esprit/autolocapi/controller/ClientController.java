package tn.esprit.autolocapi.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autolocapi.domain.Client;
import tn.esprit.autolocapi.service.IClientService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/clients")
public class ClientController {
    private final IClientService clientService;

    @PostMapping("/ajouterClient")
    public Client ajouterClient(@RequestBody Client client) {
        return clientService.ajouterClient(client);
    }

    @PutMapping("/modifierClient")
    public Client modifierClient(@RequestBody Client client) {
        return clientService.modifierClient(client);
    }

    @GetMapping("/getAllClients")
    public List<Client> getAllClient() {
        return clientService.getAllClient();
    }

    @GetMapping("/recupererClient/{id}")
    public Client getClientById(@PathVariable Long id) {
        return clientService.getClientById(id);
    }

    @DeleteMapping("/deleteClientById/{id}")
    public void supprimerClientById(@PathVariable Long id) {
        clientService.supprimerClientById(id);
    }
}