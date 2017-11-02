
function randomString(length) { 
        var chars = 
"0123456789ABCDEFGHIJKLMNOPQRSTUVWXTZabcdefghiklmnopqrstuvwxyz"; 
        var randomstring = ''; 
        var string_length = length;
        for (var i=0; i<string_length; i++) { 
                var rnum = Math.floor(Math.random() * chars.length); 
                randomstring += chars.substring(rnum,rnum+1); 
        } 
        return randomstring; 
} 

for(var i=0; i<200; i++){db.test.save({x:i, data:randomString(2)});} 

db.community_member.update( 
  		{MEMBERID:"46" + 1 + "CUST" + 1},
		{$set: {COMMUNITYID:"COMM_ID_" + 1}}
	)
	
	
var k = 1;
var l = 1;
for (var i = 1; i <= 20000;){

 	db.community_owner.update( 
  		{OWNERID:"46" + i + "CUST" + l},
		{$set: {COMMUNITYID:"COMM_ID_" + k}}
	)					
		
	if(k >= 400000){
	  k = 1;
	}else {
	  k++;
	}	
	if(l >= 20){
	  l = 1;
	  i++;
	}else {
	  l++;
	}
	
}	

db.community_owner.find({}).skip(150000);