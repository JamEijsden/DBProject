package exjobb.cache.mongo.repository.cusin_subscription;

import com.mongodb.DBObject;
import exjobb.cache.mongo.entity.SearchOptions;
import exjobb.cache.mongo.entity.mobile.MSubscriptionStripped;
import exjobb.cache.mongo.entity.mobile.MobileSubscription;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Jimmie on 10/6/2017.
 */
public interface CustomCSubscriptionRepository {

    List<?> aggregateSubscription(String susbcriptionnumber, String key, String type, Integer page, Boolean stripped);
    List<MobileSubscription> getSubscriptions(SearchOptions opt);
    List<MobileSubscription> streamSubscriptions(SearchOptions opt);


}
