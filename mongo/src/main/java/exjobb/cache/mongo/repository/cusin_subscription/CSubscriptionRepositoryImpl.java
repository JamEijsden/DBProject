package exjobb.cache.mongo.repository.cusin_subscription;

import exjobb.cache.mongo.entity.SearchOptions;
import exjobb.cache.mongo.entity.cusin.Customer;
import exjobb.cache.mongo.entity.cusin.Subscription;
import exjobb.cache.mongo.entity.mobile.MSubscriptionStripped;
import exjobb.cache.mongo.entity.mobile.MobileSubscription;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.aggregation.*;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.util.CloseableIterator;
import org.springframework.util.Assert;

import java.util.*;

/**
 * Created by Jimmie on 10/6/2017.
 */
@RepositoryRestResource(collectionResourceRel = "cusin_subscription", path = "cusin_subscription")
public class CSubscriptionRepositoryImpl implements CustomCSubscriptionRepository {
    private final MongoOperations operations;

    private Map<String, ProjectionOperation> keyProject = new HashMap();
    private Map<String, List<AggregationOperation>> keyLookup = new HashMap();
    private Map<String, String> fieldMap;

    @Autowired
    public CSubscriptionRepositoryImpl(MongoOperations operations) {

        Assert.notNull(operations, "MongoOperations must not be null!");
        this.operations = operations;
        initFieldMap();
        initHashMaps();
    }

    private void initHashMaps(){
        this.keyProject.put("subscriptionnumber", getSubscriptionProjection());
        this.keyProject.put("tscid", getCommonCustomerProjection());
        this.keyProject.put("customeridentificationnumber", getCustomerProjection());

        this.keyLookup.put("subscriptionnumber", getSubscriptionLookupOperations());
        this.keyLookup.put("tscid", getCommonCustomerLookupOperations());
        this.keyLookup.put("customeridentificationnumber", getCustomerLookupOperations());
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

        LookupOperation lookupBillGrp= LookupOperation.newLookup()
                .from("billgrp")
                .localField("billentityobjid")
                .foreignField("entityobjid")
                .as("BILLGRP");

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
                //.and("$SS.servicecode").allElementsInArrayTrue().as("servicecode")
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
                    //lookupSS,
                    //lookupSSA,
                    //lookupSI,

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

    private MatchOperation getMatchOp(String key, String value, String type){
        switch (type){
            case "like":
               return Aggregation.match(
                        new Criteria(key)
                                .regex("^"+value));
            case "gt":
                return Aggregation.match(
                        new Criteria(key)
                                .gt(value));
            case "gte":
                return Aggregation.match(
                        new Criteria(key)
                                .gte(value));
            case "lt":
                return Aggregation.match(
                        new Criteria(key)
                                .lt(value));
            case "lte":
                return Aggregation.match(
                        new Criteria(key)
                                .lte(value));
            default:
                return Aggregation.match(
                        new Criteria(key)
                                .is(value));
        }
    }


    @Override
    public List<MobileSubscription> getSubscriptions(SearchOptions opt) {
        List<MobileSubscription> result = new ArrayList<>();
        Set<String> subs = new HashSet<>();
        List<AggregationOperation> lookupOps;
        List<AggregationOperation> aggOps;

        if(opt.getKeys().isEmpty()) opt.getKeys().add("msisdn");
        for(String k : opt.getKeys()) {
            aggOps = new ArrayList();

            MatchOperation filter = getMatchOp(k, opt.getValue(), opt.getType());

            Boolean getAllFields = opt.getFields().isEmpty();
            ProjectionOperation project = new ProjectionOperation()
                    .andExclude("_id")
                    .and("subscriptionnumber").as("msisdn")
                    .andInclude("$CUSTOMER.customeridentificationnumber");

            if(!getAllFields) {
                //if(!opt.getFields().contains("$SUBSCRIPTION.subscriptionnumber")) project = project.and("$SUBSCRIPTION.subscriptionnumber").as("msisdn");
                for(String field : opt.getFields()) {
                    System.out.println(field);
                    project = project.and(this.fieldMap.get(field)).as(field);
                }
            } else {
                project = this.keyProject.get(k);
            }

            SkipOperation skip = Aggregation.skip(new Long(opt.getPage()*15));
            LimitOperation limit = Aggregation.limit(opt.getLimit());

            if(!k.isEmpty()) aggOps.add(filter);
            aggOps.addAll(this.keyLookup.get(k));
            aggOps.add(limit);
            aggOps.add(skip);
            aggOps.add(project);

            Aggregation agg = Aggregation.newAggregation(aggOps);
            List<MobileSubscription> tmp;
            switch(k){
                case "subscriptionnumber":
                    tmp = operations.aggregate(agg, Subscription.class, MobileSubscription.class).getMappedResults();
                    for( MobileSubscription ms : tmp ) {
                        if( subs.add( ms.getMsisdn() )) {
                            result.add( ms );
                        }
                    }
                    break;
                case "tscid":
                    tmp = operations.aggregate(agg, "common_customer", MobileSubscription.class).getMappedResults();
                    for( MobileSubscription ms : tmp ) {
                        if( subs.add( ms.getMsisdn() )) {
                            result.add( ms );
                        }
                    }
                    break;
                case "customeridentificationnumber":
                    tmp = operations.aggregate(agg, Customer.class, MobileSubscription.class).getMappedResults();
                    for( MobileSubscription ms : tmp ) {
                        if( subs.add( ms.getMsisdn() )) {
                            result.add( ms );
                        }
                    }
                    break;
            }
        }
        System.out.println("Resultset count: " + result.size());
        return result;
    }

    public List<MobileSubscription> streamSubscriptions(SearchOptions opt) {
        Integer mongoCursorBatchSize = 50;

        MatchOperation filter = Aggregation.match(new Criteria());
        if(!opt.getKeys().get(0).equals("customeridentificationnumber"))
            filter = getMatchOp(opt.getKeys().get(0), opt.getValue(), opt.getType());



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

        LookupOperation lookupBillGrp= LookupOperation.newLookup()
                .from("billgrp")
                .localField("billentityobjid")
                .foreignField("entityobjid")
                .as("BILLGRP");

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

        LookupOperation lookupCommonCustomer = LookupOperation.newLookup()
                .from("common_customer")
                .localField("CUSTOMER.cin_type")
                .foreignField("cin_pt")
                .as("COMMON_CUSTOMER");

        Boolean getAllFields = opt.getFields().isEmpty();


        ProjectionOperation project = getSubscriptionProjection();
        if(!getAllFields) {
            if(!opt.getFields().contains("subscriptionnumber")) project = project.and("$subscriptionnumber").as("msisdn");
            for(String field : opt.getFields()) {
                System.out.println(field);
                project = project.and(this.fieldMap.get(field)).as(field);
            }
        }


        SkipOperation skip = Aggregation.skip(new Long(opt.getPage()*15));
        LimitOperation limit = Aggregation.limit(opt.getLimit());

        AggregationOptions aggOpt = Aggregation.newAggregationOptions()
                // this is very important: if you do not set the batch size, you'll get all the objects at once and you might run out of memory if the returning data set is too large
                .build();


        Aggregation agg = Aggregation.newAggregation(
                filter,
                skip,
                //limit,
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
                lookupCommonCustomer,
                lookupMS,
                lookupMS_STI,
                lookupXS,
                lookupSS,
                lookupSSA,
                lookupSI,
                project
        ).withOptions(aggOpt);
        CloseableIterator<MobileSubscription> stream =operations.aggregateStream(
                agg, Subscription.class, MobileSubscription.class);
        Integer i = 0;
        while(stream.hasNext() && i != 5){
            MobileSubscription sub = stream.next();
            if(opt.getValue().equals(sub.getCustomeridentificationnumber())){
                System.out.println(sub);
                i++;
            }
        }

        return null;
    }



    private ProjectionOperation getSubscriptionProjection(){
        System.out.println("Subscription");
        return Aggregation
                .project()
                .andInclude("subscriptionid", "extracardsubscriptionid", "$COMMON_CUSTOMER.tscid")
                .and("$CUSTOMER.customeridentificationnumber").as("customeridentificationnumber")
                .and("$CUSTOMER.customertype").as("customertype")
                .and("$MEMBER.communityowner").arrayElementAt(0).as("communityowner")
                .andExpression("\"mobilesubscription:\"").concat("$subscriptionnumber").as("c2bcacheuid")
                .and("$subscriptionnumber").as("msisdn")
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
                .and("$SS.servicecode").as("servicecode")
                .and("$SS.servicevalue").as("servicevalue")
                .and("$SSA.attributename").as("attributename")
                .and("$SSA.attributevalue").as("attributevalue")
                .and("$SI.invoicetext").as("serviceinvoicetext")
                .and("$SI.allowance").as("serviceallowance")
                .and("$XS.mobilenumber").arrayElementAt(0).as("xtas_subscriptionnumber")
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
    }
    private ProjectionOperation getCustomerProjection(){
    return Aggregation.project()
            .and("$SUBSCRIPTION.subscriptionid").as("subscriptionid")
            .and("$SUBSCRIPTION.extracardsubscriptionid").as("extracardsubscriptionid")
            .andInclude("customeridentificationnumber", "customertype", "customernumber", "$COMMON_CUSTOMER.tscid")
            .and("$MEMBER.communityowner").arrayElementAt(0).as("communityowner")
            .andExpression("\"mobilesubscription:\"").concat("$SUBSCRIPTION.subscriptionnumber").as("c2bcacheuid")
            .and("$SUBSCRIPTION.subscriptionnumber").as("msisdn")
            .and("$SUBSCRIPTION.subscriptiontype").as("subscriptiontype")
            .and("$SUBSCRIPTION.subscriptiontypecategory").as("subscriptiontypecategory")
            .and("$SUBSCRIPTION.paymentmethod").as("paymentmethod")
            .and("$SUBSCRIPTION.brandid").as("brandid")
            .and("$SUBSCRIPTION.branddescription").as("branddescription")
            .and("$SUBSCRIPTION.activationdate").as("activationdate")
            .and("$SUBSCRIPTION.trafficstatuscode").as("trafficstatuscode")
            .and("$SUBSCRIPTION.trafficdescription").as("trafficdescription")
            .and("$SUBSCRIPTION.subscriptionstatus").as("subscriptionstatus")
            .and("$SUBSCRIPTION.trafficstatusreason").as("trafficstatusreason")
            .and("$SUBSCRIPTION.customertargetsegment").as("customertargetsegment")
            .and("$SUBSCRIPTION.multisubscriptionnumber").as("multisubscriptionnumber")
            .and("$SUBSCRIPTION.billentityobjid").as("billentityobjid")
            .and("$SUBSCRIPTION.referencetextonbill").as("referencetextonbill")
            .and("$SUBSCRIPTION.agreementnumber").as("agreementnumber")
            .and("$SUBSCRIPTION.address.name").as("sub_name1")
            .and("$SUBSCRIPTION.address.name2").as("sub_name2")
            .and("$SUBSCRIPTION.address.name3").as("sub_name3")
            .and("$SUBSCRIPTION.address.addressrow1").as("sub_addressrow1")
            .and("$SUBSCRIPTION.address.addressrow2").as("sub_addressrow2")
            .and("$SUBSCRIPTION.address.addressrow3").as("sub_addressrow3")
            .and("$SUBSCRIPTION.address.city").as("sub_city")
            .and("$SUBSCRIPTION.address.zipcode").as("sub_zipcode")
            .and("$SS.servicecode").as("servicecode")
            .and("$SS.servicevalue").as("servicevalue")
            .and("$SSA.attributename").as("attributename")
            .and("$SSA.attributevalue").as("attributevalue")
            .and("$SI.invoicetext").as("invoicetext")
            .and("$SI.allowance").as("allowance")
            .and("$XS.mobilenumber").arrayElementAt(0).as("xtas_subscriptionnumber")
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
            .and("$address.name").as("cus_name1")
            .and("$address.name2").as("cus_name2")
            .and("$address.name3").as("cus_name3")
            .and("$address.addressrow1").as("cus_addressrow1")
            .and("$address.addressrow2").as("cus_addressrow2")
            .and("$address.addressrow3").as("cus_addressrow3")
            .and("$address.city").as("cus_city")
            .and("$address.zipcode").as("cus_zipcode")
            .and("$MEMBER.communityowner").arrayElementAt(0).as("communityowner")
            .and("$OWNER.ownerid").arrayElementAt(0).as("ownerid")
            .and("$SUBSCRIPTION.retailernumber").as("retailernumber")
            .and("$SUBSCRIPTION.supervisionlevel").as("supervisionlevel")
            .and("$SUBSCRIPTION.supervisionstatus").as("supervisionstatus")
            .and("$SUBSCRIPTION.supervisiondate").as("supervisiondate")
            .and("$MS.subscriptiontype").arrayElementAt(0).as("multisubscriptiontype")
            .and("$MS.subscriptiontypecategory").arrayElementAt(0).as("multisubscriptiontypecategory")
            .and("$MS_STI.invoicetext").arrayElementAt(0).as("multisubscriptiontypedescr")
            .andExclude("_id");
}
    private ProjectionOperation getCommonCustomerProjection(){
    return Aggregation.project()
            .and("$SUBSCRIPTION.subscriptionid").as("subscriptionid")
            .and("$SUBSCRIPTION.extracardsubscriptionid").as("extracardsubscriptionid")
            .andInclude("customeridentificationnumber", "$CUSTOMER.customertype", "$CUSTOMER.customernumber", "tscid")
            .and("$MEMBER.communityowner").arrayElementAt(0).as("communityowner")
            .andExpression("\"mobilesubscription:\"").concat("$SUBSCRIPTION.subscriptionnumber").as("c2bcacheuid")
            .and("$SUBSCRIPTION.subscriptionnumber").as("msisdn")
            .and("$SUBSCRIPTION.subscriptiontype").as("subscriptiontype")
            .and("$SUBSCRIPTION.subscriptiontypecategory").as("subscriptiontypecategory")
            .and("$SUBSCRIPTION.paymentmethod").as("paymentmethod")
            .and("$SUBSCRIPTION.brandid").as("brandid")
            .and("$SUBSCRIPTION.branddescription").as("branddescription")
            .and("$SUBSCRIPTION.activationdate").as("activationdate")
            .and("$SUBSCRIPTION.trafficstatuscode").as("trafficstatuscode")
            .and("$SUBSCRIPTION.trafficdescription").as("trafficdescription")
            .and("$SUBSCRIPTION.subscriptionstatus").as("subscriptionstatus")
            .and("$SUBSCRIPTION.trafficstatusreason").as("trafficstatusreason")
            .and("$SUBSCRIPTION.customertargetsegment").as("customertargetsegment")
            .and("$SUBSCRIPTION.multisubscriptionnumber").as("multisubscriptionnumber")
            .and("$SUBSCRIPTION.billentityobjid").as("billentityobjid")
            .and("$SUBSCRIPTION.referencetextonbill").as("referencetextonbill")
            .and("$SUBSCRIPTION.agreementnumber").as("agreementnumber")
            .and("$SUBSCRIPTION.address.name").as("sub_name1")
            .and("$SUBSCRIPTION.address.name2").as("sub_name2")
            .and("$SUBSCRIPTION.address.name3").as("sub_name3")
            .and("$SUBSCRIPTION.address.addressrow1").as("sub_addressrow1")
            .and("$SUBSCRIPTION.address.addressrow2").as("sub_addressrow2")
            .and("$SUBSCRIPTION.address.addressrow3").as("sub_addressrow3")
            .and("$SUBSCRIPTION.address.city").as("sub_city")
            .and("$SUBSCRIPTION.address.zipcode").as("sub_zipcode")
            .and("$SS.servicecode").as("servicecode")
            .and("$SS.servicevalue").as("servicevalue")
            .and("$SSA.attributename").as("attributename")
            .and("$SSA.attributevalue").as("attributevalue")
            .and("$SI.invoicetext").as("invoicetext")
            .and("$SI.allowance").as("allowance")
            .and("$XS.mobilenumber").arrayElementAt(0).as("xtas_subscriptionnumber")
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
            .and("$SUBSCRIPTION.retailernumber").as("retailernumber")
            .and("$SUBSCRIPTION.supervisionlevel").as("supervisionlevel")
            .and("$SUBSCRIPTION.supervisionstatus").as("supervisionstatus")
            .and("$SUBSCRIPTION.supervisiondate").as("supervisiondate")
            .and("$MS.subscriptiontype").arrayElementAt(0).as("multisubscriptiontype")
            .and("$MS.subscriptiontypecategory").arrayElementAt(0).as("multisubscriptiontypecategory")
            .and("$MS_STI.invoicetext").arrayElementAt(0).as("multisubscriptiontypedescr")
            .andExclude("_id");
}
    private List<AggregationOperation> getSubscriptionLookupOperations(){

        List<AggregationOperation> lookupOps = new ArrayList<>();

        LookupOperation lookupCustomer = LookupOperation.newLookup()
                .from("customer")
                .localField("customernumber")
                .foreignField("customernumber")
                .as("CUSTOMER");
        lookupOps.add(lookupCustomer);
        lookupOps.add(Aggregation.unwind("CUSTOMER"));

        LookupOperation lookupCommonCustomer = LookupOperation.newLookup()
                .from("common_customer")
                .localField("CUSTOMER.cin_type")
                .foreignField("cin_pt")
                .as("COMMON_CUSTOMER");
        lookupOps.add(lookupCommonCustomer);

        LookupOperation lookupMember = LookupOperation.newLookup()
                .from("community_member")
                .localField("subscriptionnumber")
                .foreignField("memberid")
                .as("MEMBER");
        lookupOps.add(lookupMember);

        LookupOperation lookupOwner = LookupOperation.newLookup()
                .from("community_owner")
                .localField("$MEMBER.communityid")
                .foreignField("communityid")
                .as("OWNER");
        lookupOps.add(lookupOwner);

        LookupOperation lookupSubtype = LookupOperation.newLookup()
                .from("subscriptiontypeinformation")
                .localField("subscriptiontype")
                .foreignField("subscriptiontypecode")
                .as("SUBTYPE");
        lookupOps.add(lookupSubtype);
        lookupOps.add(Aggregation.unwind("SUBTYPE"));

        LookupOperation lookupBillGrp= LookupOperation.newLookup()
                .from("billgrp")
                .localField("billentityobjid")
                .foreignField("entityobjid")
                .as("BILLGRP");
        lookupOps.add(lookupBillGrp);
        lookupOps.add(Aggregation.unwind("BILLGRP"));

        LookupOperation lookupSS = LookupOperation.newLookup()
                .from("subscription_service")
                .localField("subid_and_extracardsubid")
                .foreignField("subid_and_extracardsubid")
                .as("SS");
        lookupOps.add(lookupSS);

        LookupOperation lookupSSA = LookupOperation.newLookup()
                .from("subscription_service_attr")
                .localField("subid_and_extracardsubid")
                .foreignField("subid_and_extracardsubid")
                .as("SSA");
        lookupOps.add(lookupSSA);

        LookupOperation lookupMS = LookupOperation.newLookup()
                .from("subscription")
                .localField("$OWNER.ownerid")
                .foreignField("subscriptionnumber")
                .as("MS");
        lookupOps.add(lookupMS);

        LookupOperation lookupMS_STI= LookupOperation.newLookup()
                .from("subscriptiontypeinformation")
                .localField("$MS.subscriptiontype")
                .foreignField("subscriptiontypecode")
                .as("MS_STI");
        lookupOps.add(lookupMS_STI);

        LookupOperation lookupXS= LookupOperation.newLookup()
                .from("xtas_subscription")
                .localField("subscriptionnumber")
                .foreignField("mobilenumber")
                .as("XS");
        lookupOps.add(lookupXS);

        LookupOperation lookupSI= LookupOperation.newLookup()
                .from("serviceinformation")
                .localField("$SS.servicecode")
                .foreignField("servicecodeid")
                .as("SI");
        lookupOps.add(lookupSI);

        return lookupOps;
    }
    private List<AggregationOperation> getCustomerLookupOperations(){

        List<AggregationOperation> lookupOps = new ArrayList<>();

        LookupOperation lookupCommonCustomer = LookupOperation.newLookup()
                .from("common_customer")
                .localField("cin_type")
                .foreignField("cin_pt")
                .as("COMMON_CUSTOMER");
        lookupOps.add(lookupCommonCustomer);

        LookupOperation lookupSubscription = LookupOperation.newLookup()
                .from("cusin_subscription")
                .localField("customernumber")
                .foreignField("customernumber")
                .as("SUBSCRIPTION");
        lookupOps.add(lookupSubscription);
        lookupOps.add(Aggregation.unwind("SUBSCRIPTION"));

        LookupOperation lookupMember = LookupOperation.newLookup()
                .from("community_member")
                .localField("$SUBSCRIPTION.subscriptionnumber")
                .foreignField("memberid")
                .as("MEMBER");
        lookupOps.add(lookupMember);

        LookupOperation lookupOwner = LookupOperation.newLookup()
                .from("community_owner")
                .localField("$MEMBER.communityid")
                .foreignField("communityid")
                .as("OWNER");
        lookupOps.add(lookupOwner);

        LookupOperation lookupSubtype = LookupOperation.newLookup()
                .from("subscriptiontypeinformation")
                .localField("$SUBSCRIPTION.subscriptiontype")
                .foreignField("subscriptiontypecode")
                .as("SUBTYPE");
        lookupOps.add(lookupSubtype);
        lookupOps.add(Aggregation.unwind("SUBTYPE"));

        LookupOperation lookupBillGrp= LookupOperation.newLookup()
                .from("billgrp")
                .localField("$SUBSCRIPTION.billentityobjid")
                .foreignField("entityobjid")
                .as("BILLGRP");
        lookupOps.add(lookupBillGrp);
        lookupOps.add(Aggregation.unwind("BILLGRP"));

        LookupOperation lookupSS = LookupOperation.newLookup()
                .from("subscription_service")
                .localField("$SUBSCRIPTION.subid_and_extracardsubid")
                .foreignField("subid_and_extracardsubid")
                .as("SS");
        lookupOps.add(lookupSS);

        LookupOperation lookupSSA = LookupOperation.newLookup()
                .from("subscription_service_attr")
                .localField("$SUBSCRIPTION.subid_and_extracardsubid")
                .foreignField("subid_and_extracardsubid")
                .as("SSA");
        lookupOps.add(lookupSSA);

        LookupOperation lookupMS = LookupOperation.newLookup()
                .from("subscription")
                .localField("$OWNER.ownerid")
                .foreignField("subscriptionnumber")
                .as("MS");
        lookupOps.add(lookupMS);

        LookupOperation lookupMS_STI= LookupOperation.newLookup()
                .from("subscriptiontypeinformation")
                .localField("$MS.subscriptiontype")
                .foreignField("subscriptiontypecode")
                .as("MS_STI");
        lookupOps.add(lookupMS_STI);

        LookupOperation lookupXS= LookupOperation.newLookup()
                .from("xtas_subscription")
                .localField("$SUBSCRIPTION.subscriptionnumber")
                .foreignField("mobilenumber")
                .as("XS");
        lookupOps.add(lookupXS);

        LookupOperation lookupSI= LookupOperation.newLookup()
                .from("serviceinformation")
                .localField("$SS.servicecode")
                .foreignField("servicecodeid")
                .as("SI");
        lookupOps.add(lookupSI);

        return lookupOps;
    }
    private List<AggregationOperation> getCommonCustomerLookupOperations(){

        List<AggregationOperation> lookupOps = new ArrayList<>();

        LookupOperation lookupCustomer = LookupOperation.newLookup()
                .from("customer")
                .localField("cin_pt")
                .foreignField("cin_type")
                .as("CUSTOMER");
        lookupOps.add(lookupCustomer);

        LookupOperation lookupSubscription = LookupOperation.newLookup()
                .from("cusin_subscription")
                .localField("$CUSTOMER.customernumber")
                .foreignField("customernumber")
                .as("SUBSCRIPTION");
        lookupOps.add(lookupSubscription);
        lookupOps.add(Aggregation.unwind("SUBSCRIPTION"));

        LookupOperation lookupMember = LookupOperation.newLookup()
                .from("community_member")
                .localField("$SUBSCRIPTION.subscriptionnumber")
                .foreignField("memberid")
                .as("MEMBER");
        lookupOps.add(lookupMember);

        LookupOperation lookupOwner = LookupOperation.newLookup()
                .from("community_owner")
                .localField("$MEMBER.communityid")
                .foreignField("communityid")
                .as("OWNER");
        lookupOps.add(lookupOwner);

        LookupOperation lookupSubtype = LookupOperation.newLookup()
                .from("subscriptiontypeinformation")
                .localField("$SUBSCRIPTION.subscriptiontype")
                .foreignField("subscriptiontypecode")
                .as("SUBTYPE");
        lookupOps.add(lookupSubtype);
        lookupOps.add(Aggregation.unwind("SUBTYPE"));

        LookupOperation lookupBillGrp= LookupOperation.newLookup()
                .from("billgrp")
                .localField("$SUBSCRIPTION.billentityobjid")
                .foreignField("entityobjid")
                .as("BILLGRP");
        lookupOps.add(lookupBillGrp);
        lookupOps.add(Aggregation.unwind("BILLGRP"));

        LookupOperation lookupSS = LookupOperation.newLookup()
                .from("subscription_service")
                .localField("$SUBSCRIPTION.subid_and_extracardsubid")
                .foreignField("subid_and_extracardsubid")
                .as("SS");
        lookupOps.add(lookupSS);

        LookupOperation lookupSSA = LookupOperation.newLookup()
                .from("subscription_service_attr")
                .localField("$SUBSCRIPTION.subid_and_extracardsubid")
                .foreignField("subid_and_extracardsubid")
                .as("SSA");
        lookupOps.add(lookupSSA);

        LookupOperation lookupMS = LookupOperation.newLookup()
                .from("subscription")
                .localField("$OWNER.ownerid")
                .foreignField("subscriptionnumber")
                .as("MS");
        lookupOps.add(lookupMS);

        LookupOperation lookupMS_STI= LookupOperation.newLookup()
                .from("subscriptiontypeinformation")
                .localField("$MS.subscriptiontype")
                .foreignField("subscriptiontypecode")
                .as("MS_STI");
        lookupOps.add(lookupMS_STI);

        LookupOperation lookupXS= LookupOperation.newLookup()
                .from("xtas_subscription")
                .localField("$SUBSCRIPTION.subscriptionnumber")
                .foreignField("mobilenumber")
                .as("XS");
        lookupOps.add(lookupXS);

        LookupOperation lookupSI= LookupOperation.newLookup()
                .from("serviceinformation")
                .localField("$SS.servicecode")
                .foreignField("servicecodeid")
                .as("SI");
        lookupOps.add(lookupSI);

        return lookupOps;
    }
    private void initFieldMap(){
        Map<String, String> fieldMap = new HashMap<String, String>();
        //fieldMap.put("subscriptionnumber", "subscriptionnumber");
        fieldMap.put("subscriptionid", "subscriptionid");
        fieldMap.put("extracardsubscriptionid", "extracardsubscriptionid");
        fieldMap.put("customeridentificationnumber", "$CUSTOMER.customeridentificationnumber");
        fieldMap.put("customertype", "$CUSTOMER.customertype");
        fieldMap.put("communityowner", "$MEMBER.communityowner");
        //fieldMap.put("$subscriptionnumber", "msisdn");
        fieldMap.put("customernumber", "customernumber");
        fieldMap.put("subscriptiontype", "subscriptiontype");
        fieldMap.put("subscriptiontypecategory", "subscriptiontypecategory");
        fieldMap.put("paymentmethod", "paymentmethod");
        fieldMap.put("brandid", "brandid");
        fieldMap.put("branddescription", "branddescription");
        fieldMap.put("activationdate", "activationdate");
        fieldMap.put("trafficstatuscode", "trafficstatuscode");
        fieldMap.put("trafficdescription", "trafficdescription");
        fieldMap.put("subscriptionstatus", "subscriptionstatus");
        fieldMap.put("trafficstatusreason", "trafficstatusreason");
        fieldMap.put("customertargetsegment", "customertargetsegment");
        fieldMap.put("multisubscriptionnumber", "multisubscriptionnumber");
        fieldMap.put("billentityobjid", "billentityobjid");
        fieldMap.put("referencetextonbill", "referencetextonbill");
        fieldMap.put("agreementnumber", "agreementnumber");
        fieldMap.put("sub_name1", "$address.name");
        fieldMap.put("sub_name2", "$address.name2");
        fieldMap.put("sub_name3", "$address.name3");
        fieldMap.put("sub_addressrow1", "$address.addressrow1");
        fieldMap.put("sub_addressrow2", "$address.addressrow2");
        fieldMap.put("sub_addressrow3", "$address.addressrow3");
        fieldMap.put("sub_city", "$address.city");
        fieldMap.put("sub_zipcode", "$address.zipcode");
        fieldMap.put("servicecode", "$SS.servicecode");
        fieldMap.put("servicevalue", "$SS.servicevalue");
        fieldMap.put("attributename", "$SSA.attributename");
        fieldMap.put("attributevalue", "$SSA.attributevalue");
        fieldMap.put("invoicetext", "$SI.invoicetext");
        fieldMap.put("allowance", "$SI.allowance");
        fieldMap.put("xtas_subscriptionnumber", "$XS.mobilenumber");
        fieldMap.put("offeringname", "$SUBTYPE.invoicetext");
        fieldMap.put("accountnumber", "$BILLGRP.accountnumber");
        fieldMap.put("invoicedeliverymethod", "$BILLGRP.invoicedeliverymethod");
        fieldMap.put("invoicedeliverymethoddescr", "$BILLGRP.invoicedeliverymethoddescr");
        fieldMap.put("billingroupid", "$BILLGRP.billgroupid");
        fieldMap.put("bg_name1", "$BILLGRP.address.name");
        fieldMap.put("bg_name2", "$BILLGRP.address.name");
        fieldMap.put("bg_name3", "$BILLGRP.address.name3");
        fieldMap.put("bg_addressrow1", "$BILLGRP.address.addressrow1");
        fieldMap.put("bg_addressrow2", "$BILLGRP.address.addressrow2");
        fieldMap.put("bg_addressrow3", "$BILLGRP.address.addressrow3");
        fieldMap.put("bg_city", "$BILLGRP.address.city");
        fieldMap.put("bg_zipcode", "$BILLGRP.address.zipcode");
        fieldMap.put("cus_name1", "$CUSTOMER.address.name");
        fieldMap.put("cus_name2", "$CUSTOMER.address.name2");
        fieldMap.put("cus_name3", "$CUSTOMER.address.name3");
        fieldMap.put("cus_addressrow1", "$CUSTOMER.address.addressrow1");
        fieldMap.put("cus_addressrow2", "$CUSTOMER.address.addressrow2");
        fieldMap.put("cus_addressrow3", "$CUSTOMER.address.addressrow3");
        fieldMap.put("cus_city", "$CUSTOMER.address.city");
        fieldMap.put("cus_zipcode", "$CUSTOMER.address.zipcode");
        fieldMap.put("communityowner", "$MEMBER.communityowner");
        fieldMap.put("ownerid", "$OWNER.ownerid");
        fieldMap.put("tscid", "COMMON_CUSTOMER.tscid");
        fieldMap.put("retailernumber", "retailernumber");
        fieldMap.put("supervisionlevel", "supervisionlevel");
        fieldMap.put("supervisionstatus", "supervisionstatus");
        fieldMap.put("supervisiondate", "supervisiondate");
        fieldMap.put("multisubscriptiontype", "$MS.subscriptiontype");
        fieldMap.put("multisubscriptiontypecategory", "$MS.subscriptiontypecategory");
        fieldMap.put("multisubscriptiontypedescr", "$MS_STI.invoicetext");

        this.fieldMap = fieldMap;
    }

}
