db.auth();
var com_id = 1;
db.community_member.find().skip(400000).limit(400000).forEach( 
    function(i) {
        db.community_owner.insert( {
            communityid:"COMM_ID_"+com_id,
            ownerid:i.memberid,
            ownerclass:"",
            owneridtype:"",
            ownertype:"",
            ownerinternalid:"",
            mtime :""
    }) 
    com_id++;
});
db.community_owner.createIndex( { ownerid: 1 } );
db.community_owner.createIndex( { communityid: 1 } );
db.community_member.find().skip(400000).limit(400000).forEach( function(owner) {    
    db.community_member.update(
        {_id: owner._id},
        {$set: { "communityowner": "YES"}}
    );
})