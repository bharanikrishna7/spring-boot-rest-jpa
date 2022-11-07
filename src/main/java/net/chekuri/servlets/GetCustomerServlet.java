package net.chekuri.servlets;

import java.util.List;
import net.chekuri.models.entities.Customer;
import net.chekuri.models.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class GetCustomerServlet {
  @Autowired private CustomerRepository repository;

  // do something complex here
  // bring in multiple repositories
  //
  // customers is fairly simple
  // so there's nothing much to show here
  // but I hope you feel me.

  public Customer getById(long id) {
    return repository.findById(id);
  }

  public List<Customer> getByLastName(String lastName) {
    return repository.findByLastName(lastName);
  }
}
