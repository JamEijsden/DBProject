package exjobb.cache.mongo.entity.cusin;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by Jimmie on 10/16/2017.
 */
@Document(collection = "subscription_service_attr")
public class SubscriptionServiceAttr {

    @Id
    private String id;

    private String subscriptionid;
    private String clientsystem;
    private String extracardsubscriptionid;
    private String servicecode;
    private String attributename;
    private String attributevalue;
    private String attributedescription;
    private String eventnumber;
    private String userid;
    private String userchangedate;
    private String changetime;
    private String entityobjid;
    private String subscrentityobjid;

    public SubscriptionServiceAttr(){
        super();
    }

    public String getId() {
        return id;
    }

    public String getSubscriptionid() {
        return subscriptionid;
    }

    public void setSubscriptionid(String subscriptionid) {
        this.subscriptionid = subscriptionid;
    }

    public String getClientsystem() {
        return clientsystem;
    }

    public void setClientsystem(String clientsystem) {
        this.clientsystem = clientsystem;
    }

    public String getExtracardsubscriptionid() {
        return extracardsubscriptionid;
    }

    public void setExtracardsubscriptionid(String extracardsubscriptionid) {
        this.extracardsubscriptionid = extracardsubscriptionid;
    }

    public String getServicecode() {
        return servicecode;
    }

    public void setServicecode(String servicecode) {
        this.servicecode = servicecode;
    }

    public String getAttributename() {
        return attributename;
    }

    public void setAttributename(String attributename) {
        this.attributename = attributename;
    }

    public String getAttributevalue() {
        return attributevalue;
    }

    public void setAttributevalue(String attributevalue) {
        this.attributevalue = attributevalue;
    }

    public String getAttributedescription() {
        return attributedescription;
    }

    public void setAttributedescription(String attributedescription) {
        this.attributedescription = attributedescription;
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

    public String getEntityobjid() {
        return entityobjid;
    }

    public void setEntityobjid(String entityobjid) {
        this.entityobjid = entityobjid;
    }

    public String getSubscrentityobjid() {
        return subscrentityobjid;
    }

    public void setSubscrentityobjid(String subscrentityobjid) {
        this.subscrentityobjid = subscrentityobjid;
    }
}
