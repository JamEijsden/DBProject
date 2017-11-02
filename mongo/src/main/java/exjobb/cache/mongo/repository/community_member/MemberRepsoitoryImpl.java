package exjobb.cache.mongo.repository.community_member;

import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by Jimmie on 10/6/2017.
 */
@RepositoryRestResource(collectionResourceRel = "community_member", path = "community/member")
public class MemberRepsoitoryImpl implements CustomMemberRepository {
}
