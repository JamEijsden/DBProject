package exjobb.cache.mongo.repository.cusin_subscription;

import exjobb.cache.mongo.entity.cusin.Subscription;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Jimmie on 10/6/2017.
 */
@Repository
public interface CSubscriptionRepository extends MongoRepository<Subscription, String>, CustomCSubscriptionRepository {


   List<Subscription> findBySubscriptionid(@Param("number") String number);
   List<Subscription> findAll();

}

