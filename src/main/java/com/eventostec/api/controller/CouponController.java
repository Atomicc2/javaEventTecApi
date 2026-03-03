package com.eventostec.api.controller;

import com.eventostec.api.domain.coupon.Coupon;
import com.eventostec.api.domain.coupon.CouponRequestDTO;
import com.eventostec.api.service.CouponService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Tag(name = "Coupons", description = "Coupon and discount management")
@RestController
@RequestMapping("/api/coupon")
public class CouponController {

    @Autowired
    private CouponService couponService;

    @Operation(summary = "Get coupon by event id")
    @PostMapping("/{eventId}/coupon")
    public ResponseEntity<Coupon> addCouponToEvent(@PathVariable UUID eventId, @RequestBody CouponRequestDTO data) {
        Coupon coupons = couponService.addCouponToEvent(eventId, data);
        return ResponseEntity.ok(coupons);
    }

}