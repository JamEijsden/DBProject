package exjobb.cache.mongo.repository.cusin_subscription;

import exjobb.cache.mongo.entity.cusin.Subscription;
import exjobb.cache.mongo.entity.mobile.MSubscriptionStripped;
import exjobb.cache.mongo.entity.mobile.MobileSubscription;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.aggregation.*;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.util.Assert;
import java.util.List;

/**
 * Created by Jimmie on 10/6/2017.
 */
@RepositoryRestResource(collectionResourceRel = "subscription", path = "subscription")
public class CSubscriptionRepositoryImpl implements CustomCSubscriptionRepository {
    private final MongoOperations operations;

    @Autowired
    public CSubscriptionRepositoryImpl(MongoOperations operations) {

        Assert.notNull(operations, "MongoOperations must not be null!");
        this.operations = operations;
    }

    @Override
    public List<?> aggregateSubscription(String keyword, String key,
                                                 String type, Integer page,
                                                 Boolean stripped) {
        key = key.equals("msisdn") ? "subscriptionnumber" : key;

        MatchOperation filterSusbcriptions;
        switch (type){
            case "equals":
                filterSusbcriptions = Aggregation.match(new Criteria(key).is(keyword));
                break;
            case "gt":
                filterSusbcriptions = Aggregation.match(new Criteria(key).gt(keyword));
                break;
            case "gte":
                filterSusbcriptions = Aggregation.match(new Criteria(key).gte(keyword));
                break;
            case "lt":
                filterSusbcriptions = Aggregation.match(new Criteria(key).lt(keyword));
                break;
            case "lte":
                filterSusbcriptions = Aggregation.match(new Criteria(key).lte(keyword));
                break;
            default:
                filterSusbcriptions = Aggregation.match(new Criteria(key).regex("^"+keyword));
                break;
        }

        //Criteria c = new Criteria().orOperator(Criteria.where("subscriptionnumber").regex("^"+keyword), Criteria.where("customernumber").regex("^"+keyword), Criteria.where("subscriptionid").regex("^"+keyword));
        //MatchOperation filterSusbcriptions = Aggregation.match(c);
        SkipOperation skip = Aggregation.skip(new Long(page*15));
        LimitOperation limit = Aggregation.limit(15);

        LookupOperation lookupCustomer = LookupOperation.newLookup()
                .from("customer")
                .localField("customernumber")
                .foreignField("customernumber")
                .as("CUSTOMER");

        LookupOperation lookupMember = LookupOperation.newLookup()
                .from("community_member")
                .localField("subscriptionnumber")
                .foreignField("memberid")
                .as("MEMBER");

        LookupOperation lookupOwner = LookupOperation.newLookup()
                .from("community_owner")
                .localField("$MEMBER.communityid")
                .foreignField("communityid")
                .as("OWNER");

        LookupOperation lookupSubtype = LookupOperation.newLookup()
                .from("subscriptiontypeinformation")
                .localField("subscriptiontype")
                .foreignField("subscriptiontypecode")
                .as("SUBTYPE");

        LookupOperation lookupSS = LookupOperation.newLookup()
                .from("subscription_service")
                .localField("subid_and_extracardsubid")
                .foreignField("subid_and_extracardsubid")
                .as("SS");


        LookupOperation lookupSSA = LookupOperation.newLookup()
                .from("subscription_service_attr")
                .localField("subid_and_extracardsubid")
                .foreignField("subid_and_extracardsubid")
                .as("SSA");

        LookupOperation lookupMS = LookupOperation.newLookup()
                .from("subscription")
                .localField("$OWNER.ownerid")
                .foreignField("subscriptionnumber")
                .as("MS");

        LookupOperation lookupMS_STI= LookupOperation.newLookup()
                .from("subscriptiontypeinformation")
                .localField("$MS.subscriptiontype")
                .foreignField("subscriptiontypecode")
                .as("MS_STI");

        LookupOperation lookupBillGrp= LookupOperation.newLookup()
                .from("billgrp")
                .localField("billentityobjid")
                .foreignField("entityobjid")
                .as("BILLGRP");

        LookupOperation lookupXS= LookupOperation.newLookup()
                .from("xtas_subscription")
                .localField("subscriptionnumber")
                .foreignField("mobilenumber")
                .as("XS");

        LookupOperation lookupSI= LookupOperation.newLookup()
                .from("serviceinformation")
                .localField("$SS.servicecode")
                .foreignField("servicecodeid")
                .as("SI");

        ProjectionOperation project = Aggregation
                .project()
                .andInclude("subscriptionnumber", "subscriptionid", "extracardsubscriptionid")
                .and("$CUSTOMER.customeridentificationnumber").as("customeridentificationnumber")
                .and("$CUSTOMER.customertype").as("customertype")
                .and("$MEMBER.communityowner").arrayElementAt(0).as("communityowner")
                .andExpression("\"mobilesubscription:\"").concat("$subscriptionnumber").as("c2bcacheuid")
                .andExpression("$subscriptionnumber").as("msisdn")
                .andInclude("customernumber",
                        "subscriptiontype",
                        "subscriptiontypecategory",
                        "paymentmethod",
                        "brandid",
                        "branddescription",
                        "activationdate",
                        "trafficstatuscode",
                        "trafficdescription",
                        "subscriptionstatus",
                        "trafficstatusreason",
                        "customertargetsegment",
                        "multisubscriptionnumber",
                        "billentityobjid",
                        "referencetextonbill",
                        "agreementnumber"
                )
                .and("$address.name").as("sub_name1")
                .and("$address.name2").as("sub_name2")
                .and("$address.name3").as("sub_name3")
                .and("$address.addressrow1").as("sub_addressrow1")
                .and("$address.addressrow2").as("sub_addressrow2")
                .and("$address.addressrow3").as("sub_addressrow3")
                .and("$address.city").as("sub_city")
                .and("$address.zipcode").as("sub_zipcode")
                .and("$SS.servicecode").allElementsInArrayTrue().as("servicecode")
                /*.and("$SS.servicevalue").as("servicevalue")
                .and("$SSA.attributename").as("attributename")
                .and("$SSA.attributevalue").as("attributevalue")
                .and("$SI.invoicetext").as("invoicetext")
                .and("$SI.allowance").as("allowance")
                */.and("$XS.mobilenumber").arrayElementAt(0).as("xtas_subscriptionnumber")
                .and("$SUBTYPE.invoicetext").as("offeringname")
                .and("$BILLGRP.accountnumber").as("accountnumber")
                .and("$BILLGRP.invoicedeliverymethod").as("invoicedeliverymethod")
                .and("$BILLGRP.invoicedeliverymethoddescr").as("invoicedeliverymethoddescr")
                .and("$BILLGRP.billgroupid").as("billingroupid")
                .and("$BILLGRP.address.name").as("bg_name1")
                .and("$BILLGRP.address.name2").as("bg_name2")
                .and("$BILLGRP.address.name3").as("bg_name3")
                .and("$BILLGRP.address.addressrow1").as("bg_addressrow1")
                .and("$BILLGRP.address.addressrow2").as("bg_addressrow2")
                .and("$BILLGRP.address.addressrow3").as("bg_addressrow3")
                .and("$BILLGRP.address.city").as("bg_city")
                .and("$BILLGRP.address.zipcode").as("bg_zipcode")
                .and("$CUSTOMER.address.name").as("cus_name1")
                .and("$CUSTOMER.address.name2").as("cus_name2")
                .and("$CUSTOMER.address.name3").as("cus_name3")
                .and("$CUSTOMER.address.addressrow1").as("cus_addressrow1")
                .and("$CUSTOMER.address.addressrow2").as("cus_addressrow2")
                .and("$CUSTOMER.address.addressrow3").as("cus_addressrow3")
                .and("$CUSTOMER.address.city").as("cus_city")
                .and("$CUSTOMER.address.zipcode").as("cus_zipcode")
                .and("$MEMBER.communityowner").arrayElementAt(0).as("communityowner")
                .and("$OWNER.ownerid").arrayElementAt(0).as("ownerid")
                .andInclude(
                        "retailernumber",
                        "supervisionlevel",
                        "supervisionstatus",
                        "supervisiondate"
                 )
                .and("$MS.subscriptiontype").arrayElementAt(0).as("multisubscriptiontype")
                .and("$MS.subscriptiontypecategory").arrayElementAt(0).as("multisubscriptiontypecategory")
                .and("$MS_STI.invoicetext").arrayElementAt(0).as("multisubscriptiontypedescr")
                .andExclude("_id");

        Aggregation agg = null;
        if(keyword.equals("all")){
            System.out.println("Aggregation all");
            agg = Aggregation.newAggregation(
                    lookupCustomer,
                    Aggregation.unwind("CUSTOMER"),
                    lookupMember,
                    //Aggregation.unwind("MEMBER"),
                    lookupOwner,
                    //Aggregation.unwind("OWNER"),
                    lookupSubtype,
                    Aggregation.unwind("SUBTYPE"),
                    lookupBillGrp,
                    Aggregation.unwind("BILLGRP"),
                    lookupMS,
                    lookupMS_STI,
                    lookupXS,
                    lookupSS,
                    lookupSSA,
                    lookupSI,

                    project,

                    skip,
                    limit

            );
        }else {
            System.out.println("Aggregating " + keyword);
            agg = Aggregation.newAggregation(
                    filterSusbcriptions,
                    lookupCustomer,
                    Aggregation.unwind("CUSTOMER"),
                    lookupMember,
                    //Aggregation.unwind("MEMBER"),
                    lookupOwner,
                    //Aggregation.unwind("OWNER"),
                    lookupSubtype,
                    Aggregation.unwind("SUBTYPE"),
                    lookupBillGrp,
                    Aggregation.unwind("BILLGRP"),
                    lookupMS,
                    lookupMS_STI,
                    lookupXS,
                    lookupSS,
                    lookupSSA,
                    lookupSI,

                    project,

                    skip,
                    limit
            );
        }

        AggregationResults<?> aggResults = stripped
                ?
                    operations.aggregate(
                            agg, Subscription.class, MSubscriptionStripped.class
                    )
                :
                    operations.aggregate(
                            agg, Subscription.class, MobileSubscription.class
                    );

        return aggResults.getMappedResults();
    }
}
