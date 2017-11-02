package exjobb.cache.mongo.entity.cusin;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by Jimmie on 10/16/2017.
 */

@Document(collection = "service_information")
public class ServiceInformation {

    @Id
    private String id;

    private String servicecodeid;
    private String servicecodetype;
    private String servicecodeshort;
    private String product;
    private String servicecategory;
    private String classification;
    private String subservicetype;
    private String text;
    private String textshort;
    private String invoicetext;
    private String description;
    private String operator;
    private String subscriptiontypecategorys;
    private String customersegments;
    private String validforsimplesubscription;
    private String validforagreement;
    private String agreementtypes;
    private String allowbinding;
    private String allowedbindings;
    private String servicefamily;
    private String valueclass;
    private String launchdate;
    private String sellstopdate;
    private String note;
    private String serviceadminchannels;
    private String availability;
    private String eqosid;
    private String eqosid_text;
    private String hss_esmprofileid;
    private String hss_esmprofileid_text;
    private String allowance;
    private String eqosids_limitation;
    private String scharvalue;
    private String scharvalue_pub_ip;
    private String amountcounter;
    private String mobiledatatopupservice;
    private String claescode;
    private String subservicetrafficvalue;
    private String trafficspeeddos;
    private String trafficspeedups;
    private String sendtobilling;
    private String sendtocommission;
    private String sendtoprepaid;
    private String nordic_euroconnect;
    private String validforcampaign;
    private String databalancefrompm;
    private String includeonconfirmation;
    private String accountingcode;
    private String financialmaterial;
    private String servicelevel1;
    private String servicelevel2;
    private String servicelevel3;

    public ServiceInformation(){
        super();
    }

    public String getId() {
        return id;
    }

    public String getServicecodeid() {
        return servicecodeid;
    }

    public void setServicecodeid(String servicecodeid) {
        this.servicecodeid = servicecodeid;
    }

    public String getServicecodetype() {
        return servicecodetype;
    }

    public void setServicecodetype(String servicecodetype) {
        this.servicecodetype = servicecodetype;
    }

    public String getServicecodeshort() {
        return servicecodeshort;
    }

    public void setServicecodeshort(String servicecodeshort) {
        this.servicecodeshort = servicecodeshort;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getServicecategory() {
        return servicecategory;
    }

    public void setServicecategory(String servicecategory) {
        this.servicecategory = servicecategory;
    }

    public String getClassification() {
        return classification;
    }

    public void setClassification(String classification) {
        this.classification = classification;
    }

    public String getSubservicetype() {
        return subservicetype;
    }

    public void setSubservicetype(String subservicetype) {
        this.subservicetype = subservicetype;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTextshort() {
        return textshort;
    }

    public void setTextshort(String textshort) {
        this.textshort = textshort;
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

    public String getSubscriptiontypecategorys() {
        return subscriptiontypecategorys;
    }

    public void setSubscriptiontypecategorys(String subscriptiontypecategorys) {
        this.subscriptiontypecategorys = subscriptiontypecategorys;
    }

    public String getCustomersegments() {
        return customersegments;
    }

    public void setCustomersegments(String customersegments) {
        this.customersegments = customersegments;
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

    public String getAllowbinding() {
        return allowbinding;
    }

    public void setAllowbinding(String allowbinding) {
        this.allowbinding = allowbinding;
    }

    public String getAllowedbindings() {
        return allowedbindings;
    }

    public void setAllowedbindings(String allowedbindings) {
        this.allowedbindings = allowedbindings;
    }

    public String getServicefamily() {
        return servicefamily;
    }

    public void setServicefamily(String servicefamily) {
        this.servicefamily = servicefamily;
    }

    public String getValueclass() {
        return valueclass;
    }

    public void setValueclass(String valueclass) {
        this.valueclass = valueclass;
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

    public String getServiceadminchannels() {
        return serviceadminchannels;
    }

    public void setServiceadminchannels(String serviceadminchannels) {
        this.serviceadminchannels = serviceadminchannels;
    }

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }

    public String getEqosid() {
        return eqosid;
    }

    public void setEqosid(String eqosid) {
        this.eqosid = eqosid;
    }

    public String getEqosid_text() {
        return eqosid_text;
    }

    public void setEqosid_text(String eqosid_text) {
        this.eqosid_text = eqosid_text;
    }

    public String getHss_esmprofileid() {
        return hss_esmprofileid;
    }

    public void setHss_esmprofileid(String hss_esmprofileid) {
        this.hss_esmprofileid = hss_esmprofileid;
    }

    public String getHss_esmprofileid_text() {
        return hss_esmprofileid_text;
    }

    public void setHss_esmprofileid_text(String hss_esmprofileid_text) {
        this.hss_esmprofileid_text = hss_esmprofileid_text;
    }

    public String getAllowance() {
        return allowance;
    }

    public void setAllowance(String allowance) {
        this.allowance = allowance;
    }

    public String getEqosids_limitation() {
        return eqosids_limitation;
    }

    public void setEqosids_limitation(String eqosids_limitation) {
        this.eqosids_limitation = eqosids_limitation;
    }

    public String getScharvalue() {
        return scharvalue;
    }

    public void setScharvalue(String scharvalue) {
        this.scharvalue = scharvalue;
    }

    public String getScharvalue_pub_ip() {
        return scharvalue_pub_ip;
    }

    public void setScharvalue_pub_ip(String scharvalue_pub_ip) {
        this.scharvalue_pub_ip = scharvalue_pub_ip;
    }

    public String getAmountcounter() {
        return amountcounter;
    }

    public void setAmountcounter(String amountcounter) {
        this.amountcounter = amountcounter;
    }

    public String getMobiledatatopupservice() {
        return mobiledatatopupservice;
    }

    public void setMobiledatatopupservice(String mobiledatatopupservice) {
        this.mobiledatatopupservice = mobiledatatopupservice;
    }

    public String getClaescode() {
        return claescode;
    }

    public void setClaescode(String claescode) {
        this.claescode = claescode;
    }

    public String getSubservicetrafficvalue() {
        return subservicetrafficvalue;
    }

    public void setSubservicetrafficvalue(String subservicetrafficvalue) {
        this.subservicetrafficvalue = subservicetrafficvalue;
    }

    public String getTrafficspeeddos() {
        return trafficspeeddos;
    }

    public void setTrafficspeeddos(String trafficspeeddos) {
        this.trafficspeeddos = trafficspeeddos;
    }

    public String getTrafficspeedups() {
        return trafficspeedups;
    }

    public void setTrafficspeedups(String trafficspeedups) {
        this.trafficspeedups = trafficspeedups;
    }

    public String getSendtobilling() {
        return sendtobilling;
    }

    public void setSendtobilling(String sendtobilling) {
        this.sendtobilling = sendtobilling;
    }

    public String getSendtocommission() {
        return sendtocommission;
    }

    public void setSendtocommission(String sendtocommission) {
        this.sendtocommission = sendtocommission;
    }

    public String getSendtoprepaid() {
        return sendtoprepaid;
    }

    public void setSendtoprepaid(String sendtoprepaid) {
        this.sendtoprepaid = sendtoprepaid;
    }

    public String getNordic_euroconnect() {
        return nordic_euroconnect;
    }

    public void setNordic_euroconnect(String nordic_euroconnect) {
        this.nordic_euroconnect = nordic_euroconnect;
    }

    public String getValidforcampaign() {
        return validforcampaign;
    }

    public void setValidforcampaign(String validforcampaign) {
        this.validforcampaign = validforcampaign;
    }

    public String getDatabalancefrompm() {
        return databalancefrompm;
    }

    public void setDatabalancefrompm(String databalancefrompm) {
        this.databalancefrompm = databalancefrompm;
    }

    public String getIncludeonconfirmation() {
        return includeonconfirmation;
    }

    public void setIncludeonconfirmation(String includeonconfirmation) {
        this.includeonconfirmation = includeonconfirmation;
    }

    public String getAccountingcode() {
        return accountingcode;
    }

    public void setAccountingcode(String accountingcode) {
        this.accountingcode = accountingcode;
    }

    public String getFinancialmaterial() {
        return financialmaterial;
    }

    public void setFinancialmaterial(String financialmaterial) {
        this.financialmaterial = financialmaterial;
    }

    public String getServicelevel1() {
        return servicelevel1;
    }

    public void setServicelevel1(String servicelevel1) {
        this.servicelevel1 = servicelevel1;
    }

    public String getServicelevel2() {
        return servicelevel2;
    }

    public void setServicelevel2(String servicelevel2) {
        this.servicelevel2 = servicelevel2;
    }

    public String getServicelevel3() {
        return servicelevel3;
    }

    public void setServicelevel3(String servicelevel3) {
        this.servicelevel3 = servicelevel3;
    }
}
