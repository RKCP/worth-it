package com.rkcp.worthit.service;

import com.rkcp.worthit.configuration.AppProperties;
import com.rkcp.worthit.dto.PurchaseDecisionRequest;
import com.rkcp.worthit.dto.PurchaseDecisionResponse;
import com.rkcp.worthit.util.CompoundInterestCalculator;
import org.springframework.stereotype.Service;
import java.math.RoundingMode;

import java.math.BigDecimal;

@Service
public class PurchaseDecisionService {

    private final AppProperties appProperties;

    // 0.1 + 0.2 in double would be 0.30000000000000004 which is bad
    // for now will pass this manually with field

    // later on add config/settings where user selects what they want to compare against:
    // - bank of england base rate/savings rate
    // - S&P 500 historical average
    // - FTSE Global All Cap
    // - Market return minus inflation

    public PurchaseDecisionService(AppProperties appProperties) {
        this.appProperties = appProperties;
    }


    public PurchaseDecisionResponse generatePurchaseDecision(PurchaseDecisionRequest pdRequest) {
        // Break down request
        String itemName = pdRequest.itemName();
        BigDecimal itemPrice = pdRequest.price();
        int yearsToOwn = pdRequest.expectedOwnershipPeriod();

        // call compound interest calculator
        CompoundInterestCalculator cic = new CompoundInterestCalculator();
        BigDecimal compoundInterest = cic.calculate(
                itemPrice,
                yearsToOwn,
                appProperties.defaultReturnRate()); // TODO: change this to a dynamic rate
        BigDecimal diff = compoundInterest.subtract(itemPrice).setScale(2, RoundingMode.HALF_UP);
        BigDecimal compInterestFixed = compoundInterest.setScale(2, RoundingMode.HALF_UP);

        // create resp and return
        return new PurchaseDecisionResponse(
                itemName,
                itemPrice,
                compInterestFixed,
                diff,
                String.format("Buying %s today could cost you %s in future growth over %s years.",
                        itemName, compInterestFixed, yearsToOwn));
    }
}
