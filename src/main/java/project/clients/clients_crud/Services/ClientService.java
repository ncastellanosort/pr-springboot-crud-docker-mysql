/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project.clients.clients_crud.Services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.clients.clients_crud.Models.ClientModel;
import project.clients.clients_crud.Repositories.ClientRepository;

/**
 *
 * @author Nicolas
 */
@Service
public class ClientService {
  
  @Autowired
  ClientRepository clientRepository;
  
  public List<ClientModel> getClientsService() {
    return (List<ClientModel>) clientRepository.findAll();
  }
  
  public ClientModel createClientService(ClientModel client) {
    return clientRepository.save(client);
  }
  
  public List<ClientModel> getByDocument(Long document) {
    return clientRepository.findByClientDocument(document);
  }
  
  public List<ClientModel> getByAmount(Float amount) {
    return clientRepository.findByAmount(amount);
  }
  
  public boolean deleteCLient(Long id) {
    try {
      clientRepository.deleteById(id);
      return true;
    } catch (Exception e) {
      return false;
    }
  }
}
