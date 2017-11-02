package exjobb.cache.mongo.repository.community_owner;

import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by Jimmie on 10/6/2017.
 */
@RepositoryRestResource(collectionResourceRel = "community_owner", path = "community/owner")
public class OwnerRepositoryImpl implements CustomOwnerRepository {
}
