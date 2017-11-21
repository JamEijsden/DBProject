
db.cusin_subscription.aggregate([      
    { $match: {subscriptionnumber: /^4670/}},
    /*{ $lookup: {
    from: "customer",
    localField: "customernumber",
    foreignField: "customernumber",
    as: "CUSTOMER"
    }},    
    {$unwind: "$CUSTOMER"},
    
    { $lookup: {
    from: "community_member",
    localField: "subscriptionnumber",
    foreignField: "memberid",
    as: "MEMBER"
    }},
        { $lookup: {
    from: "community_owner",
    localField: "MEMBER.communityid",
    foreignField: "communityid",
    as: "OWNER"
    }},*/
    
    { $lookup: {
        from: "subscriptiontypeinformation",
        localField: "subscriptiontype",
        foreignField: "subscriptiontypecode",
        as: "SUBTYPE"
    }},
    //{$unwind: "$SUBTYPE"},
    
])