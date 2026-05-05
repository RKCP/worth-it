package com.rkcp.worthit.dto;

public record PurchaseDecisionResponse(
        String itemName,
        double price,
        double futureValue,
        float interestGained,
        String message) {}
