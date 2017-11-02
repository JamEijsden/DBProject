db.cusin_subscription.aggregate([
    { $match: {subscriptiontype: "EX420"}},
    {
        $lookup: {
             from: "customer",
             localField: "customernumber",
             foreignField: "customernumber",
             as: "CUSTOMER"
         }
    },
    { $unwind: "$CUSTOMER"},
    {
        $lookup: {
             from: "community_member",
             localField: "subscriptionnumber",
             foreignField: "memberid",
             as: "MEMBER"
         }
    },
    //{ $unwind: "$MEMBER"},
    {
        $lookup: {
             from: "community_owner",
             localField: "MEMBER.communityid",
             foreignField: "communityid",
             as: "OWNER"
         }
    },
    //{ $unwind: "$OWNER"},
    {
        $lookup: {
             from: "subscriptiontypeinformation",
             localField: "subscriptiontype",
             foreignField: "subscriptiontypecode",
             as: "STI"
         }
    },
    { $unwind: "$STI"},
    { $project: {
        subscriptionnumber: 1,
        subscriptiontype: 1,
        customer: "$CUSTOMER",
        member: "$MEMBER",
        owner: "$OWNER",
        sti: "$STI"
        }
    },    
    { $match: {subscriptionnumber: "462420SUBNR4127379"}}
])