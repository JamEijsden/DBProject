package exjobb.cache.mongo.entity.cusin;

/**
 * Created by Jimmie on 10/26/2017.
 */
public class CSubscriptionStripped {

    private String subscriptionid;
    private String msisdn;
    private String customeridentificationnumber;

    public CSubscriptionStripped(){
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
