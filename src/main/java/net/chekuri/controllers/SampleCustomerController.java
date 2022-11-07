package net.chekuri.controllers;

import java.util.List;
import net.chekuri.AppEntryPoint;
import net.chekuri.models.entities.Customer;
import net.chekuri.servlets.GetCustomerServlet;
import net.chekuri.servlets.PutCustomerServlet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class SampleCustomerController {
  private static final Logger logger = LoggerFactory.getLogger(AppEntryPoint.class);

  @Autowired private GetCustomerServlet getServlet;

  @Autowired private PutCustomerServlet putServlet;

  @RequestMapping(value = "/sample/customers/{id}", method = RequestMethod.GET, produces = "application/json")
  public Customer getById(@PathVariable(name = "id", required = true) long id) {
    logger.info("searching for customer with id : " + id + " in sample repository.");
    return getServlet.getById(id);
  }

  @RequestMapping(value = "/sample/customers", method = RequestMethod.GET, produces = "application/json")
  public List<Customer> getByLastName(@RequestParam String lastName) {
    logger.info("searching for customer with last name : " + lastName + " in sample repository.");
    return getServlet.getByLastName(lastName);
  }

  @RequestMapping(value = "/sample/customers/", method = RequestMethod.POST, produces = "application/json")
  public Customer add(@RequestBody Customer payload) {
    logger.info(
        "adding customer with first name : " + payload.getFirstName() + " and last name :" + payload.getLastName());
    return putServlet.put(payload);
  }
}
