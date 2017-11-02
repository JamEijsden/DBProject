package exjobb.cache.mongo.entity.xtas;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by Jimmie on 10/16/2017.
 */
@Document(collection = "xtas_subscription")
public class Subscription {

    @Id
    private String id;

    private String agreementid;
    private String agreementnumber;
    private String agreement;
    private String contractingparty;
    private String typeofmainfunction;
    private String mainfunctioncode;
    private String mainfunctionname;
    private String companyorganisationnumber;
    private String companyname;
    private String customername;
    private String costlocationname;
    private String employeename;
    private String subscriptionid;
    private String directsubscription;
    private String constructionnumber;
    private String mobilenumber;
    private String imei;
    private String subscriptionname;
    private String subscriptionnumber;
    private String fromsystem;
    private String extractdate;
    private String filename;
    private String dtime;
    private String ctime;
    private String mtime;
    private String subscriptionstatus;
    private String billingaccountnumber;
    private String subscriptionzipcode;
    private String subscriptioncity;
    private String subscriptioncountry;
    private String subscriptionaddress;
    private String subscribername;
    private String customertype;
    private String startdate;
    private String categoryid;
    private String categoryname;
    private String c2bcacheuid;
    private String implementedproductcode;
    private String implementedproductname;
    private String slaid;
    private String priority;
    private String subscriptioncoaddress;
    private String slcode1;
    private String slcode2;
    private String slcode3;
    private String slcode4;
    private String subscriptionpointid;
    private String carrierid;
    private String subscriptionidtag;
    private String subscriptionid2;
    private String typeofservicedesk;
    private String custheader_subinfo1;
    private String custheader_subinfo2;
    private String custheader_subinfo3;
    private String custheader_subinfo4;
    private String subscriptioninfo1;
    private String subscriptioninfo2;
    private String subscriptioninfo3;
    private String subscriptioninfo4;

    public Subscription(){
        super();
    }

    public String getId() {
        return id;
    }

    public String getAgreementid() {
        return agreementid;
    }

    public void setAgreementid(String agreementid) {
        this.agreementid = agreementid;
    }

    public String getAgreementnumber() {
        return agreementnumber;
    }

    public void setAgreementnumber(String agreementnumber) {
        this.agreementnumber = agreementnumber;
    }

    public String getAgreement() {
        return agreement;
    }

    public void setAgreement(String agreement) {
        this.agreement = agreement;
    }

    public String getContractingparty() {
        return contractingparty;
    }

    public void setContractingparty(String contractingparty) {
        this.contractingparty = contractingparty;
    }

    public String getTypeofmainfunction() {
        return typeofmainfunction;
    }

    public void setTypeofmainfunction(String typeofmainfunction) {
        this.typeofmainfunction = typeofmainfunction;
    }

    public String getMainfunctioncode() {
        return mainfunctioncode;
    }

    public void setMainfunctioncode(String mainfunctioncode) {
        this.mainfunctioncode = mainfunctioncode;
    }

    public String getMainfunctionname() {
        return mainfunctionname;
    }

    public void setMainfunctionname(String mainfunctionname) {
        this.mainfunctionname = mainfunctionname;
    }

    public String getCompanyorganisationnumber() {
        return companyorganisationnumber;
    }

    public void setCompanyorganisationnumber(String companyorganisationnumber) {
        this.companyorganisationnumber = companyorganisationnumber;
    }

    public String getCompanyname() {
        return companyname;
    }

    public void setCompanyname(String companyname) {
        this.companyname = companyname;
    }

    public String getCustomername() {
        return customername;
    }

    public void setCustomername(String customername) {
        this.customername = customername;
    }

    public String getCostlocationname() {
        return costlocationname;
    }

    public void setCostlocationname(String costlocationname) {
        this.costlocationname = costlocationname;
    }

    public String getEmployeename() {
        return employeename;
    }

    public void setEmployeename(String employeename) {
        this.employeename = employeename;
    }

    public String getSubscriptionid() {
        return subscriptionid;
    }

    public void setSubscriptionid(String subscriptionid) {
        this.subscriptionid = subscriptionid;
    }

    public String getDirectsubscription() {
        return directsubscription;
    }

    public void setDirectsubscription(String directsubscription) {
        this.directsubscription = directsubscription;
    }

    public String getConstructionnumber() {
        return constructionnumber;
    }

    public void setConstructionnumber(String constructionnumber) {
        this.constructionnumber = constructionnumber;
    }

    public String getMobilenumber() {
        return mobilenumber;
    }

    public void setMobilenumber(String mobilenumber) {
        this.mobilenumber = mobilenumber;
    }

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    public String getSubscriptionname() {
        return subscriptionname;
    }

    public void setSubscriptionname(String subscriptionname) {
        this.subscriptionname = subscriptionname;
    }

    public String getSubscriptionnumber() {
        return subscriptionnumber;
    }

    public void setSubscriptionnumber(String subscriptionnumber) {
        this.subscriptionnumber = subscriptionnumber;
    }

    public String getFromsystem() {
        return fromsystem;
    }

    public void setFromsystem(String fromsystem) {
        this.fromsystem = fromsystem;
    }

    public String getExtractdate() {
        return extractdate;
    }

    public void setExtractdate(String extractdate) {
        this.extractdate = extractdate;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getDtime() {
        return dtime;
    }

    public void setDtime(String dtime) {
        this.dtime = dtime;
    }

    public String getCtime() {
        return ctime;
    }

    public void setCtime(String ctime) {
        this.ctime = ctime;
    }

    public String getMtime() {
        return mtime;
    }

    public void setMtime(String mtime) {
        this.mtime = mtime;
    }

    public String getSubscriptionstatus() {
        return subscriptionstatus;
    }

    public void setSubscriptionstatus(String subscriptionstatus) {
        this.subscriptionstatus = subscriptionstatus;
    }

    public String getBillingaccountnumber() {
        return billingaccountnumber;
    }

    public void setBillingaccountnumber(String billingaccountnumber) {
        this.billingaccountnumber = billingaccountnumber;
    }

    public String getSubscriptionzipcode() {
        return subscriptionzipcode;
    }

    public void setSubscriptionzipcode(String subscriptionzipcode) {
        this.subscriptionzipcode = subscriptionzipcode;
    }

    public String getSubscriptioncity() {
        return subscriptioncity;
    }

    public void setSubscriptioncity(String subscriptioncity) {
        this.subscriptioncity = subscriptioncity;
    }

    public String getSubscriptioncountry() {
        return subscriptioncountry;
    }

    public void setSubscriptioncountry(String subscriptioncountry) {
        this.subscriptioncountry = subscriptioncountry;
    }

    public String getSubscriptionaddress() {
        return subscriptionaddress;
    }

    public void setSubscriptionaddress(String subscriptionaddress) {
        this.subscriptionaddress = subscriptionaddress;
    }

    public String getSubscribername() {
        return subscribername;
    }

    public void setSubscribername(String subscribername) {
        this.subscribername = subscribername;
    }

    public String getCustomertype() {
        return customertype;
    }

    public void setCustomertype(String customertype) {
        this.customertype = customertype;
    }

    public String getStartdate() {
        return startdate;
    }

    public void setStartdate(String startdate) {
        this.startdate = startdate;
    }

    public String getCategoryid() {
        return categoryid;
    }

    public void setCategoryid(String categoryid) {
        this.categoryid = categoryid;
    }

    public String getCategoryname() {
        return categoryname;
    }

    public void setCategoryname(String categoryname) {
        this.categoryname = categoryname;
    }

    public String getC2bcacheuid() {
        return c2bcacheuid;
    }

    public void setC2bcacheuid(String c2bcacheuid) {
        this.c2bcacheuid = c2bcacheuid;
    }

    public String getImplementedproductcode() {
        return implementedproductcode;
    }

    public void setImplementedproductcode(String implementedproductcode) {
        this.implementedproductcode = implementedproductcode;
    }

    public String getImplementedproductname() {
        return implementedproductname;
    }

    public void setImplementedproductname(String implementedproductname) {
        this.implementedproductname = implementedproductname;
    }

    public String getSlaid() {
        return slaid;
    }

    public void setSlaid(String slaid) {
        this.slaid = slaid;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getSubscriptioncoaddress() {
        return subscriptioncoaddress;
    }

    public void setSubscriptioncoaddress(String subscriptioncoaddress) {
        this.subscriptioncoaddress = subscriptioncoaddress;
    }

    public String getSlcode1() {
        return slcode1;
    }

    public void setSlcode1(String slcode1) {
        this.slcode1 = slcode1;
    }

    public String getSlcode2() {
        return slcode2;
    }

    public void setSlcode2(String slcode2) {
        this.slcode2 = slcode2;
    }

    public String getSlcode3() {
        return slcode3;
    }

    public void setSlcode3(String slcode3) {
        this.slcode3 = slcode3;
    }

    public String getSlcode4() {
        return slcode4;
    }

    public void setSlcode4(String slcode4) {
        this.slcode4 = slcode4;
    }

    public String getSubscriptionpointid() {
        return subscriptionpointid;
    }

    public void setSubscriptionpointid(String subscriptionpointid) {
        this.subscriptionpointid = subscriptionpointid;
    }

    public String getCarrierid() {
        return carrierid;
    }

    public void setCarrierid(String carrierid) {
        this.carrierid = carrierid;
    }

    public String getSubscriptionidtag() {
        return subscriptionidtag;
    }

    public void setSubscriptionidtag(String subscriptionidtag) {
        this.subscriptionidtag = subscriptionidtag;
    }

    public String getSubscriptionid2() {
        return subscriptionid2;
    }

    public void setSubscriptionid2(String subscriptionid2) {
        this.subscriptionid2 = subscriptionid2;
    }

    public String getTypeofservicedesk() {
        return typeofservicedesk;
    }

    public void setTypeofservicedesk(String typeofservicedesk) {
        this.typeofservicedesk = typeofservicedesk;
    }

    public String getCustheader_subinfo1() {
        return custheader_subinfo1;
    }

    public void setCustheader_subinfo1(String custheader_subinfo1) {
        this.custheader_subinfo1 = custheader_subinfo1;
    }

    public String getCustheader_subinfo2() {
        return custheader_subinfo2;
    }

    public void setCustheader_subinfo2(String custheader_subinfo2) {
        this.custheader_subinfo2 = custheader_subinfo2;
    }

    public String getCustheader_subinfo3() {
        return custheader_subinfo3;
    }

    public void setCustheader_subinfo3(String custheader_subinfo3) {
        this.custheader_subinfo3 = custheader_subinfo3;
    }

    public String getCustheader_subinfo4() {
        return custheader_subinfo4;
    }

    public void setCustheader_subinfo4(String custheader_subinfo4) {
        this.custheader_subinfo4 = custheader_subinfo4;
    }

    public String getSubscriptioninfo1() {
        return subscriptioninfo1;
    }

    public void setSubscriptioninfo1(String subscriptioninfo1) {
        this.subscriptioninfo1 = subscriptioninfo1;
    }

    public String getSubscriptioninfo2() {
        return subscriptioninfo2;
    }

    public void setSubscriptioninfo2(String subscriptioninfo2) {
        this.subscriptioninfo2 = subscriptioninfo2;
    }

    public String getSubscriptioninfo3() {
        return subscriptioninfo3;
    }

    public void setSubscriptioninfo3(String subscriptioninfo3) {
        this.subscriptioninfo3 = subscriptioninfo3;
    }

    public String getSubscriptioninfo4() {
        return subscriptioninfo4;
    }

    public void setSubscriptioninfo4(String subscriptioninfo4) {
        this.subscriptioninfo4 = subscriptioninfo4;
    }
}
