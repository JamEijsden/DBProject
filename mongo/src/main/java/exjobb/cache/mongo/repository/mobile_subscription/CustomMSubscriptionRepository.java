package exjobb.cache.mongo.repository.mobile_subscription;

import exjobb.cache.mongo.entity.mobile.MSubscriptionStripped;

import java.util.List;

/**
 * Created by Jimmie on 10/9/2017.
 */
public interface CustomMSubscriptionRepository {
    List<?> categorySearch(String keyword, String type, Integer page, Boolean stripped);
}
