db.auth("jimmie","");
for(var i = 1; i <= 6000000; i++){
        db.billgrp.insert( {
            accountnumber: "ACCNUM_"+i,
            clientsystem: "",
            customernumber: "CUNR-"+i,
            billinggroupid: "BILLGRPID"+i,
            eventnumber: "",
            userid: "",
            userchangedate: "",
            changetime: "",
            deactivationdate: "",
            entityobjid: "BILLENT"+i,
            custentityobjid: "",
            mtime: "",
            nospec: "",
            printspec: "",
            singlesubscriptionbilling: "",
            invoicedeliverymethod: "INVDELMET_"+i,
            invoicedeliverymethoddescr: "INVDELMETDESCR_"+i,
            emailinvoicecontactperson: "",
            emailinvoicemobilephonenumber: "",
            emailinvoiceemailaddress: "",
            address: {
                addressrow1: "Billgrpg 1"+i,
                addressrow2: "Billgrpg 2"+i,
                addressrow3: "Billgrpg 3"+i,
                zipcode: "44396",
                city: "Göteborg",
                country: "SE",
                name: "Kalle_" + i,
                name2: "Lotta_"+i,
                name3: "Nils_"+i,
                eventnumber: "",
                entityobjid: ""
            }
    })  
};
db.billgrp.createIndex( { entityobjid: 1 } );