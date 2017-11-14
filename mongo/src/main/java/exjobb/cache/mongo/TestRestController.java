package exjobb.cache.mongo;

import exjobb.cache.mongo.entity.mobile.MSubscriptionStripped;
import exjobb.cache.mongo.entity.mobile.MobileSubscription;
import exjobb.cache.mongo.repository.cusin_subscription.CSubscriptionRepository;
import exjobb.cache.mongo.repository.mobile_subscription.MSubscriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * Created by Jimmie on 10/9/2017.
 */

@RestController
@RequestMapping(value="/api")
class TestRestController {
    private final CSubscriptionRepository subscriptionRepository;
    private final MSubscriptionRepository mSubRepository;

    @Autowired
    public TestRestController(CSubscriptionRepository subscriptionRepository,
                              MSubscriptionRepository mSubRepository){
        this.subscriptionRepository = subscriptionRepository;
        this.mSubRepository = mSubRepository;
    }

    @RequestMapping(value={"mobile/live/search/", "mobile/live/search/{keyword}"}, method = RequestMethod.GET)
    List<?> joinAll(@PathVariable Optional<String> keyword, @RequestParam(value = "key", required = false) String key,
                                        @RequestParam("type") String type, @RequestParam(value = "page", required = false) Integer page,
                                        @RequestParam("stripped") Boolean stripped) {
        page = page != null ? page : 0;
        key = (key.equals("") || key == null) ? "subscriptionnumber" : key;
        if (keyword.isPresent()) {
            return this.subscriptionRepository.aggregateSubscription(keyword.get(), key, type, page, stripped);
        } else {
            return this.subscriptionRepository.aggregateSubscription("all", key, type, page, stripped);
        }

    }

    @RequestMapping(value={"/mobile/search", "mobile/search/{keyword}"}, method = RequestMethod.GET)
    List<?> searchAll(@PathVariable Optional<String> keyword, @RequestParam("type") String type,
                                          @RequestParam(value = "page", required = false) Integer page,
                                          @RequestParam("stripped") Boolean stripped) {
        page = page != null ? page : 0;
        if (keyword.isPresent()) {
            return this.mSubRepository.categorySearch(keyword.get(), type, page, stripped);
        } else {
            return this.mSubRepository.categorySearch("all", type, page, stripped);
        }

    }

}
