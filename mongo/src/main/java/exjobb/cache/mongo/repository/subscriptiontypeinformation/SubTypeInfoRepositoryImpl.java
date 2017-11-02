package exjobb.cache.mongo.repository.subscriptiontypeinformation;

import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by Jimmie on 10/6/2017.
 */
@RepositoryRestResource(collectionResourceRel = "subscriptiontypeinformation", path = "subscriptiontypeinformation")
public class SubTypeInfoRepositoryImpl implements CustomSubTypeInfoRepository {
}
