db.auth("jimmie", "");
for (var i = 1; i <= 2000; i++) {
    db.serviceinformation.insert( { 
        id: "",
        servicecodeid: "SCID"+i,
        servicecodetype: "SCT"+i,
        servicecodeshort: "",
        product: "",
        servicecategory: "",
        classification: "",
        subservicetype: "",
        text: "",
        textshort: "",
        invoicetext: "IT"+i,
        description: "",
        operator: "",
        subscriptiontypecategorys: "",
        customersegments: "",
        validforsimplesubscription: "",
        validforagreement: "",
        agreementtypes: "",
        allowbinding: "",
        allowedbindings: "",
        servicefamily: "",
        valueclass: "",
        launchdate: "",
        sellstopdate: "",
        note: "",
        serviceadminchannels: "",
        availability: "",
        eqosid: "",
        eqosid_text: "",
        hss_esmprofileid: "",
        hss_esmprofileid_text: "",
        allowance: "A"+i,
        eqosids_limitation: "",
        scharvalue: "",
        scharvalue_pub_ip: "",
        amountcounter: "",
        mobiledatatopupservice: "",
        claescode: "",
        subservicetrafficvalue: "",
        trafficspeeddos: "",
        trafficspeedups: "",
        sendtobilling: "",
        sendtocommission: "",
        sendtoprepaid: "",
        nordic_euroconnect: "",
        validforcampaign: "",
        databalancefrompm: "",
        includeonconfirmation: "",
        accountingcode: "",
        financialmaterial: "",
        servicelevel1: "",
        servicelevel2: "",
        servicelevel3: ""
    })
}
db.serviceinformation.createIndex( { servicecodeid: 1 } );    
db.serviceinformation.createIndex( { servicecodeid: 1, servicecodetype: 1 } );  