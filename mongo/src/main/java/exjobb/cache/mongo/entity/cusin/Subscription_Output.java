package exjobb.cache.mongo.entity.cusin;

import exjobb.cache.mongo.entity.cusin.address.SubscriptionAddress;
import org.springframework.data.annotation.Id;

import java.util.ArrayList;

/**
 * Created by Jimmie on 10/6/2017.
 */

public class Subscription_Output {
    @Id
    private String id;


    private String subscriptionid;

    private String extracardsubscriptionid;
    private String clientsystem;
    private String subscriptiontype;
    private String customernumber;
    private String creationdate;
    private String subscriptionstatus;
    private String supervisionstatus;
    private String unlisted;
    private String agreementnumber;
    private String commitmentenddate;
    private String commitmentlength;
    private String eventnumber;
    private String userid;
    private String userchangedate;
    private String changetime;
    private String referencetextonbill;
    private String activationdate;
    private String deactivationdate;
    private String retailernumber;
    private String typedescription;
    private String paymentmethod;
    private String brandid;
    private String branddescription;
    private String subscriptionnumber;
    private String billinggroupid;
    private String trafficstatuscode;
    private String trafficdescription;
    private String trafficstatusreason;
    private String billentityobjid;
    private String commitmentstartdate;
    private String hlrprofile;
    private String subscriptioncreationsource;
    private String advertinginterest;
    private String incustomernumber;
    private String telefinansgroup;
    private String creditratingstatus;
    private String supervisiondate;
    private String supervisionlevel;
    private String subscriptiontypedescr;
    private String customertargetsegment;
    private String subscriptiontypecategory;
    private String product;
    private String mtime;
    private String multisubscriptionnumber;
    private String multisubscriptionstatus;
    private ArrayList<Customer> customerlist = new ArrayList<>();
    private Customer customer;
    private CommunityMember member;

    public Subscription_Output() {
        super();
    }

    private ArrayList<SubscriptionAddress> ADDRESS = new ArrayList<>();

    public String getId() {
        return id;
    }

    public String getSubscriptionid() {
        return subscriptionid;
    }

    public void setSubscriptionid(String subscriptionid) {
        this.subscriptionid = subscriptionid;
    }

    public String getExtracardsubscriptionid() {
        return extracardsubscriptionid;
    }

    public void setExtracardsubscriptionid(String extracardsubscriptionid) {
        this.extracardsubscriptionid = extracardsubscriptionid;
    }

    public String getClientsystem() {
        return clientsystem;
    }

    public void setClientsystem(String clientsystem) {
        this.clientsystem = clientsystem;
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

    public String getEventnumber() {
        return eventnumber;
    }

    public void setEventnumber(String eventnumber) {
        this.eventnumber = eventnumber;
    }

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

    public String getDeactivationdate() {
        return deactivationdate;
    }

    public void setDeactivationdate(String deactivationdate) {
        this.deactivationdate = deactivationdate;
    }

    public String getRetailernumber() {
        return retailernumber;
    }

    public void setRetailernumber(String retailernumber) {
        this.retailernumber = retailernumber;
    }

    public String getTypedescription() {
        return typedescription;
    }

    public void setTypedescription(String typedescription) {
        this.typedescription = typedescription;
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

    public String getSubscriptionnumber() {
        return subscriptionnumber;
    }

    public void setSubscriptionnumber(String subscriptionnumber) {
        this.subscriptionnumber = subscriptionnumber;
    }

    public String getBillinggroupid() {
        return billinggroupid;
    }

    public void setBillinggroupid(String billinggroupid) {
        this.billinggroupid = billinggroupid;
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

    public String getBillentityobjid() {
        return billentityobjid;
    }

    public void setBillentityobjid(String billentityobjid) {
        this.billentityobjid = billentityobjid;
    }

    public String getCommitmentstartdate() {
        return commitmentstartdate;
    }

    public void setCommitmentstartdate(String commitmentstartdate) {
        this.commitmentstartdate = commitmentstartdate;
    }

    public String getHlrprofile() {
        return hlrprofile;
    }

    public void setHlrprofile(String hlrprofile) {
        this.hlrprofile = hlrprofile;
    }

    public String getSubscriptioncreationsource() {
        return subscriptioncreationsource;
    }

    public void setSubscriptioncreationsource(String subscriptioncreationsource) {
        this.subscriptioncreationsource = subscriptioncreationsource;
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

    public String getTelefinansgroup() {
        return telefinansgroup;
    }

    public void setTelefinansgroup(String telefinansgroup) {
        this.telefinansgroup = telefinansgroup;
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

    public String getMtime() {
        return mtime;
    }

    public void setMtime(String mtime) {
        this.mtime = mtime;
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

    public ArrayList<Customer> getCustomerlist() {
        return customerlist;
    }

    public void setCustomerlist(ArrayList<Customer> customerlist) {
        this.customerlist = customerlist;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public ArrayList<SubscriptionAddress> getADDRESS() {
        return ADDRESS;
    }

    public void setADDRESS(ArrayList<SubscriptionAddress> ADDRESS) {
        this.ADDRESS = ADDRESS;
    }

    public CommunityMember getMember() {
        return member;
    }

    public void setMember(CommunityMember member) {
        this.member = member;
    }
}
