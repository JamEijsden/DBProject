//CUSTOMER
for (var i = 1; i <= 20; i++) {
    db.customer.insert( {
        customernumber: "CUNR-"+i,
        clientsystem: "",
        customeridentificationnumber: "CIN-"+i,
        customertype: "MOBILE",
        grantedpullevel: "2",
        viplevel: "",
        eventnumber: "1234567",
        userid: "",
        address: {
            addressrow1: "Testgata "+i,
            addressrow2: "",
            addressrow3: "",
            zipcode: "",
            city: "city"+1,
            country: "",
            name: "Sven " + i,
            name2: "",
            name3: "",
            eventnumber: "",
            entityobjid: "",
            customername: "CUSTOMERNAME "+i,
            customeraddress: "Kundgata "+i
        }
    } )
}

db.customer.createIndex( { customernumber: 1 } );
db.customer.createIndex( { customeridentificationnumber: 1 } );