package exjobb.cache.mongo.entity.cusin;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by Jimmie on 10/6/2017.
 */
@Document(collection = "community_member")
public class CommunityMember {
    @Id
    private String id;

    private String communityid;

    private String memberid;

    private String memberclass;
    private String communityowner;
    private String memberinternalid;
    private String membertype;
    private String memberstatus;
    private String memberdata;
    private String createdate;
    private String nextchangedate;
    private String userid;
    private String mtime;
    private String product;
    private String validfrom;
    private String validto;

    public String getCommunityid() {
        return communityid;
    }

    public void setCommunityid(String communityid) {
        this.communityid = communityid;
    }

    public String getMemberid() {
        return memberid;
    }

    public void setMemberid(String memberid) {
        this.memberid = memberid;
    }

    public String getMemberclass() {
        return memberclass;
    }

    public void setMemberclass(String memberclass) {
        this.memberclass = memberclass;
    }

    public String getCommunityowner() {
        return communityowner;
    }

    public void setCommunityowner(String communityowner) {
        this.communityowner = communityowner;
    }

    public String getMemberinternalid() {
        return memberinternalid;
    }

    public void setMemberinternalid(String memberinternalid) {
        this.memberinternalid = memberinternalid;
    }

    public String getMembertype() {
        return membertype;
    }

    public void setMembertype(String membertype) {
        this.membertype = membertype;
    }

    public String getMemberstatus() {
        return memberstatus;
    }

    public void setMemberstatus(String memberstatus) {
        this.memberstatus = memberstatus;
    }

    public String getMemberdata() {
        return memberdata;
    }

    public void setMemberdata(String memberdata) {
        this.memberdata = memberdata;
    }

    public String getCreatedate() {
        return createdate;
    }

    public void setCreatedate(String createdate) {
        this.createdate = createdate;
    }

    public String getNextchangedate() {
        return nextchangedate;
    }

    public void setNextchangedate(String nextchangedate) {
        this.nextchangedate = nextchangedate;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getMtime() {
        return mtime;
    }

    public void setMtime(String mtime) {
        this.mtime = mtime;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getValidfrom() {
        return validfrom;
    }

    public void setValidfrom(String validfrom) {
        this.validfrom = validfrom;
    }

    public String getValidto() {
        return validto;
    }

    public void setValidto(String validto) {
        this.validto = validto;
    }
}
