db.auth();
var i = 1;
db.getCollection('cusin_subscription').find().skip(10000000).limit(50000).forEach(   
    function(sub){
            sub.subscriptiontype = "EX"+i
            db.cusin_subscription.save(sub);
             if(i == 1000){
                i = 1;
            } else {
                i++;
            }
        }
);