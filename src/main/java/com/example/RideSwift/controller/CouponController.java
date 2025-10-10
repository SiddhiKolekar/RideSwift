package com.example.RideSwift.controller;

import com.example.RideSwift.model.Coupon;
import com.example.RideSwift.service.CouponService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/coupon")
public class CouponController {
    private final CouponService couponService;

    public CouponController(CouponService couponService){
        this.couponService = couponService;
    }
    @PostMapping
    public ResponseEntity<String> addCoupon(@RequestParam("coupon-code") String couponCode,
                                            @RequestParam("percentage-discount") int discount){
        String response = couponService.addCoupon(couponCode, discount);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
