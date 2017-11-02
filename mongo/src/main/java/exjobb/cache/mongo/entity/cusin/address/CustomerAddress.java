package exjobb.cache.mongo.entity.cusin.address;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by Jimmie on 10/6/2017.
 */

@Document
public class CustomerAddress extends Address {
    private String customername;
    private String customeraddress;


    public CustomerAddress(String customername, String customeraddress) {
        super();
        this.customername = customername;
        this.customeraddress = customeraddress;
    }

    public String getCustomername() {
        return customername;
    }

    public void setCustomername(String customername) {
        this.customername = customername;
    }

    public String getCustomeraddress() {
        return customeraddress;
    }

    public void setCustomeraddress(String customeraddress) {
        this.customeraddress = customeraddress;
    }
}
