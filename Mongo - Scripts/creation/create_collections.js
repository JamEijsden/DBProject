//cusin_SUBSCRIPTION
for (var i = 1; i <= 20; i++) {
  for (var j = 1; j <= 20; j++) {
   db.cusin_subscription.insert( { 
     SUBSCRIPTIONNUMBER : "46" + "" + i + "SUBNR" + j, 
     CUSTOMERNUMBER: "CUNR-" + i,
     SUBSCRIPTIONID: i + "SUBID" + j,
EXTRACARDSUBSCRIPTIONID: i + "EXTRA:SUBID" + j,
CLIENTSYSTEM: "Test",
SUBSCRIPTIONTYPE: "AH"+i,
CREATIONDATE: "",
SUBSCRIPTIONSTATUS: "Active",
SUPERVISIONSTATUS: "Inactive",
UNLISTED: "",
AGREEMENTNUMBER: "AGNR"+i+""+j,
COMMITMENTENDDATE: "",
COMMITMENTLENGTH: "",
EVENTNUMBER: "",
USERID: "",
USERCHANGEDATE: "",
CHANGETIME: "",
REFERENCETEXTONBILL: "REFERENCETEXTONBILL",
ACTIVATIONDATE: "2017-10-11",
DEACTIVATIONDATE: "",
RETAILERNUMBER: "",
TYPEDESCRIPTION: "",
PAYMENTMETHOD: "Card",
BRANDID: "Mobile1",
BRANDDESCRIPTION: "Mobile Subscription",
BILLINGGROUPID: "",
TRAFFICSTATUSCODE: "",
TRAFFICDESCRIPTION: "",
TRAFFICSTATUSREASON: "",
BILLENTITYOBJID: "BILLENT"+i,
SUBSCRIPTIONCREATIONSOURCE: "",
ADVERTINGINTEREST: "",
INCUSTOMERNUMBER: "",
TELEFINANSGROUP: "",
CREDITRATINGSTATUS: "",
SUPERVISIONDATE: "",
SUPERVISIONLEVEL: "",
SUBSCRIPTIONTYPEDESCR: "This is mobile sub",
CUSTOMERTARGETSEGMENT: "CUSTOMERTARGETSEGMENT"+i,
SUBSCRIPTIONTYPECATEGORY: "",
PRODUCT: "",
MTIME: "",
MULTISUBSCRIPTIONNUMBER: "",
MULTISUBSCRIPTIONSTATUS: "",
ADDRESS:{
	ADDRESSROW1: "Subgata "+i+""+j,
	ADDRESSROW2: "Testgata "+i+""+j,
	ADDRESSROW3: "Woowgata "+i+""+j,
	ZIPCODE: "44396",
	CITY: "Göteborg",
	COUNTRY: "Sweden",
	NAME: "Kalle "+i+""+j,
	NAME2: "Eva"+i+""+j,
	NAME3: "Tom"+i+""+j,
	EVENTNUMBER: "",
	ENTITYOBJID: ""
	}
 } )
}
}

//CUSTOMER
for (var i = 1; i <= 20; i++) {
   db.customer.insert( { 
CUSTOMERNUMBER: "CUNR-"+i,
CLIENTSYSTEM: "",
CUSTOMERIDENTIFICATIONNUMBER: "CIN-"+i,
CUSTOMERTYPE: "MOBILE",
GRANTEDPULLEVEL: "2",
VIPLEVEL: "",
EVENTNUMBER: "1234567",
USERID: "",
ADDRESS: {
	ADDRESSROW1: "Testgata "+i,
	ADDRESSROW2: "",
	ADDRESSROW3: "",
	ZIPCODE: "",
	CITY: "city"+1,
	COUNTRY: "",
	NAME: "Sven " + i,
	NAME2: "",
	NAME3: "",
	EVENTNUMBER: "",
	ENTITYOBJID: "",
	CUSTOMERNAME: "CUSTOMERNAME "+i,
	CUSTOMERADDRESS: "Kundgata "+i
	}
 } )
}



//BILLGRP

for (var i = 1; i <= 20; i++) {
   db.billgrp.insert( { 
ACCOUNTNUMBER: "ACCNUM_"+i,
CLIENTSYSTEM: "",
CUSTOMERNUMBER: "",
BILLINGGROUPID: "BILLGRPID"+i,
EVENTNUMBER: "",
USERID: "",
USERCHANGEDATE: "",
CHANGETIME: "",
DEACTIVATIONDATE: "",
ENTITYOBJID: "BILLENT"+i,
CUSTENTITYOBJID: "",
MTIME: "",
NOSPEC: "",
PRINTSPEC: "",
SINGLESUBSCRIPTIONBILLING: "",
INVOICEDELIVERYMETHOD: "INVDELMET_"+i,
INVOICEDELIVERYMETHODDESCR: "INVDELMETDESCR_"+i,
EMAILINVOICECONTACTPERSON: "",
EMAILINVOICEMOBILEPHONENUMBER: "",
EMAILINVOICEEMAILADDRESS: "",
ADDRESS: {
	ADDRESSROW1: "Hej_1"+i,
	ADDRESSROW2: "Hej_2"+i,
	ADDRESSROW3: "Hej_2"+i,
	ZIPCODE: "44396",
	CITY: "Göteborg",
	COUNTRY: "SE",
	NAME: "Kalle_" + i,
	NAME2: "Lotta_"+i,
	NAME3: "Nils_"+i,
	EVENTNUMBER: "",
	ENTITYOBJID: ""
	}
 } )
}

function randomString(length) { 
        var chars = 
"0123456789ABCDEFGHIJKLMNOPQRSTUVWXTZ"; 
        var randomstring = ''; 
        var string_length = length;
        for (var i=0; i<string_length; i++) { 
                var rnum = Math.floor(Math.random() * chars.length); 
                randomstring += chars.substring(rnum,rnum+1); 
        } 
        return randomstring; 
} 

// SUBSCRIPTIONTYPEINFORMATION
for (var i = 1; i <= 20; i++) {
db.subscriptiontypeinformation.insert( { 
ID:"",
SUBSCRIPTIONTYPECODE:"AH"+i,
PRODUCT:"",
CATEGORY:"mobile",
CLASSIFICATION:"",
TEXTLONG:"",
TEXTSHORT:"",
TEXTBOSS:"",
INVOICETEXT:"INVOICETEXT_" + i,
DESCRIPTION:"",
OPERATOR:"",
TRADEMARK:"",
CUSTOMERSEGMENTS:"",
GSMAHSCONTRACTLABEL:"",
VALIDFORSIMPLESUBSCRIPTION:"",
VALIDFORAGREEMENT:"",
AGREEMENTTYPES:"",
USEFOROE:"",
MULTISUBSCRIPTIONTYPE:"",
BILLINGMODEL:"",
METHODOFBILLING:"",
LAUNCHDATE:"",
SELLSTOPDATE:"",
NOTE:"",
CUSTOMERINFORMATION:"",
ALLOWBINDING:"",
SHOWINVOICEMINASIDOR:"",
SHOWINVOICEMITTHALEBOP:"",
MONTHLYINVOICE:"",
DELAYEDFIRSTINVOICE:"",
BILLINGCHANGINGFROMPREPAID:"",
PREPAIDCOMMUNITY:"",
FLATERATE:"",
VALIDFORTJV:"",
VALIDFORKAX:"",
CHANNELMAX:"",
REQUIRESMULCONNECTION:"",
BINDINGPERIOD:"",
DELAYEDACTIVATION:"",
SUBCATEGORY:"",
BINDINGSERVICES:"",
VALIDFORDELAYEDACTIVATION:"",
DATAAMOUNTWARNINGSMS:"",
DELAYEDACTIVATIONBILLED:"",
BINDINGPERIODS:""
})
}

for (var i = 1; i <= 200; i++) {
db.community_member.insert( {
COMMUNITYID:"COMM_ID_"+i,
MEMBERID:"46" + "" + i + "SUBNR" + j,
MEMBERCLASS:"",
COMMUNITYOWNER:"",
MEMBERINTERNALID:"",
MEMBERTYPE:"",
MEMBERSTATUS:"",
MEMBERDATA:"",
CREATEDATE:"",
NEXTCHANGEDATE:"",
USERID:"",
MTIME:"",
PRODUCT:"",
VALIDFROM:"",
VALIDTO:""  
  })  
}

var k=1;
for (var i = 11; i <= 20; i++){
for (var j = 1; j <= 20; j++){
    	
 	db.community_member.update( 
  		{MEMBERID:"46" + i + "SUBNR" + j},
		{$set: {COMMUNITYID:"COMM_ID"+k}}
	)
	k++;
}	
}

var k = 1;
for (var i = 11; i <= 20; i++){
for (var j = 1; j <= 20; j++){
    	
 	db.community_owner.update( 
  		{COMMUNITYID:"COMM_ID"+k},
		{$set: {OWNERID:"46" + i + "SUBNR" + j}}
	)
	k++;
}	
}

var k = 1;
for (var i = 1; i <= 10; i++){
for (var j = 1; j <= 20; j++){
    	
 	db.community_owner.update( 
  		{COMMUNITYID:"COMM_ID"+k},
		{$set: {OWNERID:"46" + (i+10) + "SUBNR" + j}}
	)
	k++;
}	
}


var k = 251000;
var l = 1;
for (var i = 1; i <= 20000;){

 	db.community_owner.update( 
  		{OWNERID:"46" + i + "CUST" + l},
		{$set: {COMMUNITYID:"COMM_ID" + k}}
	)					


		
	if(k >= 400000){
	  k = 1;
	}else {
	  k++;
	}	
	if(l >= 20){
	  l = 1;
	  i++;
	}else {
	  l++;
	}
	
}

for (var i = 1; i <= 200; i++) {
  db.community_owner.insert( {
COMMUNITYID:"COMM_ID"+i,
OWNERID:"",
OWNERCLASS:"",
OWNERIDTYPE:"",
OWNERTYPE:"",
OWNERINTERNALID:"",
MTIME :""
  }) 
    
}

for (var i = 1; i <= 50000; i++) {
  db.subscription_Service.insert( {
SUBSCRIPTIONID:"",
CLIENTSYSTEM:"",
EXTRACARDSUBSCRIPTIONID:"",
SERVICECODE:"",
SERVICEVALUE:"",
SERVICEDESCRIPTION:"",
SERVICESPECIFICNUMBER:"",
SERVICENETWORK:"",
SERVICESTATUS:"",
ACTIVATIONDATE:"",
DEACTIVATIONDATE:"",
EVENTNUMBER:"",
USERID:"",
USERCHANGEDATE:"",
CHANGETIME:"",
ENTITYOBJID:"",
SUBSCRENTITYOBJID :""
  }) 
}

db.community_owner.find({}).skip(251000);
//251000

 
 db.cusin_subscription.find(
 	{"SUBSCRIPTIONID":"89SUB1"} 
 )   
    
for (var i = 1; i <= 1; i++) {
   db.cusin_subscription.insert( { 
     SUBSCRIPTIONNUMBER : 46+""+i, 
     customerNumber: "66",
     SUBSCRIPTIONID: "",
EXTRACARDSUBSCRIPTIONID: "",
CLIENTSYSTEM: "",
SUBSCRIPTIONTYPE: "",
CREATIONDATE: "",
SUBSCRIPTIONSTATUS: "",
SUPERVISIONSTATUS: "",
UNLISTED: "",
AGREEMENTNUMBER: "",
COMMITMENTENDDATE: "",
COMMITMENTLENGTH: "",
EVENTNUMBER: "",
USERID: "",
USERCHANGEDATE: "",
CHANGETIME: "",
REFERENCETEXTONBILL: "",
ACTIVATIONDATE: "",
DEACTIVATIONDATE: "",
RETAILERNUMBER: "",
TYPEDESCRIPTION: "",
PAYMENTMETHOD: "",
BRANDID: "",
BRANDDESCRIPTION: "",
BILLINGGROUPID: "",
TRAFFICSTATUSCODE: "",
TRAFFICDESCRIPTION: "",
TRAFFICSTATUSREASON: "",
BILLENTITYOBJID: "",
SUBSCRIPTIONCREATIONSOURCE: "",
ADVERTINGINTEREST: "",
INCUSTOMERNUMBER: "",
TELEFINANSGROUP: "",
CREDITRATINGSTATUS: "",
SUPERVISIONDATE: "",
SUPERVISIONLEVEL: "",
SUBSCRIPTIONTYPEDESCR: "",
CUSTOMERTARGETSEGMENT: "",
SUBSCRIPTIONTYPECATEGORY: "",
PRODUCT: "",
MTIME: "",
MULTISUBSCRIPTIONNUMBER: "",
MULTISUBSCRIPTIONSTATUS: "",
ADDRESS: ""
 } )
}





