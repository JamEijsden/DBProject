package exjobb.cache.mongo.repository.customer;

import exjobb.cache.mongo.entity.cusin.Customer;

/**
 * Created by Jimmie on 9/20/2017.
 */
public interface CustomCustomerRepository {
    Customer createCustomer(String name);
}
