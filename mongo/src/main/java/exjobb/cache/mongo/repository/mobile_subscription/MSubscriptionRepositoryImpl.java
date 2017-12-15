package exjobb.cache.mongo.repository.mobile_subscription;

import exjobb.cache.mongo.entity.SearchOptions;
import exjobb.cache.mongo.entity.mobile.MSubscriptionStripped;
import exjobb.cache.mongo.entity.mobile.MobileSubscription;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.aggregation.*;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
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

        LookupOperation lookupCustomer = LookupOperation.newLookup()
                .from("common_customer")
                .localField("cin_type")
                .foreignField("cin_pt")
                .as("COMMON_CUSTOMER");

        SkipOperation skip = Aggregation.skip(new Long(opt.getPage()*15));
        LimitOperation limit = Aggregation.limit(opt.getLimit());

        Boolean getAllFields = opt.getFields().isEmpty();
        ProjectionOperation project = new ProjectionOperation()
                .andExclude("_id")
                .andInclude("msisdn", "customeridentificationnumber");

        if(!getAllFields) {
            //project = project.and("msisdn").as("msisdn");
            for(String field : opt.getFields()) {
                System.out.println(field);
                project = project.and(this.fieldMap.get(field)).as(field);
            }
        }else {
            project = getMobSubscriptionProjection();
        }

        Aggregation agg;
        if(!keyword.isEmpty()){
            filter = Aggregation.match(getCriteria(opt.getType(), keyword));
            agg = Aggregation.newAggregation(
                filter,
                lookupCustomer,
                skip,
                limit,
                project
            );
        } else {
           agg = Aggregation.newAggregation(
                lookupCustomer,
                skip,
                limit,
                project
            );
        }

        AggregationResults<?> aggResults = operations.aggregate(
                agg, MobileSubscription.class, MobileSubscription.class
        );

        return  aggResults.getMappedResults();

    }

    private ProjectionOperation getMobSubscriptionProjection(){
        return Aggregation.project()
                .andInclude("$COMMON_CUSTOMER.tscid",
                        "subscriptionnumber", "extracardsubscriptionid", "subscriptiontype",
                        "subscriptionstatus", "agreementnumber", "referencetextonbill", "activationdate",
                        "paymentmethod", "brandid", "branddescription", "billentityobjid", "customertargetsegment",
                        "multisubscriptionnumber", "msisdn", "c2bcacheuid", "servicecode", "servicevalue", "attributename",
                        "attributevalue", "serviceinvoicetext", "serviceallowance", "offeringname", "communityowner", "accountnumber",
                        "invoicedeliverymethod", "invoicedeliverymethoddescr", "customertype", "customeridentificationnumber")
                /*.and("bg_name1").as("bgName1")
                .and("bg_name2").as("bgName2")
                .and("bg_name3").as("bgName3")
                .and("bg_addressrow1").as("bgAddressrow1")
                .and("bg_addressrow2").as("bgAddressrow2")
                .and("bg_addressrow3").as("bgAddressrow3")
                .and("bg_city").as("bgCity")
                .and("bg_zipcode").as("bgZipcode")
                .and("cus_name1").as("cusName1")
                .and("cus_name2").as("cusName2")
                .and("cus_name3").as("cusName3")
                .and("cu_addressrow1").as("cusAddressrow1")
                .and("cu_addressrow2").as("cusAddressrow2")
                .and("cu_addressrow3").as("cusAddressrow3")
                .and("cu_city").as("cusCity")
                .and("cu_zipcode").as("cusZipcode")*/
                .andInclude("ownerid", "supervisionstatus",
                        "multisubscriptiontype", "multisubscriptiontypedescr")
                .andExclude("_id");
    }
    private ProjectionOperation getCommonCustomerProjection(){
        return Aggregation.project()
                .andInclude("tscid",
                        "$MOBILE_SUB.subscriptionnumber", "$MOBILE_SUB.extracardsubscriptionid", "$MOBILE_SUB.subscriptiontype",
                        "$MOBILE_SUB.subscriptionstatus", "$MOBILE_SUB.agreementnumber", "$MOBILE_SUB.referencetextonbill", "$MOBILE_SUB.activationdate",
                        "$MOBILE_SUBpaymentmethod", "$MOBILE_SUB.brandid", "$MOBILE_SUB.branddescription", "$MOBILE_SUB.billentityobjid", "$MOBILE_SUB.customertargetsegment",
                        "$MOBILE_SUB.multisubscriptionnumber", "$MOBILE_SUB.msisdn", "$MOBILE_SUB.c2bcacheuid", "$MOBILE_SUB.servicecode", "$MOBILE_SUB.servicevalue", "$MOBILE_SUB.attributename",
                        "$MOBILE_SUB.attributevalue", "$MOBILE_SUB.serviceinvoicetext", "$MOBILE_SUB.serviceallowance", "$MOBILE_SUB.offeringname", "$MOBILE_SUB.communityowner", "$MOBILE_SUB.accountnumber",
                        "$MOBILE_SUB.invoicedeliverymethod", "$MOBILE_SUB.invoicedeliverymethoddescr", "$MOBILE_SUB.customertype", "$MOBILE_SUB.customeridentificationnumber")
                /*.and("bg_name1").as("bgName1")
                .and("bg_name2").as("bgName2")
                .and("bg_name3").as("bgName3")
                .and("bg_addressrow1").as("bgAddressrow1")
                .and("bg_addressrow2").as("bgAddressrow2")
                .and("bg_addressrow3").as("bgAddressrow3")
                .and("bg_city").as("bgCity")
                .and("bg_zipcode").as("bgZipcode")
                .and("cus_name1").as("cusName1")
                .and("cus_name2").as("cusName2")
                .and("cus_name3").as("cusName3")
                .and("cu_addressrow1").as("cusAddressrow1")
                .and("cu_addressrow2").as("cusAddressrow2")
                .and("cu_addressrow3").as("cusAddressrow3")
                .and("cu_city").as("cusCity")
                .and("cu_zipcode").as("cusZipcode")*/
                .andInclude("$MOBILE_SUB.ownerid", "$MOBILE_SUB.supervisionstatus",
                        "$MOBILE_SUB.multisubscriptiontype", "$MOBILE_SUB.multisubscriptiontypedescr")
                .andExclude("_id");
    }

    private void initFieldMap(){
        Map<String, String> fieldMap = new HashMap<String, String>();
        //fieldMap.put("subscriptionnumber", "subscriptionnumber");
        fieldMap.put("subscriptionid", "subscriptionid");
        fieldMap.put("extracardsubscriptionid", "extracardsubscriptionid");
        //fieldMap.put("customeridentificationnumber", "$CUSTOMER.customeridentificationnumber");
        fieldMap.put("customertype", "$CUSTOMER.customertype");
        fieldMap.put("communityowner", "$MEMBER.communityowner");
        //fieldMap.put("$subscriptionnumber", "msisdn");
        fieldMap.put("tscid", "$COMMON_CUSTOMER.tscid");
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
        fieldMap.put("servicecode", "servicecode");
        fieldMap.put("servicevalue", "servicevalue");
        fieldMap.put("attributename", "attributename");
        fieldMap.put("attributevalue", "attributevalue");
        fieldMap.put("serviceinvoicetext", "serviceinvoicetext");
        fieldMap.put("serviceallowance", "serviceallowance");
        fieldMap.put("mobilenumber", "xtas_subscriptionnumber");
        fieldMap.put("offeringname", "offeringname");
        fieldMap.put("accountnumber", "accountnumber");
        fieldMap.put("invoicedeliverymethod", "invoicedeliverymethod");
        fieldMap.put("invoicedeliverymethoddescr", "invoicedeliverymethoddescr");
        fieldMap.put("billgroupid", "billingroupid");
        fieldMap.put("address.name", "bg_name1");
        fieldMap.put("address.name2", "bg_name2");
        fieldMap.put("address.name3", "bg_name3");
        fieldMap.put("address.addressrow1", "bg_addressrow1");
        fieldMap.put("address.addressrow2", "bg_addressrow2");
        fieldMap.put("address.addressrow3", "bg_addressrow3");
        fieldMap.put("address.city", "bg_city");
        fieldMap.put("address.zipcode", "bg_zipcode");
        fieldMap.put("address.name", "cus_name1");
        fieldMap.put("address.name2", "cus_name2");
        fieldMap.put("address.name3", "cus_name3");
        fieldMap.put("address.addressrow1", "cus_addressrow1");
        fieldMap.put("address.addressrow2", "cus_addressrow2");
        fieldMap.put("address.addressrow3", "cus_addressrow3");
        fieldMap.put("address.city", "cus_city");
        fieldMap.put("address.zipcode", "cus_zipcode");
        fieldMap.put("communityowner", "communityowner");
        fieldMap.put("ownerid", "ownerid");
        fieldMap.put("retailernumber", "retailernumber");
        fieldMap.put("supervisionlevel", "supervisionlevel");
        fieldMap.put("supervisionstatus", "supervisionstatus");
        fieldMap.put("supervisiondate", "supervisiondate");
        fieldMap.put("subscriptiontype", "multisubscriptiontype");
        fieldMap.put("subscriptiontypecategory", "multisubscriptiontypecategory");
        fieldMap.put("multisubscriptiontypedescr", "multisubscriptiontypedescr");

        this.fieldMap = fieldMap;
    }
}
