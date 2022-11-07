package net.chekuri.repositories;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import net.chekuri.models.entities.Customer;
import net.chekuri.models.repositories.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class CustomerRepositoryTests {
  private static final Logger logger = LoggerFactory.getLogger(CustomerRepositoryTests.class);

  @Autowired private CustomerRepository customers;

  @Test
  public void testFindByLastName() {
    Customer customer = new Customer("first", "last");
    customers.save(customer);

    List<Customer> resultSet = customers.findByLastName(customer.getLastName());

    for (Customer record : resultSet) {
      logger.info(record.toString());
      assertEquals(record.getLastName(), customer.getLastName());
    }
  }
}
