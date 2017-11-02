package exjobb.cache.mongo.repository.subscriptiontypeinformation;

import exjobb.cache.mongo.entity.cusin.SubscriptionTypeInformation;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by Jimmie on 10/6/2017.
 */
public interface SubTypeInfoRepository extends MongoRepository<SubscriptionTypeInformation, String>, CustomSubTypeInfoRepository {

}
