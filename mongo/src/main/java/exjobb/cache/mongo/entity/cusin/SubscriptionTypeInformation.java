package exjobb.cache.mongo.entity.cusin;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by Jimmie on 10/6/2017.
 */
@Document(collection = "subscriptiontypeinformation")
public class SubscriptionTypeInformation {
    @Id
    private String id;
    private String originalid;
    private String subscriptiontypecode;
    private String product;
    private String category;
    private String classification;
    private String textlong;
    private String textshort;
    private String textboss;
    private String invoicetext;
    private String description;
    private String operator;
    private String trademark;
    private String customersegments;
    private String gsmahscontractlabel;
    private String validforsimplesubscription;
    private String validforagreement;
    private String agreementtypes;
    private String useforoe;
    private String multisubscriptiontype;
    private String billingmodel;
    private String methodofbilling;
    private String launchdate;
    private String sellstopdate;
    private String note;
    private String customerinformation;
    private String allowbinding;
    private String showinvoiceminasidor;
    private String showinvoicemitthalebop;
    private String monthlyinvoice;
    private String delayedfirstinvoice;
    private String billingchangingfromprepaid;
    private String prepaidcommunity;
    private String flaterate;
    private String validfortjv;
    private String validforkax;
    private String channelmax;
    private String requiresmulconnection;
    private String bindingperiod;
    private String delayedactivation;
    private String subcategory;
    private String bindingservices;
    private String validfordelayedactivation;
    private String dataamountwarningsms;
    private String delayedactivationbilled;
    private String bindingperiods;

    public String getId() {
        return id;
    }

    public String getOriginalid() {
        return originalid;
    }

    public void setOriginalid(String originalid) {
        this.originalid = originalid;
    }

    public String getSubscriptiontypecode() {
        return subscriptiontypecode;
    }

    public void setSubscriptiontypecode(String subscriptiontypecode) {
        this.subscriptiontypecode = subscriptiontypecode;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getClassification() {
        return classification;
    }

    public void setClassification(String classification) {
        this.classification = classification;
    }

    public String getTextlong() {
        return textlong;
    }

    public void setTextlong(String textlong) {
        this.textlong = textlong;
    }

    public String getTextshort() {
        return textshort;
    }

    public void setTextshort(String textshort) {
        this.textshort = textshort;
    }

    public String getTextboss() {
        return textboss;
    }

    public void setTextboss(String textboss) {
        this.textboss = textboss;
    }

    public String getInvoicetext() {
        return invoicetext;
    }

    public void setInvoicetext(String invoicetext) {
        this.invoicetext = invoicetext;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getTrademark() {
        return trademark;
    }

    public void setTrademark(String trademark) {
        this.trademark = trademark;
    }

    public String getCustomersegments() {
        return customersegments;
    }

    public void setCustomersegments(String customersegments) {
        this.customersegments = customersegments;
    }

    public String getGsmahscontractlabel() {
        return gsmahscontractlabel;
    }

    public void setGsmahscontractlabel(String gsmahscontractlabel) {
        this.gsmahscontractlabel = gsmahscontractlabel;
    }

    public String getValidforsimplesubscription() {
        return validforsimplesubscription;
    }

    public void setValidforsimplesubscription(String validforsimplesubscription) {
        this.validforsimplesubscription = validforsimplesubscription;
    }

    public String getValidforagreement() {
        return validforagreement;
    }

    public void setValidforagreement(String validforagreement) {
        this.validforagreement = validforagreement;
    }

    public String getAgreementtypes() {
        return agreementtypes;
    }

    public void setAgreementtypes(String agreementtypes) {
        this.agreementtypes = agreementtypes;
    }

    public String getUseforoe() {
        return useforoe;
    }

    public void setUseforoe(String useforoe) {
        this.useforoe = useforoe;
    }

    public String getMultisubscriptiontype() {
        return multisubscriptiontype;
    }

    public void setMultisubscriptiontype(String multisubscriptiontype) {
        this.multisubscriptiontype = multisubscriptiontype;
    }

    public String getBillingmodel() {
        return billingmodel;
    }

    public void setBillingmodel(String billingmodel) {
        this.billingmodel = billingmodel;
    }

    public String getMethodofbilling() {
        return methodofbilling;
    }

    public void setMethodofbilling(String methodofbilling) {
        this.methodofbilling = methodofbilling;
    }

    public String getLaunchdate() {
        return launchdate;
    }

    public void setLaunchdate(String launchdate) {
        this.launchdate = launchdate;
    }

    public String getSellstopdate() {
        return sellstopdate;
    }

    public void setSellstopdate(String sellstopdate) {
        this.sellstopdate = sellstopdate;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getCustomerinformation() {
        return customerinformation;
    }

    public void setCustomerinformation(String customerinformation) {
        this.customerinformation = customerinformation;
    }

    public String getAllowbinding() {
        return allowbinding;
    }

    public void setAllowbinding(String allowbinding) {
        this.allowbinding = allowbinding;
    }

    public String getShowinvoiceminasidor() {
        return showinvoiceminasidor;
    }

    public void setShowinvoiceminasidor(String showinvoiceminasidor) {
        this.showinvoiceminasidor = showinvoiceminasidor;
    }

    public String getShowinvoicemitthalebop() {
        return showinvoicemitthalebop;
    }

    public void setShowinvoicemitthalebop(String showinvoicemitthalebop) {
        this.showinvoicemitthalebop = showinvoicemitthalebop;
    }

    public String getMonthlyinvoice() {
        return monthlyinvoice;
    }

    public void setMonthlyinvoice(String monthlyinvoice) {
        this.monthlyinvoice = monthlyinvoice;
    }

    public String getDelayedfirstinvoice() {
        return delayedfirstinvoice;
    }

    public void setDelayedfirstinvoice(String delayedfirstinvoice) {
        this.delayedfirstinvoice = delayedfirstinvoice;
    }

    public String getBillingchangingfromprepaid() {
        return billingchangingfromprepaid;
    }

    public void setBillingchangingfromprepaid(String billingchangingfromprepaid) {
        this.billingchangingfromprepaid = billingchangingfromprepaid;
    }

    public String getPrepaidcommunity() {
        return prepaidcommunity;
    }

    public void setPrepaidcommunity(String prepaidcommunity) {
        this.prepaidcommunity = prepaidcommunity;
    }

    public String getFlaterate() {
        return flaterate;
    }

    public void setFlaterate(String flaterate) {
        this.flaterate = flaterate;
    }

    public String getValidfortjv() {
        return validfortjv;
    }

    public void setValidfortjv(String validfortjv) {
        this.validfortjv = validfortjv;
    }

    public String getValidforkax() {
        return validforkax;
    }

    public void setValidforkax(String validforkax) {
        this.validforkax = validforkax;
    }

    public String getChannelmax() {
        return channelmax;
    }

    public void setChannelmax(String channelmax) {
        this.channelmax = channelmax;
    }

    public String getRequiresmulconnection() {
        return requiresmulconnection;
    }

    public void setRequiresmulconnection(String requiresmulconnection) {
        this.requiresmulconnection = requiresmulconnection;
    }

    public String getBindingperiod() {
        return bindingperiod;
    }

    public void setBindingperiod(String bindingperiod) {
        this.bindingperiod = bindingperiod;
    }

    public String getDelayedactivation() {
        return delayedactivation;
    }

    public void setDelayedactivation(String delayedactivation) {
        this.delayedactivation = delayedactivation;
    }

    public String getSubcategory() {
        return subcategory;
    }

    public void setSubcategory(String subcategory) {
        this.subcategory = subcategory;
    }

    public String getBindingservices() {
        return bindingservices;
    }

    public void setBindingservices(String bindingservices) {
        this.bindingservices = bindingservices;
    }

    public String getValidfordelayedactivation() {
        return validfordelayedactivation;
    }

    public void setValidfordelayedactivation(String validfordelayedactivation) {
        this.validfordelayedactivation = validfordelayedactivation;
    }

    public String getDataamountwarningsms() {
        return dataamountwarningsms;
    }

    public void setDataamountwarningsms(String dataamountwarningsms) {
        this.dataamountwarningsms = dataamountwarningsms;
    }

    public String getDelayedactivationbilled() {
        return delayedactivationbilled;
    }

    public void setDelayedactivationbilled(String delayedactivationbilled) {
        this.delayedactivationbilled = delayedactivationbilled;
    }

    public String getBindingperiods() {
        return bindingperiods;
    }

    public void setBindingperiods(String bindingperiods) {
        this.bindingperiods = bindingperiods;
    }
}
