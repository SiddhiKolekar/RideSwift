package com.example.RideSwift.service;

import com.example.RideSwift.model.Coupon;
import com.example.RideSwift.repository.CouponRepository;
import com.example.RideSwift.transformer.CouponTransformer;
import org.springframework.stereotype.Service;

@Service
public class CouponService {
    private final CouponRepository couponRepository;

    public CouponService(CouponRepository couponRepository){
        this.couponRepository = couponRepository;
    }
    public String addCoupon(String couponCode, int discount) {
        Coupon coupon = CouponTransformer.prepareCoupon(couponCode, discount);
        couponRepository.save(coupon);
        return "Coupon saved successfully";
    }
}
