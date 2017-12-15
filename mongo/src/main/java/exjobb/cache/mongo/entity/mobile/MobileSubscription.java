package exjobb.cache.mongo.entity.mobile;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

/**
 * Created by Jimmie on 9/20/2017.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Document(collection = "mobile_subscription")
public class MobileSubscription {
    @Id
    private String id;

    private String subscriptionnumber;
    private String subscriptiontype;
    //private String creationdate;
    private String subscriptionstatus;
    private String supervisionstatus;
    private String tscid;
    private String customertype;
    private String ownerid;
    private String agreementnumber;
    private String referencetextonbill;
    private String activationdate;
    private String paymentmethod;
    private String brandid;
    private String branddescription;
    private String customertargetsegment;
    private String multisubscriptionnumber;
    //private String multisubscriptionstatus;
    private String customeridentificationnumber;
  /*  private String cusAddressrow1;
    private String cusAddressrow2;
    private String cusAddressrow3;
    private String cusZipcode;
    private String cusCity;
    private String cusCountry;
    private String cusName1;
    private String cusName2;
    private String cusName3;*/
    private String accountnumber;
    /*private String bgAddressrow1;
    private String bgAddressrow2;
    private String bgAddressrow3;
    private String bgZipcode;
    private String bgCity;
    private String bgCountry;
    private String bgName1;
    private String bgName2;
    private String bgName3;*/
    private String offeringname;
    private String invoicedeliverymethod;
    private String invoicedeliverymethoddescr;
    private String billentityobjid;
    private String communityowner;
    private String billingaccountnumber;
    private String msisdn;
    private String c2bcacheuid;
    private String extracardsubscriptionid;
    private String multisubscriptiontype;
    private String multisubscriptiontypedescr;
    private List<String> servicecode;
    private List<String> servicevalue;
    private List<String> attributename;
    private List<String> attributevalue;
    private List<String> serviceinvoicetext;
    private List<String> serviceallowance;

    public MobileSubscription(){
        super();
    }

    public String getId() {
        return id;
    }

    public String getTscid() {
        return tscid;
    }

    public void setTscid(String tscid) {
        this.tscid = tscid;
    }

    public String getExtracardsubscriptionid() {
        return extracardsubscriptionid;
    }

    public void setExtracardsubscriptionid(String extracardsubscriptionid) {
        this.extracardsubscriptionid = extracardsubscriptionid;
    }

    public String getOwnerid() {
        return ownerid;
    }

    public void setOwnerid(String ownerid) {
        this.ownerid = ownerid;
    }

    public String getSubscriptionnumber() {
        return subscriptionnumber;
    }

    public void setSubscriptionnumber(String subscriptionnumber) {
        this.subscriptionnumber = subscriptionnumber;
    }

    public String getSubscriptiontype() {
        return subscriptiontype;
    }

    public void setSubscriptiontype(String subscriptiontype) {
        this.subscriptiontype = subscriptiontype;
    }



    public String getSubscriptionstatus() {
        return subscriptionstatus;
    }

    public void setSubscriptionstatus(String subscriptionstatus) {
        this.subscriptionstatus = subscriptionstatus;
    }

    public String getSupervisionstatus() {
        return supervisionstatus;
    }

    public void setSupervisionstatus(String supervisionstatus) {
        this.supervisionstatus = supervisionstatus;
    }

    public String getAgreementnumber() {
        return agreementnumber;
    }

    public void setAgreementnumber(String agreementnumber) {
        this.agreementnumber = agreementnumber;
    }

    public String getOfferingname() {
        return offeringname;
    }

    public void setOfferingname(String offeringname) {
        this.offeringname = offeringname;
    }

    public String getCustomertype() {
        return customertype;
    }

    public void setCustomertype(String customertype) {
        this.customertype = customertype;
    }

    public String getReferencetextonbill() {
        return referencetextonbill;
    }

    public void setReferencetextonbill(String referencetextonbill) {
        this.referencetextonbill = referencetextonbill;
    }

    public String getActivationdate() {
        return activationdate;
    }

    public void setActivationdate(String activationdate) {
        this.activationdate = activationdate;
    }

    public String getPaymentmethod() {
        return paymentmethod;
    }

    public void setPaymentmethod(String paymentmethod) {
        this.paymentmethod = paymentmethod;
    }

    public String getBrandid() {
        return brandid;
    }

    public void setBrandid(String brandid) {
        this.brandid = brandid;
    }

    public String getBranddescription() {
        return branddescription;
    }

    public void setBranddescription(String branddescription) {
        this.branddescription = branddescription;
    }


    public String getCustomertargetsegment() {
        return customertargetsegment;
    }

    public void setCustomertargetsegment(String customertargetsegment) {
        this.customertargetsegment = customertargetsegment;
    }

    public String getMultisubscriptionnumber() {
        return multisubscriptionnumber;
    }

    public void setMultisubscriptionnumber(String multisubscriptionnumber) {
        this.multisubscriptionnumber = multisubscriptionnumber;
    }


    public String getCustomeridentificationnumber() {
        return customeridentificationnumber;
    }

    public void setCustomeridentificationnumber(String customeridentificationnumber) {
        this.customeridentificationnumber = customeridentificationnumber;
    }

    public String getAccountnumber() {
        return accountnumber;
    }

    public void setAccountnumber(String accountnumber) {
        this.accountnumber = accountnumber;
    }

    public String getInvoicedeliverymethod() {
        return invoicedeliverymethod;
    }

    public void setInvoicedeliverymethod(String invoicedeliverymethod) {
        this.invoicedeliverymethod = invoicedeliverymethod;
    }

    public String getInvoicedeliverymethoddescr() {
        return invoicedeliverymethoddescr;
    }

    public void setInvoicedeliverymethoddescr(String invoicedeliverymethoddescr) {
        this.invoicedeliverymethoddescr = invoicedeliverymethoddescr;
    }

    public String getBillentityobjid() {
        return billentityobjid;
    }

    public void setBillentityobjid(String billentityobjid) {
        this.billentityobjid = billentityobjid;
    }

    public String getCommunityowner() {
        return communityowner;
    }

    public void setCommunityowner(String communityowner) {
        this.communityowner = communityowner;
    }

    public String getBillingaccountnumber() {
        return billingaccountnumber;
    }

    public void setBillingaccountnumber(String billingaccountnumber) {
        this.billingaccountnumber = billingaccountnumber;
    }

    public String getMsisdn() {
        return msisdn;
    }

    public void setMsisdn(String msisdn) {
        this.msisdn = msisdn;
    }

    public String getC2bcacheuid() {
        return c2bcacheuid;
    }

    public void setC2bcacheuid(String c2bcacheuid) {
        this.c2bcacheuid = c2bcacheuid;
    }

    public String getMultisubscriptiontype() {
        return multisubscriptiontype;
    }

    public void setMultisubscriptiontype(String multisubscriptiontype) {
        this.multisubscriptiontype = multisubscriptiontype;
    }

    public String getMultisubscriptiontypedescr() {
        return multisubscriptiontypedescr;
    }

    public void setMultisubscriptiontypedescr(String multisubscriptiontypedescr) {
        this.multisubscriptiontypedescr = multisubscriptiontypedescr;
    }

    public List<String> getServicecode() {
        return servicecode;
    }

    public void setServicecode(List<String> servicecode) {
        this.servicecode = servicecode;
    }

    public List<String> getServicevalue() {
        return servicevalue;
    }

    public void setServicevalue(List<String> servicevalue) {
        this.servicevalue = servicevalue;
    }

    public List<String> getAttributename() {
        return attributename;
    }

    public void setAttributename(List<String> attributename) {
        this.attributename = attributename;
    }

    public List<String> getAttributevalue() {
        return attributevalue;
    }

    public void setAttributevalue(List<String> attributevalue) {
        this.attributevalue = attributevalue;
    }

    public List<String> getServiceinvoicetext() {
        return serviceinvoicetext;
    }

    public void setServiceinvoicetext(List<String> serviceinvoicetext) {
        this.serviceinvoicetext = serviceinvoicetext;
    }

    public List<String> getServiceallowance() {
        return serviceallowance;
    }

    public void setServiceallowance(List<String> serviceallowance) {
        this.serviceallowance = serviceallowance;
    }

    /*templates String getCusAddressrow1() {
        return cusAddressrow1;
    }

    templates void setCusAddressrow1(String cusAddressrow1) {
        this.cusAddressrow1 = cusAddressrow1;
    }

    templates String getCusAddressrow2() {
        return cusAddressrow2;
    }

    templates void setCusAddressrow2(String cusAddressrow2) {
        this.cusAddressrow2 = cusAddressrow2;
    }

    templates String getCusAddressrow3() {
        return cusAddressrow3;
    }

    templates void setCusAddressrow3(String cusAddressrow3) {
        this.cusAddressrow3 = cusAddressrow3;
    }

    templates String getCusZipcode() {
        return cusZipcode;
    }

    templates void setCusZipcode(String cusZipcode) {
        this.cusZipcode = cusZipcode;
    }

    templates String getCusCity() {
        return cusCity;
    }

    templates void setCusCity(String cusCity) {
        this.cusCity = cusCity;
    }

    templates String getCusCountry() {
        return cusCountry;
    }

    templates void setCusCountry(String cusCountry) {
        this.cusCountry = cusCountry;
    }

    templates String getCusName1() {
        return cusName1;
    }

    templates void setCusName1(String cusName1) {
        this.cusName1 = cusName1;
    }

    templates String getCusName2() {
        return cusName2;
    }

    templates void setCusName2(String cusName2) {
        this.cusName2 = cusName2;
    }

    templates String getCusName3() {
        return cusName3;
    }

    templates void setCusName3(String cusName3) {
        this.cusName3 = cusName3;
    }

    templates String getBgAddressrow1() {
        return bgAddressrow1;
    }

    templates void setBgAddressrow1(String bgAddressrow1) {
        this.bgAddressrow1 = bgAddressrow1;
    }

    templates String getBgAddressrow2() {
        return bgAddressrow2;
    }

    templates void setBgAddressrow2(String bgAddressrow2) {
        this.bgAddressrow2 = bgAddressrow2;
    }

    templates String getBgAddressrow3() {
        return bgAddressrow3;
    }

    templates void setBgAddressrow3(String bgAddressrow3) {
        this.bgAddressrow3 = bgAddressrow3;
    }

    templates String getBgZipcode() {
        return bgZipcode;
    }

    templates void setBgZipcode(String bgZipcode) {
        this.bgZipcode = bgZipcode;
    }

    templates String getBgCity() {
        return bgCity;
    }

    templates void setBgCity(String bgCity) {
        this.bgCity = bgCity;
    }

    templates String getBgCountry() {
        return bgCountry;
    }

    templates void setBgCountry(String bgCountry) {
        this.bgCountry = bgCountry;
    }

    templates String getBgName1() {
        return bgName1;
    }

    templates void setBgName1(String bgName1) {
        this.bgName1 = bgName1;
    }

    templates String getBgName2() {
        return bgName2;
    }

    templates void setBgName2(String bgName2) {
        this.bgName2 = bgName2;
    }

    templates String getBgName3() {
        return bgName3;
    }

    templates void setBgName3(String bgName3) {
        this.bgName3 = bgName3;
    }
*/
    @Override
    public String toString() {
        return "MobileSubscription{" +
                "subscriptionnumber='" + subscriptionnumber + '\'' +
                ", customeridentificationnumber='" + customeridentificationnumber + '\'' +
                '}';
    }
}








