package exjobb.cache.mongo.repository.billgrp;

import exjobb.cache.mongo.entity.cusin.BillGrp;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by Jimmie on 10/6/2017.
 */
public interface BillGrpRepository extends MongoRepository<BillGrp, String>, CustomBillGrpRepository {
}
