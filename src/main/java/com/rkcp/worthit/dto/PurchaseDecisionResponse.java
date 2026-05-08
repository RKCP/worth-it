package com.rkcp.worthit.dto;

import java.math.BigDecimal;

public record PurchaseDecisionResponse(
        String itemName,
        BigDecimal price,
        BigDecimal futureValue,
        BigDecimal interestGained,
        String message) {}
