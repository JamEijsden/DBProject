package exjobb.cache.mongo.repository.billgrp;

import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by Jimmie on 10/6/2017.
 */
@RepositoryRestResource(collectionResourceRel = "billgrp", path = "billgrp")
public class BillGrpRepositoryImpl implements CustomBillGrpRepository {
}
