package net.chekuri.router;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import net.chekuri.models.entities.Customer;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SampleCustomerControllerRouterTests {
  private static final Logger logger = LoggerFactory.getLogger(SampleCustomerControllerRouterTests.class);

  @LocalServerPort private int port;

  @Autowired private TestRestTemplate restTemplate;

  private String baseUrl() {
    return "http://localhost:" + port + '/';
  }

  @Test
  void getByIdRoute() {
    long customerId = 1;
    String url = baseUrl() + "/sample/customers/" + customerId;
    Customer response = this.restTemplate.getForObject(url, Customer.class);
    logger.info("retrieved customer:");
    logger.info(response.toString());
    assertEquals(response.getId(), customerId);
  }

  @Test
  void getByLastNameRoute() {
    String lastName = "Spider";
    String url = baseUrl() + "/sample/customers?lastName=" + lastName;
    ArrayList response = this.restTemplate.getForObject(url, new ArrayList<Customer>().getClass());
    logger.info("retrieved customer size : " + response.size());
    response.forEach(
        (f) -> {
          logger.info(f.toString());
        });
    assertNotEquals(response.size(), 0);
  }

  @Test
  void putRoute() {
    String firstName = "Scary";
    String lastName = "Scorpion";
    String url = baseUrl() + "/sample/customers/";
    HttpEntity<Customer> body = new HttpEntity<>(new Customer(firstName, lastName));
    ResponseEntity<Customer> response = restTemplate.exchange(url, HttpMethod.POST, body, Customer.class);
    logger.info("http response code : " + response.getStatusCode().value());
    assertTrue(response.getStatusCode().is2xxSuccessful());
    logger.info("retrieved customer:");
    logger.info(response.getBody().toString());
    assertEquals(firstName, response.getBody().getFirstName());
    assertEquals(lastName, response.getBody().getLastName());
  }
}
