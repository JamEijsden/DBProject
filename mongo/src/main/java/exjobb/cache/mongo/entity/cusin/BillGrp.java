package exjobb.cache.mongo.entity.cusin;

import exjobb.cache.mongo.entity.cusin.address.BillGrpAddress;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;

/**
 * Created by Jimmie on 10/6/2017.
 */
@Document(collection = "billgrp")
public class BillGrp {
    private String id;
    private String accountnumber;
    private String clientsystem;
    private String customernumber;
    private String billinggroupid;
    private String eventnumber;
    private String userid;
    private String userchangedate;
    private String changetime;
    private String deactivationdate;
    private String entityobjid;
    private String custentityobjid;
    private String mtime;
    private String nospec;
    private String printspec;
    private String singlesubscriptionbilling;
    private String invoicedeliverymethod;
    private String invoicedeliverymethoddescr;
    private String emailinvoicecontactperson;
    private String emailinvoicemobilephonenumber;
    private String emailinvoiceemailaddress;
    private ArrayList<BillGrpAddress> address = new ArrayList();

    BillGrp(){
        super();
    }

    public String getId() {
        return id;
    }

    public String getAccountnumber() {
        return accountnumber;
    }

    public void setAccountnumber(String accountnumber) {
        this.accountnumber = accountnumber;
    }

    public String getClientsystem() {
        return clientsystem;
    }

    public void setClientsystem(String clientsystem) {
        this.clientsystem = clientsystem;
    }

    public String getCustomernumber() {
        return customernumber;
    }

    public void setCustomernumber(String customernumber) {
        this.customernumber = customernumber;
    }

    public String getBillinggroupid() {
        return billinggroupid;
    }

    public void setBillinggroupid(String billinggroupid) {
        this.billinggroupid = billinggroupid;
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

    public String getDeactivationdate() {
        return deactivationdate;
    }

    public void setDeactivationdate(String deactivationdate) {
        this.deactivationdate = deactivationdate;
    }

    public String getEntityobjid() {
        return entityobjid;
    }

    public void setEntityobjid(String entityobjid) {
        this.entityobjid = entityobjid;
    }

    public String getCustentityobjid() {
        return custentityobjid;
    }

    public void setCustentityobjid(String custentityobjid) {
        this.custentityobjid = custentityobjid;
    }

    public String getMtime() {
        return mtime;
    }

    public void setMtime(String mtime) {
        this.mtime = mtime;
    }

    public String getNospec() {
        return nospec;
    }

    public void setNospec(String nospec) {
        this.nospec = nospec;
    }

    public String getPrintspec() {
        return printspec;
    }

    public void setPrintspec(String printspec) {
        this.printspec = printspec;
    }

    public String getSinglesubscriptionbilling() {
        return singlesubscriptionbilling;
    }

    public void setSinglesubscriptionbilling(String singlesubscriptionbilling) {
        this.singlesubscriptionbilling = singlesubscriptionbilling;
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

    public String getEmailinvoicecontactperson() {
        return emailinvoicecontactperson;
    }

    public void setEmailinvoicecontactperson(String emailinvoicecontactperson) {
        this.emailinvoicecontactperson = emailinvoicecontactperson;
    }

    public String getEmailinvoicemobilephonenumber() {
        return emailinvoicemobilephonenumber;
    }

    public void setEmailinvoicemobilephonenumber(String emailinvoicemobilephonenumber) {
        this.emailinvoicemobilephonenumber = emailinvoicemobilephonenumber;
    }

    public String getEmailinvoiceemailaddress() {
        return emailinvoiceemailaddress;
    }

    public void setEmailinvoiceemailaddress(String emailinvoiceemailaddress) {
        this.emailinvoiceemailaddress = emailinvoiceemailaddress;
    }

    public ArrayList<BillGrpAddress> getAddress() {
        return address;
    }

    public void setAddress(ArrayList<BillGrpAddress> address) {
        this.address = address;
    }
}
