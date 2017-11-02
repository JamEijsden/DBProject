package exjobb.cache.mongo.repository.customer;

import exjobb.cache.mongo.entity.cusin.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.util.Assert;

/**
 * Created by Jimmie on 9/20/2017.
 */
@RepositoryRestResource(collectionResourceRel = "customer", path = "customer")
public class CustomerRepositoryImpl implements CustomCustomerRepository {

    private final MongoOperations operations;

    @Autowired
    public CustomerRepositoryImpl(MongoOperations operations) {

        Assert.notNull(operations, "MongoOperations must not be null!");
        this.operations = operations;
    }

    @Override
    public Customer createCustomer(String name) {

        return null;
    }
}
