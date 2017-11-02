db.cusin_subscription.find().limit(10000000).forEach(function (sub){
    for (var k = 1; k <= 15; k++) {
        db.subscription_service.insert( {
            subscriptionid: sub.subscriptionid,
            clientsystem:"",
            extracardsubscriptionid: sub.extracardsubscriptionid,
            servicecode: "S_CODE_" + k,
            servicevalue: sub.subscriptionnumber + ":" +k,
            servicedescription:"",
            servicespecificnumber:"",
            servicenetwork:"",
            servicestatus:"",
            activationdate:"",
            deactivationdate:"",
            eventnumber:"",
            userid:"",
            userchangedate:"",
            changetime:"",
            entityobjid:"",
            subscrentityobjid :""
        }) 
    }
})
db.subscription_service.createIndex( { subscriptionid: 1, extracardsubscriptionid: 1} );
db.subscription_service.createIndex( { servicecode: 1} );