package exjobb.cache.mongo.repository.mobile_subscription;

import com.mongodb.DBObject;
import exjobb.cache.mongo.entity.SearchOptions;
import exjobb.cache.mongo.entity.cusin.Subscription;
import exjobb.cache.mongo.entity.mobile.MSubscriptionStripped;
import exjobb.cache.mongo.entity.mobile.MobileSubscription;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.aggregation.*;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.TextCriteria;
import org.springframework.data.mongodb.core.query.TextQuery;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Jimmie on 10/9/2017.
 */
@RepositoryRestResource(collectionResourceRel = "mobile_subscription", path = "mobile_subscription")
public class MSubscriptionRepositoryImpl implements CustomMSubscriptionRepository {

    private final MongoOperations operations;
    private Map<String, String> fieldMap;
    @Autowired
    public MSubscriptionRepositoryImpl(MongoOperations operations) {

        Assert.notNull(operations, "MongoOperations must not be null!");
        this.operations = operations;

        initFieldMap();
    }

    private Criteria getCriteria(String type, String keyword){
        Criteria c;
        switch (type){
            case "equals":
                c = new Criteria().orOperator(
                        Criteria.where("msisdn").is(keyword),
                        Criteria.where("customeridentificationnumber").is(keyword),
                        Criteria.where("subscriptionid").is(keyword)
                );
                break;
            case "gt":
                c = new Criteria().orOperator(
                        Criteria.where("msisdn").gt(keyword),
                        Criteria.where("customeridentificationnumber").gt(keyword),
                        Criteria.where("subscriptionid").gt(keyword)
                );
                break;
            case "gte":
                c = new Criteria().orOperator(
                        Criteria.where("msisdn").gte(keyword),
                        Criteria.where("customeridentificationnumber").gte(keyword),
                        Criteria.where("subscriptionid").gte(keyword)
                );
                break;
            case "lt":
                c = new Criteria().orOperator(
                        Criteria.where("msisdn").lt(keyword),
                        Criteria.where("customeridentificationnumber").lt(keyword),
                        Criteria.where("subscriptionid").lt(keyword)
                );
                break;
            case "lte":
                c = new Criteria().orOperator(
                        Criteria.where("msisdn").lte(keyword),
                        Criteria.where("customeridentificationnumber").lte(keyword),
                        Criteria.where("subscriptionid").lte(keyword)
                );
                break;
            default:
                c = new Criteria().orOperator(
                        Criteria.where("msisdn").regex("^"+keyword),
                        Criteria.where("customeridentificationnumber").regex("^"+keyword),
                        Criteria.where("subscriptionid").regex("^"+keyword)
                );
                break;
        }
        return c;
    }

    @Override
    public List<?> categorySearch(String keyword, String type, Integer page, Boolean stripped){

        Query query = new Query();
        ArrayList<Criteria> criterias = new ArrayList<>();
        Criteria c;

        c = getCriteria(type, keyword);

        if(!keyword.equals("all")) query.addCriteria(c);

        query.fields().include("msisdn");
        query.fields().include("customeridentificationnumber");
        query.fields().include("subscriptionid");

        query.maxTimeMsec(5000);
        query.with(new PageRequest(page, 15));
        List<?> result = stripped ? operations.find(query, MSubscriptionStripped.class) : operations.find(query, MobileSubscription.class);

        return result;

    }

    @Override
    public List<?> categorySearchPOST(SearchOptions opt){

        Query query = new Query();

        MatchOperation filter;
        String keyword = opt.getValue();


        SkipOperation skip = Aggregation.skip(new Long(opt.getPage()*15));
        LimitOperation limit = Aggregation.limit(opt.getLimit());

        Boolean getAllFields = opt.getFields().isEmpty();

        ProjectionOperation project = Aggregation.project().andExclude("_id");
        if(!getAllFields) {
            //project = project.and("msisdn").as("msisdn");
            for(String field : opt.getFields()) {
                System.out.println(field);
                project = project.and(field).as(field);
            }
        }

        Aggregation agg;
        if(!keyword.isEmpty()){
            filter = Aggregation.match(getCriteria(opt.getType(), keyword));
            agg = Aggregation.newAggregation(
                    filter,
                    skip,
                    limit,
                    project
            );
        } else {
           agg = Aggregation.newAggregation(
                    skip,
                    limit,
                    project
            );
        }

        AggregationResults<?> aggResults = operations.aggregate(
                agg, Subscription.class, MobileSubscription.class
        );

        return  aggResults.getMappedResults();

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
        fieldMap.put("$address.name", "sub_name1");
        fieldMap.put("$address.name2", "sub_name2");
        fieldMap.put("$address.name3", "sub_name3");
        fieldMap.put("$address.addressrow1", "sub_addressrow1");
        fieldMap.put("$address.addressrow2", "sub_addressrow2");
        fieldMap.put("$address.addressrow3", "sub_addressrow3");
        fieldMap.put("$address.city", "sub_city");
        fieldMap.put("$address.zipcode", "sub_zipcode");
        fieldMap.put("$SS.servicecode", "servicecode");
        fieldMap.put("$SS.servicevalue", "servicevalue");
        fieldMap.put("$SSA.attributename", "attributename");
        fieldMap.put("$SSA.attributevalue", "attributevalue");
        fieldMap.put("$SI.invoicetext", "invoicetext");
        fieldMap.put("$SI.allowance", "allowance");
        fieldMap.put("$XS.mobilenumber", "xtas_subscriptionnumber");
        fieldMap.put("$SUBTYPE.invoicetext", "offeringname");
        fieldMap.put("$BILLGRP.accountnumber", "accountnumber");
        fieldMap.put("$BILLGRP.invoicedeliverymethod", "invoicedeliverymethod");
        fieldMap.put("$BILLGRP.invoicedeliverymethoddescr", "invoicedeliverymethoddescr");
        fieldMap.put("$BILLGRP.billgroupid", "billingroupid");
        fieldMap.put("$BILLGRP.address.name", "bg_name1");
        fieldMap.put("$BILLGRP.address.name2", "bg_name2");
        fieldMap.put("$BILLGRP.address.name3", "bg_name3");
        fieldMap.put("$BILLGRP.address.addressrow1", "bg_addressrow1");
        fieldMap.put("$BILLGRP.address.addressrow2", "bg_addressrow2");
        fieldMap.put("$BILLGRP.address.addressrow3", "bg_addressrow3");
        fieldMap.put("$BILLGRP.address.city", "bg_city");
        fieldMap.put("$BILLGRP.address.zipcode", "bg_zipcode");
        fieldMap.put("$CUSTOMER.address.name", "cus_name1");
        fieldMap.put("$CUSTOMER.address.name2", "cus_name2");
        fieldMap.put("$CUSTOMER.address.name3", "cus_name3");
        fieldMap.put("$CUSTOMER.address.addressrow1", "cus_addressrow1");
        fieldMap.put("$CUSTOMER.address.addressrow2", "cus_addressrow2");
        fieldMap.put("$CUSTOMER.address.addressrow3", "cus_addressrow3");
        fieldMap.put("$CUSTOMER.address.city", "cus_city");
        fieldMap.put("$CUSTOMER.address.zipcode", "cus_zipcode");
        fieldMap.put("$MEMBER.communityowner", "communityowner");
        fieldMap.put("$OWNER.ownerid", "ownerid");
        fieldMap.put("retailernumber", "retailernumber");
        fieldMap.put("supervisionlevel", "supervisionlevel");
        fieldMap.put("supervisionstatus", "supervisionstatus");
        fieldMap.put("supervisiondate", "supervisiondate");
        fieldMap.put("$MS.subscriptiontype", "multisubscriptiontype");
        fieldMap.put("$MS.subscriptiontypecategory", "multisubscriptiontypecategory");
        fieldMap.put("$MS_STI.invoicetext", "multisubscriptiontypedescr");

        this.fieldMap = fieldMap;
    }
}
