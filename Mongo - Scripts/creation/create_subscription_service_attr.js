var l = 1;
db.subscription_service.find().limit(150).forEach(function (sub){        
        db.subscription_service_attr.insert( {
            subscriptionid: sub.subscriptionid,
            clientsystem:"",
            extracardsubscriptionid: sub.extracardsubscriptionid,
            servicecode: "S_CODE_"+l,
            attributename: "A_NAME_"+l,
            attributevalue: "A_VALUE_"+l,
            attributedescription: "",
            eventnumber: "",
            userid: "",
            userchangedate: "",
            changetime: "",
            entityobjid: "",
            subscrentityobjid: ""
        }) 
        l++;
})
db.subscription_service.createIndex( { subscriptionid: 1, extracardsubscriptionid: 1, servicecode: 1} );