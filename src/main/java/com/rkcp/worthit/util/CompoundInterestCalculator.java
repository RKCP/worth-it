package com.rkcp.worthit.util;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class CompoundInterestCalculator {

    public CompoundInterestCalculator() {
    }

    public BigDecimal calculate(BigDecimal price, int years, BigDecimal rate) {
        double growthFactor = Math.pow(1 + rate.doubleValue(), years);
        BigDecimal futureValue = price.multiply(BigDecimal.valueOf(growthFactor));
        // formula from AI

        return futureValue;
    }
}
