package exjobb.cache.mongo.repository.cusin_subscription;

import exjobb.cache.mongo.entity.mobile.MSubscriptionStripped;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;

/**
 * Created by Jimmie on 10/6/2017.
 */
public interface CustomCSubscriptionRepository {

    AggregationResults<MSubscriptionStripped> aggregateSubscriptionLike(String susbcriptionnumber);
}
