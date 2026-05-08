package com.rkcp.worthit.service;

import com.rkcp.worthit.dto.PurchaseDecisionRequest;
import com.rkcp.worthit.dto.PurchaseDecisionResponse;
import com.rkcp.worthit.util.CompoundInterestCalculator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class PurchaseDecisionService {

    @Value("${default-return-rate}")
    private BigDecimal defaultReturnRate; // this is also big decimal since it participates in money math
    // 0.1 + 0.2 in double would be 0.30000000000000004 which is bad
    // for now will pass this manually with field

    // later on add config/settings where user selects what they want to compare against:
    // - bank of england base rate/savings rate
    // - S&P 500 historical average
    // - FTSE Global All Cap
    // - Market return minus inflation

    public PurchaseDecisionService() {
    }


    public PurchaseDecisionResponse generatePurchaseDecision(PurchaseDecisionRequest pdRequest) {
        // Break down request

        // call compound interest calculator
        CompoundInterestCalculator cic = new CompoundInterestCalculator();
        BigDecimal compoundInterest = cic.calculate(
                pdRequest.price(),
                pdRequest.expectedOwnershipPeriod(),
                defaultReturnRate); // TODO: change this to a dynamic rate

        // create resp and return

        return new PurchaseDecisionResponse(
                "AirPods Max",
                BigDecimal.valueOf(499.00),
                BigDecimal.valueOf(1077.30),
                        BigDecimal.valueOf(578.30),
                "Buying AirPods Max today could cost you £578.30 in future growth over 10 years.");
    }
}
