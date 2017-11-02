package exjobb.cache.mongo.repository.community_member;

import exjobb.cache.mongo.entity.cusin.CommunityMember;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by Jimmie on 10/6/2017.
 */
public interface MemberRepository extends MongoRepository<CommunityMember, String>, CustomMemberRepository {
}
