db.auth();
for (var i = 1; i <= 1000; i++) {
    db.subscriptiontypeinformation.insert( {
        id:""+i,
        subscriptiontypecode:"AH"+i,
        product:"",
        category:"mobile",
        classification:"",
        textlong:"",
        textshort:"",
        textboss:"",
        invoicetext:"invoicetext_" + i,
        description:"",
        operator:"",
        trademark:"",
        customersegments:"",
        gsmahscontractlabel:"",
        validforsimplesubscription:"",
        validforagreement:"",
        agreementtypes:"",
        useforoe:"",
        multisubscriptiontype:"",
        billingmodel:"",
        methodofbilling:"",
        launchdate:"",
        sellstopdate:"",
        note:"",
        customerinformation:"",
        allowbinding:"",
        showinvoiceminasidor:"",
        showinvoicemitthalebop:"",
        monthlyinvoice:"",
        delayedfirstinvoice:"",
        billingchangingfromprepaid:"",
        prepaidcommunity:"",
        flaterate:"",
        validfortjv:"",
        validforkax:"",
        channelmax:"",
        requiresmulconnection:"",
        bindingperiod:"",
        delayedactivation:"",
        subcategory:"",
        bindingservices:"",
        validfordelayedactivation:"",
        dataamountwarningsms:"",
        delayedactivationbilled:"",
        bindingperiods:""
    })
};
db.subscriptiontypeinformation.createIndex( subscriptiontypecode: 1);
var subtype = 1;
db.cusin_subscription.find().forEach( 
    function(sub){
        db.cusin_subscription.update(
        {_id: sub._id},
        {$set: { subscriptiontype: "EX" + subtype }}
        );
        
        if(subtype == 1000){
                subtype = 1;
        }else {
            subtype++;
        }       
    });
