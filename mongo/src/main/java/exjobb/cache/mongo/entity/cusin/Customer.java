package exjobb.cache.mongo.entity.cusin;

import exjobb.cache.mongo.entity.cusin.address.CustomerAddress;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;

/**
 * Created by Jimmie on 9/20/2017.
 */
@Document(collection = "customer")
public class Customer {
    @Id
    private String id;

    private String customernumber;

    private String clientsystem;
    private String customertype;
    private String customeridentificationnumber;
    private String grantedpullevel;
    private String eventnumber;
    private ArrayList<CustomerAddress> address = new ArrayList();

    public Customer(){
        super();
    }

    public String getId() {
        return id;
    }

    public String getCustomernumber() {
        return customernumber;
    }

    public void setCustomernumber(String customernumber) {
        this.customernumber = customernumber;
    }

    public String getClientsystem() {
        return clientsystem;
    }

    public void setClientsystem(String clientsystem) {
        this.clientsystem = clientsystem;
    }

    public String getCustomertype() {
        return customertype;
    }

    public void setCustomertype(String customertype) {
        this.customertype = customertype;
    }

    public String getCustomeridentificationnumber() {
        return customeridentificationnumber;
    }

    public void setCustomeridentificationnumber(String customeridentificationnumber) {
        this.customeridentificationnumber = customeridentificationnumber;
    }

    public String getGrantedpullevel() {
        return grantedpullevel;
    }

    public void setGrantedpullevel(String grantedpullevel) {
        this.grantedpullevel = grantedpullevel;
    }

    public String getEventnumber() {
        return eventnumber;
    }

    public void setEventnumber(String eventnumber) {
        this.eventnumber = eventnumber;
    }

    public ArrayList<CustomerAddress> getAddress() {
        return address;
    }

    public void setAddress(ArrayList<CustomerAddress> address) {
        this.address = address;
    }
}
