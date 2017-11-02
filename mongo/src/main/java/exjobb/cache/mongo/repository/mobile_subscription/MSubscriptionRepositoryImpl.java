package exjobb.cache.mongo.repository.mobile_subscription;

import exjobb.cache.mongo.entity.mobile.MSubscriptionStripped;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.TextCriteria;
import org.springframework.data.mongodb.core.query.TextQuery;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;

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
    public List<MSubscriptionStripped> likeSearch(String keyword, Integer page){

        Query regexWildcard = new Query();
        ArrayList<Criteria> criterias = new ArrayList<>();

        //Criteria c = new Criteria().orOperator(Criteria.where("msisdn").regex(keyword), Criteria.where("customeridentificationnumber").regex(keyword));
        Criteria c = new Criteria().orOperator(Criteria.where("msisdn").regex("^"+keyword), Criteria.where("customeridentificationnumber").regex("^"+keyword), Criteria.where("subscriptionid").regex("^"+keyword));
        regexWildcard.addCriteria(c);

        regexWildcard.fields().include("msisdn");
        regexWildcard.fields().include("customeridentificationnumber");
        regexWildcard.fields().include("subscriptionid");
        regexWildcard.maxTimeMsec(5000);
        regexWildcard.with(new PageRequest(page, 20));
        List<MSubscriptionStripped> result = operations.find(regexWildcard, MSubscriptionStripped.class);

        return result;

    }

    @Override
    public List<MSubscriptionStripped> textSearch(String keyword){

        TextCriteria criteria = TextCriteria.forDefaultLanguage().caseSensitive(false).matching(keyword);

        Query query = TextQuery.queryText(criteria)
                //.sortByScore()
                .with(new PageRequest(0, 5));
        query.fields().include("msisdn");
        query.fields().include("customeridentificationnumber");
        query.fields().include("subscriptionid");
        query.maxTimeMsec(5000);

        List<MSubscriptionStripped> result = operations.find(query, MSubscriptionStripped.class);



        return result;

    }
}
