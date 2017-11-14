
db.cusin_subscription.aggregate([       
    { $lookup: {
    from: "customer",
    localField: "customernumber",
    foreignField: "customernumber",
    as: "CUSTOMER"
    }},    
    {$unwind: "$CUSTOMER"},
    
    { $lookup: {
    from: "community_member",
    localField: "subscriptionnumber",
    foreignField: "memberid",
    as: "MEMBER"
    }},
    //{$unwind: "$MEMBER"},

    { $lookup: {
    from: "community_owner",
    localField: "MEMBER.communityid",
    foreignField: "communityid",
    as: "OWNER"
    }},
    //{$unwind: "$OWNER"},

    { $lookup: {
    from: "subscriptiontypeinformation",
    localField: "subscriptiontype",
    foreignField: "subscriptiontypecode",
    as: "SUBTYPE"
    }},
    {$unwind: "$SUBTYPE"},

    { $lookup: {
    from: "billgrp",
    localField: "billentityobjid",
    foreignField: "entityobjid",
    as: "BILLGRP"
    }},
    {$unwind: "$BILLGRP"},

    { $lookup: {
    from: "subscription_service",
    localField: "subid_and_extracardsubid",
    foreignField: "subid_and_extracardsubid",
    as: "SS"
    }},
    //{$unwind: "$SS"},

    { $lookup: {
    from: "subscription_service_attr",
    localField: "subid_and_extracardsubid",
    foreignField: "subid_and_extracardsubid",
    as: "SSA"
    }},
    { $lookup: {
    from: "xtas_subscription",
    localField: "subscriptionnumber",
    foreignField: "mobilenumber",
    as: "XS"
    }},   
    { $lookup: {
    from: "cusin_subscription",
    localField: "OWNER.ownerid",
    foreignField: "subscriptionnumber",
    as: "MS"
    }},
    //{$unwind: "$MS"},

    { $lookup: {
    from: "subscriptiontypeinformation",
    localField: "MS.subscriptiontype",
    foreignField: "subscriptiontypecode",
    as: "MS_STI"
    }},   
    //{$unwind: "$MS_STI"},
    
    { $lookup: {
    from: "serviceinformation",
    localField: "SS.servicecode",
    foreignField: "servicecodeid",
    as: "SI"
    }},   
    //{ $match: {"extracardsubscriptionid": "$SS.extracardsubscriptionid"} },   
    { 
        $project: {
            subscriptionid: 1,
            extracardsubscriptionid: 1,
            subscriptionnumber: 1,        
            msisdn: "$subscriptionnumber",
            c2bcacheuid: {$concat: ["mobilesubscription:", "$subscriptionnumber"]},
            subscriptiontype: 1,
            subscriptiontypecategory: 1,
            paymentmethod: 1,
            brandid: 1,
            branddescription: 1,
            activationdate: 1,
            trafficstatuscode: 1,
            trafficdescription: 1,
            subscriptionstatus: 1,
            trafficstatusreason: 1,
            customertargetsegment: 1,
            multisubscriptionnumber: 1,
            billentityobjid: 1,
            referencetextonbill: 1,
            agreementnumber: 1,
            sub_name: "$ADDRESS.name",
            sub_name2: "$ADDRESS.name2",
            sub_name3: "$ADDRESS.name3",
            sub_addressrow1: "$ADDRESS.addressrow1",
            sub_addressrow2: "$ADDRESS.addressrow2",
            sub_addressrow3: "$ADDRESS.addressrow3",
            sub_city: "$ADDRESS.city",
            sub_zipcode: "$ADDRESS.zipcode",
            servicecode: "$SS.servicecode",
            servicevalue: "$SS.servicevalue",
            attributename: "$SSA.attributename",
            attributevalue: "$SSA.attributevalue",
            serviceinvoicetext: "$SI.invoicetext",
            serviceallowance: "$SI.allowance",
            xtas_subscriptionnumber: { $arrayElemAt: ["$XS.mobilenumber", 0] },
            offeringname: "$SUBTYPE.invoicetext",
            communityowner: "$MEMBER.communityowner",
            accountnumber: "$BILLGRP.accountnumber",
            invoicedeliverymethod: "$BILLGRP.invoicedeliverymethod",
            invoicedeliverymethoddescr: "$BILLGRP.invoicedeliverymethoddescr",
            billinggroupid: "$BILLGRP.billgroupid",
            bg_name1: "$BILLGRP.address.name",
            bg_name2: "$BILLGRP.address.name2",
            bg_name3: "$BILLGRP.address.name3",
            bg_addressrow1: "$BILLGRP.address.addressrow1",
            bg_addressrow2: "$BILLGRP.address.addressrow2",
            bg_addressrow3: "$BILLGRP.address.addressrow3",
            bg_city: "$BILLGRP.address.city",
            bg_zipcode: "$BILLGRP.address.zipcode",
            customertype: "$CUSTOMER.customertype",
            customeridentificationnumber: "$CUSTOMER.customeridentificationnumber",
            cin_type : {$concat: ["$CUSTOMER.customeridentificationnumber", ":", "$CUSTOMER.customertype"]},
            cus_name1: "$CUSTOMER.address.name",
            cus_name2: "$CUSTOMER.address.name2",
            cus_name3: "$CUSTOMER.address.name3",
            cu_addressrow1: "$CUSTOMER.address.addressrow1",
            cu_addressrow2: "$CUSTOMER.address.addressrow2",
            cu_addressrow3: "$CUSTOMER.address.addressrow3",
            cu_city: "$CUSTOMER.address.city",
            cu_zipcode: "$CUSTOMER.address.zipcode",
            communityowner: { $arrayElemAt: ["$MEMBER.communityowner", 0] },
            ownerid: { $arrayElemAt: ["$OWNER.ownerid", 0] },
            retailernumber: "$retailernumber",
            supervisionlevel: "$supervisionlevel",
            supervisionstatus: "$supervisionstatus",
            supervisiondate: "$supervisiondate",
            multisubscriptiontype: { $arrayElemAt: ["$MS.subscriptiontype", 0] },
            multisubscriptiontypecategory: { $arrayElemAt: ["$MS.subscriptiontypecategory", 0] },
            multisubscriptiontypedescr: { $arrayElemAt: ["$MS_STI.invoicetext", 0] }
        }        
    }
    // { $out : "mobile_subscription" }
]).forEach(function(sub){
    db.mobile_subscription.insert(sub);
});
