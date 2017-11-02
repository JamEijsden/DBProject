package exjobb.cache.mongo.repository.customer;

import exjobb.cache.mongo.entity.cusin.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by Jimmie on 9/20/2017.
 */
public interface CustomerRepository extends MongoRepository<Customer, String>, CustomCustomerRepository {

    List<Customer> findByCustomernumber(@Param("number") String number);

    List<Customer> findByCustomeridentificationnumber(@Param("number") String number);

    @Override
    Customer createCustomer(@Param("name") String name);

    List<Customer> findAll();
}

