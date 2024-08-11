/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package project.clients.clients_crud.Repositories;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import project.clients.clients_crud.Models.ClientModel;

/**
 *
 * @author Nicolas
 */
@Repository
public interface ClientRepository extends CrudRepository<ClientModel, Long>{
  public abstract List<ClientModel> findByClientDocument(Long clientDocument);
  public abstract List<ClientModel> findByAmount(Float amount);
}
