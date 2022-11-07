package net.chekuri.servlets;

import net.chekuri.models.entities.Customer;
import net.chekuri.models.repositories.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PutCustomerServlet {
  private static final Logger logger = LoggerFactory.getLogger(PutCustomerServlet.class);
  @Autowired private CustomerRepository repository;

  // do something complex here
  // bring in multiple repositories
  //
  // customers is fairly simple
  // so there's nothing much to show here
  // but I hope you feel me.

  public Customer put(Customer value) {
    boolean isPresent = false;
    for (Customer customer : repository.findAll()) {
      if (customer.getLastName().contentEquals(value.getLastName())
          && customer.getFirstName().contentEquals(value.getFirstName())) {
        isPresent = true;
        break;
      }
    }
    if (isPresent) {
      logger.error(
          "customer [" + value.getFirstName() + ", " + value.getLastName() + "] already exists in the database");
      throw new RuntimeException("Duplicate entry exception. Customer with existing [fname, lname] already exists.");
    }
    return repository.save(value);
  }
}
