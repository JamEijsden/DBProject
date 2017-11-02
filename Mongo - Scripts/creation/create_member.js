var com_id = 1;
db.cusin_subscription.find().limit(1000000)
    .forEach( function(i) { 
        db.community_member.insert( {
            communityid: "COMM_ID_" + com_id,
            memberid: i.subscriptionnumber,
            memberclass:"",
            communityowner:"NO",
            memberinternalid:"",
            membertype:"",
            memberstatus:"",
            memberdata:"",
            createdate:"",
            nextchangedate:"",
            userid:"",
            mtime:"",
            product:"",
            validfrom:"",
            validto:"" 
        })
        if(com_id == 400000) {
            com_id = 1;
        } else {
            com_id++;
        }
    });         
db.community_member.createIndex( { memberid: 1 } );
db.community_member.createIndex( { communityid: 1 } );