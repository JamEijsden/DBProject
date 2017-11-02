package exjobb.cache.mongo.repository.mobile_subscription;

import exjobb.cache.mongo.entity.mobile.MobileSubscription;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by Jimmie on 10/9/2017.
 */
public interface MSubscriptionRepository extends MongoRepository<MobileSubscription, String>, CustomMSubscriptionRepository {

}
