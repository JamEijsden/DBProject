package exjobb.cache.mongo;

import com.mongodb.DBObject;
import exjobb.cache.mongo.entity.SearchOptions;
import exjobb.cache.mongo.entity.mobile.MSubscriptionStripped;
import exjobb.cache.mongo.entity.mobile.MobileSubscription;
import exjobb.cache.mongo.repository.cusin_subscription.CSubscriptionRepository;
import exjobb.cache.mongo.repository.mobile_subscription.MSubscriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Field;
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
    List<?> searchCat(@PathVariable Optional<String> keyword, @RequestParam("type") String type,
                                          @RequestParam(value = "page", required = false) Integer page,
                                          @RequestParam("stripped") Boolean stripped) {
        page = page != null ? page : 0;
        if (keyword.isPresent()) {
            return this.mSubRepository.categorySearch(keyword.get(), type, page, stripped);
        } else {
            return this.mSubRepository.categorySearch("all", type, page, stripped);
        }

    }

    @RequestMapping(value={"/mobile/search"}, method = RequestMethod.POST)
    List<?> searchCatPOST(@RequestBody SearchOptions opt) {
        return this.mSubRepository.categorySearchPOST(opt);
    }

    @RequestMapping(value={"mobile/live/search/"}, method = RequestMethod.POST)
    List<?> joinAllPost(@RequestBody SearchOptions opt, @RequestParam("stream") Boolean stream) {
        System.out.println(opt.toString());
        if(!stream) {
            return this.subscriptionRepository.getSubscriptions(opt);
        } else {
            return this.subscriptionRepository.getSubscriptions(opt);
        }


    }


    @RequestMapping(value={"/fields"}, method = RequestMethod.GET)
    List<String> getFields(){
        MobileSubscription m = new MobileSubscription();
        Field[] fields = m.getClass().getDeclaredFields();

        List<String> actualFieldNames = getFieldNames(fields);
        return actualFieldNames;
    }


    private static List<String> getFieldNames(Field[] fields) {
        List<String> fieldNames = new ArrayList<>();
        for (Field field : fields)
            fieldNames.add(field.getName());
        return fieldNames;
    }

}
