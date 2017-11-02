package exjobb.cache.mongo.entity.cusin;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by Jimmie on 10/16/2017.
 */
@Document(collection = "subscription_service")
public class SubscriptionService {

    @Id
    private String id;

    private String subscriptionid;
    private String clientsystem;
    private String extracardsubscriptionid;
    private String servicecode;
    private String servicevalue;
    private String servicedescription;
    private String servicespecificnumber;
    private String servicenetwork;
    private String servicestatus;
    private String activationdate;
    private String deactivationdate;
    private String eventnumber;
    private String userid;
    private String userchangedate;
    private String changetime;
    private String entityobjid;
    private String subscrentityobjid;

    public SubscriptionService(){
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

    public String getServicevalue() {
        return servicevalue;
    }

    public void setServicevalue(String servicevalue) {
        this.servicevalue = servicevalue;
    }

    public String getServicedescription() {
        return servicedescription;
    }

    public void setServicedescription(String servicedescription) {
        this.servicedescription = servicedescription;
    }

    public String getServicespecificnumber() {
        return servicespecificnumber;
    }

    public void setServicespecificnumber(String servicespecificnumber) {
        this.servicespecificnumber = servicespecificnumber;
    }

    public String getServicenetwork() {
        return servicenetwork;
    }

    public void setServicenetwork(String servicenetwork) {
        this.servicenetwork = servicenetwork;
    }

    public String getServicestatus() {
        return servicestatus;
    }

    public void setServicestatus(String servicestatus) {
        this.servicestatus = servicestatus;
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
