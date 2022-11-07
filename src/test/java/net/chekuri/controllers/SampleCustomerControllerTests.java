package net.chekuri.controllers;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import net.chekuri.models.entities.Customer;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SampleCustomerControllerTests {
  private static final Logger logger = LoggerFactory.getLogger(SampleCustomerControllerTests.class);

  @Autowired private SampleCustomerController controller;

  @Test
  void testGetByLastName() {
    List<Customer> resultset = controller.getByLastName("Spider");
    logger.info("resultset size : " + resultset.size());
    for (Customer record : resultset) {
      logger.info(record.toString());
    }
    assertNotEquals(resultset.size(), 0);
  }

  Customer customer = new Customer("Crazy", "Gecko");

  @Test
  void testPut() {
    Customer expected = customer;
    Customer actual = controller.add(expected);
    logger.info("expected : " + expected.toString());
    logger.info("actual   : " + actual.toString());
    assertEquals(actual.getFirstName(), expected.getFirstName());
    assertEquals(actual.getLastName(), expected.getLastName());

    assertThrows(
        RuntimeException.class,
        () -> {
          logger.info("should throw exception when trying to insert same customer.");
          controller.add(expected);
        });
  }

  @Test
  void testGetById() {
    long id = 1;
    Customer actual = controller.getById(id);
    logger.info("actual   : " + actual.toString());
    assertEquals(actual.getId(), id);
  }
}
