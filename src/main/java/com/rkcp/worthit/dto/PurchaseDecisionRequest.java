package com.rkcp.worthit.dto;

import java.math.BigDecimal;

public record PurchaseDecisionRequest(
        String itemName,
        BigDecimal price,
        int expectedOwnershipPeriod) {}
