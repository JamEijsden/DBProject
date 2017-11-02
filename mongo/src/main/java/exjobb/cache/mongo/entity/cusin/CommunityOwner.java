package exjobb.cache.mongo.entity.cusin;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by Jimmie on 10/6/2017.
 */
@Document(collection = "community_owner")
public class CommunityOwner {
    @Id
    private String id;

    private String communityid;
    private String ownerid;
    private String ownerclass;
    private String owneridtype;
    private String ownertype;
    private String ownerinternalid;

    public String getId() {
        return id;
    }

    public String getCommunityid() {
        return communityid;
    }

    public void setCommunityid(String communityid) {
        this.communityid = communityid;
    }

    public String getOwnerid() {
        return ownerid;
    }

    public void setOwnerid(String ownerid) {
        this.ownerid = ownerid;
    }

    public String getOwnerclass() {
        return ownerclass;
    }

    public void setOwnerclass(String ownerclass) {
        this.ownerclass = ownerclass;
    }

    public String getOwneridtype() {
        return owneridtype;
    }

    public void setOwneridtype(String owneridtype) {
        this.owneridtype = owneridtype;
    }

    public String getOwnertype() {
        return ownertype;
    }

    public void setOwnertype(String ownertype) {
        this.ownertype = ownertype;
    }

    public String getOwnerinternalid() {
        return ownerinternalid;
    }

    public void setOwnerinternalid(String ownerinternalid) {
        this.ownerinternalid = ownerinternalid;
    }
}
