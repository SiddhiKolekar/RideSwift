package com.example.RideSwift.transformer;

import com.example.RideSwift.model.Coupon;

public class CouponTransformer {
    public static Coupon prepareCoupon(String couponCode, int discount){
        return Coupon.builder()
                .couponCode(couponCode)
                .percentageDiscount(discount)
                .build();
    }
}
