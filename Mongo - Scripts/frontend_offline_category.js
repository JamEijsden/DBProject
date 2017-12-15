db.mobile_subscription.aggregate([     
    { $lookup: {
        from: "common_customer",
        localField: "cin_type",
        foreignField: "cin_pt",
        as: "COMMON_CUSTOMER"
    }}
])