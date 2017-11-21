package exjobb.cache.mongo.repository.mobile_subscription;

import exjobb.cache.mongo.entity.mobile.MSubscriptionStripped;
import exjobb.cache.mongo.entity.mobile.MobileSubscription;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.MatchOperation;
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

    @Autowired
    public MSubscriptionRepositoryImpl(MongoOperations operations) {

        Assert.notNull(operations, "MongoOperations must not be null!");
        this.operations = operations;
    }

    @Override
    public List<?> categorySearch(String keyword, String type, Integer page, Boolean stripped){

        Query query = new Query();
        ArrayList<Criteria> criterias = new ArrayList<>();
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


        if(!keyword.equals("all")) query.addCriteria(c);

        query.fields().include("msisdn");
        query.fields().include("customeridentificationnumber");
        query.fields().include("subscriptionid");

        query.maxTimeMsec(5000);
        query.with(new PageRequest(page, 15));
        List<?> result = stripped ? operations.find(query, MSubscriptionStripped.class) : operations.find(query, MobileSubscription.class);

        return result;

    }


}
