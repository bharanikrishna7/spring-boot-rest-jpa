package net.chekuri.models.repositories;

import java.util.List;
import net.chekuri.models.entities.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
  List<Customer> findByLastName(String lastName);

  Customer findById(long id);
}
