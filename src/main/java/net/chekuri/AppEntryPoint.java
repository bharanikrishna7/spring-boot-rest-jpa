package net.chekuri;

import java.util.List;
import net.chekuri.models.entities.Customer;
import net.chekuri.models.repositories.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AppEntryPoint {
  private static final Logger logger = LoggerFactory.getLogger(AppEntryPoint.class);

  public static void main(String[] args) {
    SpringApplication.run(AppEntryPoint.class, args);
  }

  // TODO: Remove this after setting appropriate data entities and repositories.
  //  this is just for demo purposes. It can also be used for pre-loading data.
  @Bean
  public CommandLineRunner demo(CustomerRepository repository) {
    return (args) -> {
      // save a few customers
      repository.save(new Customer("Papa", "Spider"));
      repository.save(new Customer("Momma", "Spider"));
      repository.save(new Customer("Junior", "Spider"));
      repository.save(new Customer("Sister", "Spider"));
      repository.save(new Customer("Baby", "Spider"));
      repository.save(new Customer("Oblivious", "Moth"));

      // fetch all customers
      logger.info("Customers found with findAll():");
      logger.info("-------------------------------");
      for (Customer customer : repository.findAll()) {
        logger.info(customer.toString());
      }
      logger.info("");

      // fetch an individual customer by ID
      Customer customer = repository.findById(1L);
      logger.info("Customer found with findById(1L):");
      logger.info("--------------------------------");
      logger.info(customer.toString());
      logger.info("");

      // fetch customers by last name
      logger.info("Customer found with findByLastName('Bauer'):");
      logger.info("--------------------------------------------");
      List<Customer> customers = repository.findByLastName("Spider");
      for (Customer spider : customers) {
        logger.info(spider.toString());
      }
      logger.info("");
    };
  }
}
