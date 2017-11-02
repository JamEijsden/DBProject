package exjobb.cache.mongo.repository.cusin_subscription;

import exjobb.cache.mongo.entity.cusin.Subscription;
import exjobb.cache.mongo.entity.mobile.MSubscriptionStripped;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.aggregation.*;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.util.Assert;

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
    public AggregationResults<MSubscriptionStripped> aggregateSubscriptionLike(String sNumber) {

        MatchOperation filterSusbcriptions = Aggregation.match(new Criteria("subscriptionnumber").regex("^"+sNumber));

        LimitOperation limit = Aggregation.limit(20);

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
                .localField("subscriptionid")
                .foreignField("subscriptionid")
                .as("SS");


        LookupOperation lookupSSA = LookupOperation.newLookup()
                .from("subscription_service_attr")
                .localField("subscriptionid")
                .foreignField("subscriptionid")
                .as("SS");

        LookupOperation lookupMS = LookupOperation.newLookup()
                .from("subscription")
                .localField("$OWNER.ownerid")
                .foreignField("subscriptionnumber")
                .as("MS");

        LookupOperation lookupMSSUBTYPE = LookupOperation.newLookup()
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
                .andExpression("subscriptionnumber").as("msdisdn")
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
                .and("$XS.mobilenumber").arrayElementAt(0).as("xtas_subscriptionnumber")
                .andExclude("_id");

        Aggregation agg = null;
        System.out.println(sNumber.equals("all"));
        if(sNumber.equals("all")){
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
                    //Aggregation.unwind("MS"),
                    lookupXS,
                    project,
                    limit

            );
        }else {
            agg = Aggregation.newAggregation(
                    filterSusbcriptions,
                    lookupCustomer,
                    Aggregation.unwind("CUSTOMER"),
                    lookupMember,
                    //Aggregation.unwind("MEMBER"),
                    lookupOwner,
                    //Aggregation.unwind("OWNER"),
                    lookupBillGrp,
                    Aggregation.unwind("BILLGRP"),
                    lookupMS,
                    //Aggregation.unwind("MS"),
                    lookupXS,
                    project,
                    limit
            );
        }


        AggregationResults<MSubscriptionStripped> aggResults = operations.aggregate(
                agg, Subscription.class, MSubscriptionStripped.class
        );

        return aggResults;
    }
}
