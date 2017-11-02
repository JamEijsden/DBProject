//cusin_SUBSCRIPTION
var customer;
var number_subscriptions = 100;
for (var i = 1; i <= number_subscriptions; i++) {
    var customer = Math.floor(_rand()*6000000);
    db.cusin_subscription.insert( { 
        subscriptionnumber : "46" + i + "SUBNR" + customer,
        customernumber: "CUNR-" + customer,
        subscriptionid: i + "SUBID" + customer,
        extracardsubscriptionid: i + "EXTRA:SUBID" + customer,
        clientsystem: "Test",
        subscriptiontype: "AH"+i,
        creationdate: "",
        subscriptionstatus: "Active",
        supervisionstatus: "Inactive",
        unlisted: "",
        agreementnumber: "AGNR"+i+""+customer,
        commitmentenddate: "",
        commitmentlength: "",
        eventnumber: "",
        userid: "",
        userchangedate: "",
        changetime: "",
        referencetextonbill: "REFERENCETEXTONBILL",
        activationdate: "2017-10-11",
        deactivationdate: "",
        retailernumber: "",
        typedescription: "",
        paymentmethod: "Card",
        brandid: "Mobile1",
        branddescription: "Mobile Subscription",
        billinggroupid: "",
        trafficstatuscode: "",
        trafficdescription: "",
        trafficstatusreason: "",
        billentityobjid: "BILLENT"+customer,
        subscriptioncreationsource: "",
        advertinginterest: "",
        incustomernumber: "",
        telefinansgroup: "",
        creditratingstatus: "",
        supervisiondate: "",
        supervisionlevel: "",
        subscriptiontypedescr: "This is mobile sub",
        customertargetsegment: "CUSTOMERTARGETSEGMENT"+customer,
        subscriptiontypecategory: "",
        product: "",
        mtime: "",
        multisubscriptionnumber: "",
        multisubscriptionstatus: "",
        address:{
            addressrow1: "Subgata "+i+""+customer,
            addressrow2: "Testgata "+i+""+customer,
            addressrow3: "Woowgata "+i+""+customer,
            zipcode: "44396",
            city: "Göteborg",
            country: "Sweden",
            name: "Kalle "+i+""+customer,
            name2: "Eva"+i+""+customer,
            name3: "Tom"+i+""+customer,
            eventnumber: "",
            entityobjid: ""
            }
        })
}
db.cusin_subscription.createIndex( { subscriptionnumber: 1 } );
db.cusin_subscription.createIndex( { subscriptionid: 1 } );
db.cusin_subscription.createIndex( { subscriptiontype: 1 } );
db.cusin_subscription.createIndex( { subscriptionid: 1, extracardsubscriptionid: 1} );

