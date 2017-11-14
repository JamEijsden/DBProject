//COMMON CUSTOMER
for (var i = 1; i <= 20; i++) {
    db.common_customer.insert( {
        customername: "C"+i,
        customeridentificationnumber: "8"+i,
        tscid: ""+i,
        alpha1partynumber: "APN"+i,
        partytype: "MOBILE",
        cin_pt: "8"+ i + ":" + "MOBILE",
        customerstatus: "ACTIVE"
    } )
}

db.common_customer.createIndex( { partytype: 1 } );
db.common_customer.createIndex( { customeridentificationnumber: 1 } );
db.common_customer.createIndex( { cin_type: 1 } );