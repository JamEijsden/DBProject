
db.cusin_subscription.aggregate([
          	
	    { $match: {"SUBSCRIPTIONNUMBER":"469SUBNR20"} },          	
		{ $lookup: {
           from: "customer",
           localField: "CUSTOMERNUMBER",
           foreignField: "CUSTOMERNUMBER",
           as: "CUSTOMER"
        }},
        {$unwind: "$CUSTOMER"},
        
        { $lookup: {
           from: "community_member",
           localField: "SUBSCRIPTIONNUMBER",
           foreignField: "MEMBERID",
           as: "MEMBER"
        }},
        {$unwind: "$MEMBER"},
        
        { $lookup: {
           from: "community_owner",
           localField: "MEMBER.COMMUNITYID",
           foreignField: "COMMUNITYID",
           as: "OWNER"
        }},
        {$unwind: "$OWNER"},
        
        { $lookup: {
           from: "subscriptiontypeinformation",
           localField: "SUBSCRIPTIONTYPE",
           foreignField: "SUBSCRIPTIONTYPECODE",
           as: "SUBTYPE"
        }},      
        {$unwind: "$SUBTYPE"},  
        
        { $lookup: {
           from: "billgrp",
           localField: "BILLENTITYOBJID",
           foreignField: "ENTITYOBJID",
           as: "BILLGRP"
        }},
        {$unwind: "$BILLGRP"},
        
        { $lookup: {
           from: "cusin_subscription",
           localField: "SUBSCRIPTIONNUMBER",
           foreignField: "OWNER.OWNERID",
           as: "MS"
        }},
	    //{$unwind: "$MS"},
	    
        { $lookup: {
           from: "subscriptiontypeinformation",
           localField: "MS.SUBSCRIPTIONTYPE",
           foreignField: "SUBSCRIPTIONTYPECODE",
           as: "MS_STI"
        }},
        //{$unwind: "$MS_STI"},
        
        
        { $project: { 
          	"SUBSCRIPTIONID": 1,
          	"EXTRACARDSUBSCRIPTIONID": 1,
          	"SUBSCRIPTIONNUMBER": 1,
          	"MSISDN": "$SUBSCRIPTIONNUMBER",  
          	"C2BCACHEUID": {"$concat": ["mobilesubscription:", "$SUBSCRIPTIONNUMBER"]}, 
          	"SUBSCRIPTIONTYPE": 1, 
          	"SUBSCRIPTIONTYPECATEGORY": 1, 
          	"PAYMENTMETHOD": 1,
          	"BRANDID": 1, 
          	"BRANDDESCRIPTION": 1, 
          	"ACTIVATIONDATE": 1, 
          	"TRAFFICSTATUSCODE": 1, 
          	"TRAFFICDESCRIPTION": 1, 
          	"SUBSCRIPTIONSTATUS": 1, 
          	"TRAFFICSTATUSREASON": 1,
          	"CUSTOMERTARGETSEGMENT": 1, 
          	"MULTISUBSCRIPTIONNUMBER": 1, 
          	"BILLENTITYOBJID": 1, 
          	"REFERENCETEXTONBILL": 1, 
          	"AGREEMENTNUMBER": 1,
          	"SUB_NAME": "$ADDRESS.NAME", 
          	"SUB_NAME2": "$ADDRESS.NAME2", 
          	"SUB_NAME3": "$ADDRESS.NAME3",
          	"SUB_ADDRESSROW1": "$ADDRESS.ADDRESSROW1", 
          	"SUB_ADDRESSROW2": "$ADDRESS.ADDRESSROW2", 
          	"SUB_ADDRESSROW3": "$ADDRESS.ADDRESSROW3",
          	"SUB_CITY": "$ADDRESS.CITY", 
          	"SUB_ZIPCODE": "$ADDRESS.ZIPCODE", 
          	"OFFERINGNAME": "$SUBTYPE.INVOICETEXT", 
          	"COMMUNITYOWNER": "$MEMBER.COMMUNITYOWNER", 
          	"ACCOUNTNUMBER": "$BILLGRP.ACCOUNTNUMBER", 
          	"INVOICEDELIVERYMETHOD": "$BILLGRP.INVOICEDELIVERYMETHOD", 
          	"INVOICEDELIVERYMETHODDESCR": "$BILLGRP.INVOICEDELIVERYMETHODDESCR", 
			"BILLINGGROUPID": "$BILLGRP.BILLGROUPID",
			"BG_NAME1": "$BILLGRP.ADDRESS.NAME",
			"BG_NAME2": "$BILLGRP.ADDRESS.NAME2",
			"BG_NAME3": "$BILLGRP.ADDRESS.NAME3",
          	"BG_ADDRESSROW1": "$BILLGRP.ADDRESS.ADDRESSROW1", 
          	"BG_ADDRESSROW2": "$BILLGRP.ADDRESS.ADDRESSROW2", 
          	"BG_ADDRESSROW3": "$BILLGRP.ADDRESS.ADDRESSROW3", 
         	"BG_CITY": "$BILLGRP.ADDRESS.CITY",
         	"BG_ZIPCODE": "$BILLGRP.ADDRESS.ZIPCODE",
         	"CUSTOMERTYPE": "$CUSTOMER.CUSTOMERTYPE",
         	"CUSTOMERIDENTIFICATIONNUMBER": "$CUSTOMERIDENTIFICATIONNUMBER",
         	"CUS_NAME1": "$CUSTOMER.ADDRESS.NAME",
         	"CUS_NAME2": "$CUSTOMER.ADDRESS.NAME2",
         	"CUS_NAME3": "$CUSTOMER.ADDRESS.NAME3",
         	"CU_ADDRESSROW1": "$CUSTOMER.ADDRESS.ADDRESSROW1",
         	"CU_ADDRESSROW2": "$CUSTOMER.ADDRESS.ADDRESSROW2",
         	"CU_ADDRESSROW3": "$CUSTOMER.ADDRESS.ADDRESSROW3",
         	"CU_CITY": "$CUSTOMER.ADDRESS.CITY",
         	"CU_ZIPCODE": "$CUSTOMER.ADDRESS.ZIPCODE",
          	"COMMUNITYOWNER": "$MEMBER.COMMUNITYOWNER", 
          	"OWNERID": "$OWNER.OWNERID",
          	"RETAILERNUMBER": "$RETAILERNUMBER",
          	"SUPERVISIONLEVEL": "$SUPERVISIONLEVEL", 
          	"SUPERVISIONSTATUS": "$SUPERVISIONSTATUS", 
          	"SUPERVISIONDATE": "$SUPERVISIONDATE",
         	"MULTISUBSCRIPTIONTYPE": "$MS.SUBSCRIPTIONTYPE", 
         	"MULTISUBSCRIPTIONTYPECATEGORY": "$MS.SUBSCRIPTIONTYPECATEGORY", 
         	"MULTISUBSCRIPTIONTYPEDESCR": "$MS_STI.INVOICETEXT"

        }},
    ])