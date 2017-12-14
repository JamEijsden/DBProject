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
    private String customernumber;
    private String creationdate;
    private String subscriptionstatus;
    private String supervisionstatus;
    private String unlisted;
    private String agreementnumber;
    private String commitmentenddate;
    private String commitmentlength;
    //private String eventnumber;
    private String userid;
    private String userchangedate;
    private String changetime;
    private String referencetextonbill;
    private String activationdate;
    private String deactivationdat;
    private String retailernumber;
    private String paymentmethod;
    private String brandid;
    private String branddescription;
    private String trafficstatuscode;
    private String trafficdescription;
    private String trafficstatusreason;
    private String commitmentstartdate;
    private String advertinginterest;
    private String incustomernumber;
    private String creditratingstatus;
    private String supervisiondate;
    private String supervisionlevel;
    private String subscriptiontypedescr;
    private String offeringname;
    private String customertargetsegment;
    private String subscriptiontypecategory;
    private String product;
    private String multisubscriptionnumber;
    private String multisubscriptionstatus;
    private String sub_addressrow1;
    private String sub_addressrow2;
    private String sub_addressrow3;
    private String sub_zipcode;
    private String sub_city;
    private String sub_country;
    private String subscriptionname;
    private String sub_name;
    private String sub_name2;
    private String sub_name3;
    private String subscriptionaddress;
    private String customeridentificationnumber;
    private String customertype;
    private String cus_addressrow1;
    private String cus_addressrow2;
    private String cus_addressrow3;
    private String cus_zipcode;
    private String cus_city;
    private String cus_country;
    private String customeraddress;
    private String cus_name;
    private String cus_name2;
    private String cus_name3;
    private String customername;
    private String amountlimit;
    private String percentlevel;
    private String accountnumber;
    private String bg_addressrow1;
    private String bg_addressrow2;
    private String bg_addressrow3;
    private String bg_zipcode;
    private String bg_city;
    private String bg_country;
    private String bg_name;
    private String bg_name2;
    private String bg_name3;
    private String invoicedeliverymethod;
    private String invoicedeliverydescr;
    private String billingname;
    private String billingaddress;
    private String billentityobjid;
    private String communityowner;
    private String icc;
    private String xtas;
    private String mtime;
    private String ctime;
    private String dtime;
    private String billingaccountnumber;
    private String mobileexchangeservice;
    private String mobileexchangeservicedescr;
    private String gprsservice;
    private String gprsservicedescr;
    private String gprsserviceallowance;
    private String roamingservice;
    private String roamingservicedescr;
    private String categoryid;
    private String msisdn;
    private String categoryname;
    private String c2bcacheuid;
    private String xtasflag_mtime;
    private String isextracard;
    private String subscriptionpointid;
    private String carrierid;
    private String homeservice;
    private String homeservicedescr;
    private String multisubscriptiontype;
    private String multisubscriptiontypedescr;
    private String multisubscriptiontypecategory;

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

    public String getCustomernumber() {
        return customernumber;
    }

    public void setCustomernumber(String customernumber) {
        this.customernumber = customernumber;
    }

    public String getCreationdate() {
        return creationdate;
    }

    public void setCreationdate(String creationdate) {
        this.creationdate = creationdate;
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

    public String getUnlisted() {
        return unlisted;
    }

    public void setUnlisted(String unlisted) {
        this.unlisted = unlisted;
    }

    public String getAgreementnumber() {
        return agreementnumber;
    }

    public void setAgreementnumber(String agreementnumber) {
        this.agreementnumber = agreementnumber;
    }

    public String getCommitmentenddate() {
        return commitmentenddate;
    }

    public void setCommitmentenddate(String commitmentenddate) {
        this.commitmentenddate = commitmentenddate;
    }

    public String getCommitmentlength() {
        return commitmentlength;
    }

    public void setCommitmentlength(String commitmentlength) {
        this.commitmentlength = commitmentlength;
    }

   /* public String getEventnumber() {
        return eventnumber;
    }

    public void setEventnumber(String eventnumber) {
        this.eventnumber = eventnumber;
    }
*/
    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getUserchangedate() {
        return userchangedate;
    }

    public void setUserchangedate(String userchangedate) {
        this.userchangedate = userchangedate;
    }

    public String getChangetime() {
        return changetime;
    }

    public void setChangetime(String changetime) {
        this.changetime = changetime;
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

    public String getDeactivationdat() {
        return deactivationdat;
    }

    public void setDeactivationdat(String deactivationdat) {
        this.deactivationdat = deactivationdat;
    }

    public String getRetailernumber() {
        return retailernumber;
    }

    public void setRetailernumber(String retailernumber) {
        this.retailernumber = retailernumber;
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

    public String getTrafficstatuscode() {
        return trafficstatuscode;
    }

    public void setTrafficstatuscode(String trafficstatuscode) {
        this.trafficstatuscode = trafficstatuscode;
    }

    public String getTrafficdescription() {
        return trafficdescription;
    }

    public void setTrafficdescription(String trafficdescription) {
        this.trafficdescription = trafficdescription;
    }

    public String getTrafficstatusreason() {
        return trafficstatusreason;
    }

    public void setTrafficstatusreason(String trafficstatusreason) {
        this.trafficstatusreason = trafficstatusreason;
    }

    public String getCommitmentstartdate() {
        return commitmentstartdate;
    }

    public void setCommitmentstartdate(String commitmentstartdate) {
        this.commitmentstartdate = commitmentstartdate;
    }

    public String getAdvertinginterest() {
        return advertinginterest;
    }

    public void setAdvertinginterest(String advertinginterest) {
        this.advertinginterest = advertinginterest;
    }

    public String getIncustomernumber() {
        return incustomernumber;
    }

    public void setIncustomernumber(String incustomernumber) {
        this.incustomernumber = incustomernumber;
    }

    public String getCreditratingstatus() {
        return creditratingstatus;
    }

    public void setCreditratingstatus(String creditratingstatus) {
        this.creditratingstatus = creditratingstatus;
    }

    public String getSupervisiondate() {
        return supervisiondate;
    }

    public void setSupervisiondate(String supervisiondate) {
        this.supervisiondate = supervisiondate;
    }

    public String getSupervisionlevel() {
        return supervisionlevel;
    }

    public void setSupervisionlevel(String supervisionlevel) {
        this.supervisionlevel = supervisionlevel;
    }

    public String getSubscriptiontypedescr() {
        return subscriptiontypedescr;
    }

    public void setSubscriptiontypedescr(String subscriptiontypedescr) {
        this.subscriptiontypedescr = subscriptiontypedescr;
    }

    public String getOfferingname() {
        return offeringname;
    }

    public void setOfferingname(String offeringname) {
        this.offeringname = offeringname;
    }

    public String getCustomertargetsegment() {
        return customertargetsegment;
    }

    public void setCustomertargetsegment(String customertargetsegment) {
        this.customertargetsegment = customertargetsegment;
    }

    public String getSubscriptiontypecategory() {
        return subscriptiontypecategory;
    }

    public void setSubscriptiontypecategory(String subscriptiontypecategory) {
        this.subscriptiontypecategory = subscriptiontypecategory;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getMultisubscriptionnumber() {
        return multisubscriptionnumber;
    }

    public void setMultisubscriptionnumber(String multisubscriptionnumber) {
        this.multisubscriptionnumber = multisubscriptionnumber;
    }

    public String getMultisubscriptionstatus() {
        return multisubscriptionstatus;
    }

    public void setMultisubscriptionstatus(String multisubscriptionstatus) {
        this.multisubscriptionstatus = multisubscriptionstatus;
    }

    public String getSub_addressrow1() {
        return sub_addressrow1;
    }

    public void setSub_addressrow1(String sub_addressrow1) {
        this.sub_addressrow1 = sub_addressrow1;
    }

    public String getSub_addressrow2() {
        return sub_addressrow2;
    }

    public void setSub_addressrow2(String sub_addressrow2) {
        this.sub_addressrow2 = sub_addressrow2;
    }

    public String getSub_addressrow3() {
        return sub_addressrow3;
    }

    public void setSub_addressrow3(String sub_addressrow3) {
        this.sub_addressrow3 = sub_addressrow3;
    }

    public String getSub_zipcode() {
        return sub_zipcode;
    }

    public void setSub_zipcode(String sub_zipcode) {
        this.sub_zipcode = sub_zipcode;
    }

    public String getSub_city() {
        return sub_city;
    }

    public void setSub_city(String sub_city) {
        this.sub_city = sub_city;
    }

    public String getSub_country() {
        return sub_country;
    }

    public void setSub_country(String sub_country) {
        this.sub_country = sub_country;
    }

    public String getSubscriptionname() {
        return subscriptionname;
    }

    public void setSubscriptionname(String subscriptionname) {
        this.subscriptionname = subscriptionname;
    }

    public String getSub_name() {
        return sub_name;
    }

    public void setSub_name(String sub_name) {
        this.sub_name = sub_name;
    }

    public String getSub_name2() {
        return sub_name2;
    }

    public void setSub_name2(String sub_name2) {
        this.sub_name2 = sub_name2;
    }

    public String getSub_name3() {
        return sub_name3;
    }

    public void setSub_name3(String sub_name3) {
        this.sub_name3 = sub_name3;
    }

    public String getSubscriptionaddress() {
        return subscriptionaddress;
    }

    public void setSubscriptionaddress(String subscriptionaddress) {
        this.subscriptionaddress = subscriptionaddress;
    }

    public String getCustomeridentificationnumber() {
        return customeridentificationnumber;
    }

    public void setCustomeridentificationnumber(String customeridentificationnumber) {
        this.customeridentificationnumber = customeridentificationnumber;
    }

    public String getCustomertype() {
        return customertype;
    }

    public void setCustomertype(String customertype) {
        this.customertype = customertype;
    }

    public String getCus_addressrow1() {
        return cus_addressrow1;
    }

    public void setCus_addressrow1(String cus_addressrow1) {
        this.cus_addressrow1 = cus_addressrow1;
    }

    public String getCus_addressrow2() {
        return cus_addressrow2;
    }

    public void setCus_addressrow2(String cus_addressrow2) {
        this.cus_addressrow2 = cus_addressrow2;
    }

    public String getCus_addressrow3() {
        return cus_addressrow3;
    }

    public void setCus_addressrow3(String cus_addressrow3) {
        this.cus_addressrow3 = cus_addressrow3;
    }

    public String getCus_zipcode() {
        return cus_zipcode;
    }

    public void setCus_zipcode(String cus_zipcode) {
        this.cus_zipcode = cus_zipcode;
    }

    public String getCus_city() {
        return cus_city;
    }

    public void setCus_city(String cus_city) {
        this.cus_city = cus_city;
    }

    public String getCus_country() {
        return cus_country;
    }

    public void setCus_country(String cus_country) {
        this.cus_country = cus_country;
    }

    public String getCustomeraddress() {
        return customeraddress;
    }

    public void setCustomeraddress(String customeraddress) {
        this.customeraddress = customeraddress;
    }

    public String getCus_name() {
        return cus_name;
    }

    public void setCus_name(String cus_name) {
        this.cus_name = cus_name;
    }

    public String getCus_name2() {
        return cus_name2;
    }

    public void setCus_name2(String cus_name2) {
        this.cus_name2 = cus_name2;
    }

    public String getCus_name3() {
        return cus_name3;
    }

    public void setCus_name3(String cus_name3) {
        this.cus_name3 = cus_name3;
    }

    public String getCustomername() {
        return customername;
    }

    public void setCustomername(String customername) {
        this.customername = customername;
    }

    public String getAmountlimit() {
        return amountlimit;
    }

    public void setAmountlimit(String amountlimit) {
        this.amountlimit = amountlimit;
    }

    public String getPercentlevel() {
        return percentlevel;
    }

    public void setPercentlevel(String percentlevel) {
        this.percentlevel = percentlevel;
    }

    public String getAccountnumber() {
        return accountnumber;
    }

    public void setAccountnumber(String accountnumber) {
        this.accountnumber = accountnumber;
    }

    public String getBg_addressrow1() {
        return bg_addressrow1;
    }

    public void setBg_addressrow1(String bg_addressrow1) {
        this.bg_addressrow1 = bg_addressrow1;
    }

    public String getBg_addressrow2() {
        return bg_addressrow2;
    }

    public void setBg_addressrow2(String bg_addressrow2) {
        this.bg_addressrow2 = bg_addressrow2;
    }

    public String getBg_addressrow3() {
        return bg_addressrow3;
    }

    public void setBg_addressrow3(String bg_addressrow3) {
        this.bg_addressrow3 = bg_addressrow3;
    }

    public String getBg_zipcode() {
        return bg_zipcode;
    }

    public void setBg_zipcode(String bg_zipcode) {
        this.bg_zipcode = bg_zipcode;
    }

    public String getBg_city() {
        return bg_city;
    }

    public void setBg_city(String bg_city) {
        this.bg_city = bg_city;
    }

    public String getBg_country() {
        return bg_country;
    }

    public void setBg_country(String bg_country) {
        this.bg_country = bg_country;
    }

    public String getBg_name() {
        return bg_name;
    }

    public void setBg_name(String bg_name) {
        this.bg_name = bg_name;
    }

    public String getBg_name2() {
        return bg_name2;
    }

    public void setBg_name2(String bg_name2) {
        this.bg_name2 = bg_name2;
    }

    public String getBg_name3() {
        return bg_name3;
    }

    public void setBg_name3(String bg_name3) {
        this.bg_name3 = bg_name3;
    }

    public String getInvoicedeliverymethod() {
        return invoicedeliverymethod;
    }

    public void setInvoicedeliverymethod(String invoicedeliverymethod) {
        this.invoicedeliverymethod = invoicedeliverymethod;
    }

    public String getInvoicedeliverydescr() {
        return invoicedeliverydescr;
    }

    public void setInvoicedeliverydescr(String invoicedeliverydescr) {
        this.invoicedeliverydescr = invoicedeliverydescr;
    }

    public String getBillingname() {
        return billingname;
    }

    public void setBillingname(String billingname) {
        this.billingname = billingname;
    }

    public String getBillingaddress() {
        return billingaddress;
    }

    public void setBillingaddress(String billingaddress) {
        this.billingaddress = billingaddress;
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

    public String getIcc() {
        return icc;
    }

    public void setIcc(String icc) {
        this.icc = icc;
    }

    public String getXtas() {
        return xtas;
    }

    public void setXtas(String xtas) {
        this.xtas = xtas;
    }

    public String getMtime() {
        return mtime;
    }

    public void setMtime(String mtime) {
        this.mtime = mtime;
    }

    public String getCtime() {
        return ctime;
    }

    public void setCtime(String ctime) {
        this.ctime = ctime;
    }

    public String getDtime() {
        return dtime;
    }

    public void setDtime(String dtime) {
        this.dtime = dtime;
    }

    public String getBillingaccountnumber() {
        return billingaccountnumber;
    }

    public void setBillingaccountnumber(String billingaccountnumber) {
        this.billingaccountnumber = billingaccountnumber;
    }

    public String getMobileexchangeservice() {
        return mobileexchangeservice;
    }

    public void setMobileexchangeservice(String mobileexchangeservice) {
        this.mobileexchangeservice = mobileexchangeservice;
    }

    public String getMobileexchangeservicedescr() {
        return mobileexchangeservicedescr;
    }

    public void setMobileexchangeservicedescr(String mobileexchangeservicedescr) {
        this.mobileexchangeservicedescr = mobileexchangeservicedescr;
    }

    public String getGprsservice() {
        return gprsservice;
    }

    public void setGprsservice(String gprsservice) {
        this.gprsservice = gprsservice;
    }

    public String getGprsservicedescr() {
        return gprsservicedescr;
    }

    public void setGprsservicedescr(String gprsservicedescr) {
        this.gprsservicedescr = gprsservicedescr;
    }

    public String getGprsserviceallowance() {
        return gprsserviceallowance;
    }

    public void setGprsserviceallowance(String gprsserviceallowance) {
        this.gprsserviceallowance = gprsserviceallowance;
    }

    public String getRoamingservice() {
        return roamingservice;
    }

    public void setRoamingservice(String roamingservice) {
        this.roamingservice = roamingservice;
    }

    public String getRoamingservicedescr() {
        return roamingservicedescr;
    }

    public void setRoamingservicedescr(String roamingservicedescr) {
        this.roamingservicedescr = roamingservicedescr;
    }

    public String getCategoryid() {
        return categoryid;
    }

    public void setCategoryid(String categoryid) {
        this.categoryid = categoryid;
    }

    public String getMsisdn() {
        return msisdn;
    }

    public void setMsisdn(String msisdn) {
        this.msisdn = msisdn;
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

    public String getXtasflag_mtime() {
        return xtasflag_mtime;
    }

    public void setXtasflag_mtime(String xtasflag_mtime) {
        this.xtasflag_mtime = xtasflag_mtime;
    }

    public String getIsextracard() {
        return isextracard;
    }

    public void setIsextracard(String isextracard) {
        this.isextracard = isextracard;
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

    public String getHomeservice() {
        return homeservice;
    }

    public void setHomeservice(String homeservice) {
        this.homeservice = homeservice;
    }

    public String getHomeservicedescr() {
        return homeservicedescr;
    }

    public void setHomeservicedescr(String homeservicedescr) {
        this.homeservicedescr = homeservicedescr;
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

    public String getMultisubscriptiontypecategory() {
        return multisubscriptiontypecategory;
    }

    public void setMultisubscriptiontypecategory(String multisubscriptiontypecategory) {
        this.multisubscriptiontypecategory = multisubscriptiontypecategory;
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

    @Override
    public String toString() {
        return "MobileSubscription{" +
                "subscriptionnumber='" + subscriptionnumber + '\'' +
                ", customernumber='" + customernumber + '\'' +
                ", customeridentificationnumber='" + customeridentificationnumber + '\'' +
                '}';
    }
}








