package com.rkcp.worthit.dto;

public record PurchaseDecisionResponse(
        String itemName,
        double price,
        double futureValue,
        double interestGained,
        String message) {}
