package com.rkcp.worthit.dto;

public record PurchaseDecisionRequest(
        String itemName,
        double price,
        int expectedOwnershipPeriod) {}
