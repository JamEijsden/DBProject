package exjobb.cache.mongo.repository.cusin_subscription;

import exjobb.cache.mongo.entity.mobile.MSubscriptionStripped;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;

import java.util.List;

/**
 * Created by Jimmie on 10/6/2017.
 */
public interface CustomCSubscriptionRepository {

    List<?> aggregateSubscription(String susbcriptionnumber, String key, String type, Integer page, Boolean stripped);
}
