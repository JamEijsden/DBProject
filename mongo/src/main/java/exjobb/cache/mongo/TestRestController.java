package exjobb.cache.mongo;

import exjobb.cache.mongo.entity.mobile.MSubscriptionStripped;
import exjobb.cache.mongo.repository.cusin_subscription.CSubscriptionRepository;
import exjobb.cache.mongo.repository.mobile_subscription.MSubscriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

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

    @RequestMapping(value="mobile/search/live/{keyword}", method = RequestMethod.GET)
    AggregationResults<MSubscriptionStripped> join(@PathVariable String keyword) {
        return this.subscriptionRepository.aggregateSubscriptionLike(keyword);
    }


    @RequestMapping(value="mobile/search/{keyword}", method = RequestMethod.GET)
    List<MSubscriptionStripped> search(@PathVariable String keyword, @RequestParam("type") String type, @RequestParam(value = "page", required = false) Integer page) {
        page = page != null ? page : 0;
        switch(type){
            case "like":
                return this.mSubRepository.likeSearch(keyword, page);
            case "text":
                return this.mSubRepository.textSearch(keyword);
            default:
                return (new ArrayList<>());
        }

    }

    @RequestMapping("")
    public String api(Model model, @RequestParam(value="name", required=false, defaultValue="World") String name) {
        model.addAttribute("name", name);
        return "api";
    }


}
