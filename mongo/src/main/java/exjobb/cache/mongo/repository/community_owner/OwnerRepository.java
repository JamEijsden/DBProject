package exjobb.cache.mongo.repository.community_owner;

import exjobb.cache.mongo.entity.cusin.CommunityOwner;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by Jimmie on 10/6/2017.
 */
public interface OwnerRepository extends MongoRepository<CommunityOwner, String>, CustomOwnerRepository {
}
