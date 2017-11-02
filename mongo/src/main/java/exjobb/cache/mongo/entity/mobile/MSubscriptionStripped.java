package exjobb.cache.mongo.entity.mobile;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by Jimmie on 10/26/2017.
 */
@Document(collection = "mobile_subscription")
public class MSubscriptionStripped {

    private String subscriptionid;
    private String msisdn;
    private String customeridentificationnumber;

    public MSubscriptionStripped(){
        super();
    }

    public String getSubscriptionid() {
        return subscriptionid;
    }

    public void setSubscriptionid(String subscriptionid) {
        this.subscriptionid = subscriptionid;
    }

    public String getMsisdn() {
        return msisdn;
    }

    public void setMsisdn(String msisdn) {
        this.msisdn = msisdn;
    }

    public String getCustomeridentificationnumber() {
        return customeridentificationnumber;
    }

    public void setCustomeridentificationnumber(String customeridentificationnumber) {
        this.customeridentificationnumber = customeridentificationnumber;
    }
}
