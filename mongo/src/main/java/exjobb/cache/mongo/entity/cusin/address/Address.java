package exjobb.cache.mongo.entity.cusin.address;

import org.springframework.data.annotation.Id;

/**
 * Created by Jimmie on 10/6/2017.
 */
public class Address {

    @Id
    private String id;
    private String addressrow1;
    private String addressrow2;
    private String addressrow3;
    private String zipcode;
    private String city;
    private String country;
    private String name;
    private String name2;
    private String name3;
    private String eventnumber;
    private String entityid;


    public String getId() {
        return id;
    }

    public String getAddressrow1() {
        return addressrow1;
    }

    public void setAddressrow1(String addressrow1) {
        this.addressrow1 = addressrow1;
    }

    public String getAddressrow2() {
        return addressrow2;
    }

    public void setAddressrow2(String addressrow2) {
        this.addressrow2 = addressrow2;
    }

    public String getAddressrow3() {
        return addressrow3;
    }

    public void setAddressrow3(String addressrow3) {
        this.addressrow3 = addressrow3;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName2() {
        return name2;
    }

    public void setName2(String name2) {
        this.name2 = name2;
    }

    public String getName3() {
        return name3;
    }

    public void setName3(String name3) {
        this.name3 = name3;
    }

    public String getEventnumber() {
        return eventnumber;
    }

    public void setEventnumber(String eventnumber) {
        this.eventnumber = eventnumber;
    }

    public String getEntityid() {
        return entityid;
    }

    public void setEntityid(String entityid) {
        this.entityid = entityid;
    }
}
