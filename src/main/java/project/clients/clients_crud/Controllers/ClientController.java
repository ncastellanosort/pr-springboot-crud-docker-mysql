/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project.clients.clients_crud.Controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import project.clients.clients_crud.Models.ClientModel;
import project.clients.clients_crud.Services.ClientService;

/**
 *
 * @author Nicolas
 */
@RestController
@RequestMapping("/clients")
public class ClientController {

  @Autowired
  ClientService clientService;

  @GetMapping()
  public List<ClientModel> getClientsModel() {
    return clientService.getClientsService();
  }

  @PostMapping()
  public ClientModel postClient(@RequestBody ClientModel clientModel) {
    return this.clientService.createClientService(clientModel);
  }

  @GetMapping(path = "/{clientDocument}")
  public List<ClientModel> getClientByDocument(@PathVariable("clientDocument") Long document) {
    return this.clientService.getByDocument(document);
  }

  @GetMapping("/clientAmount")
  public List<ClientModel> getClientByAmount(@RequestParam("amount") Float amount) {
    return this.clientService.getByAmount(amount);
  }

  @DeleteMapping(path = "/{clientDocument}")
  public String deleteByClientDocument(@PathVariable("clientDocument") Long clientDocument) {
    boolean result = this.clientService.deleteCLient(clientDocument);
    if (result) {
      return "Deleted id " + clientDocument.toString();
    } else {
      return "Error delete " + clientDocument.toString();

    }
  }
}
