var keyword = "46701";
db.mobile_subscription.find(
    {
        $or: [
            {msisdn: {$regex: "^"+keyword}},
            {customeridentification: {$regex: "^"+keyword}},
            {subscriptionid: {$regex: "^"+keyword}}
            ]
    },
    {
        msisdn: 1,
        customeridentification: 1,
        subscriptionid: 1
        }
).limit(20)//.explain("executionStats");