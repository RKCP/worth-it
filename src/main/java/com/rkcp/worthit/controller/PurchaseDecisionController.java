package com.rkcp.worthit.controller;

import com.rkcp.worthit.dto.PurchaseDecisionRequest;
import com.rkcp.worthit.dto.PurchaseDecisionResponse;
import com.rkcp.worthit.service.PurchaseDecisionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("purchase-decisions")
public class PurchaseDecisionController {

    PurchaseDecisionService pdService = new PurchaseDecisionService();

    @GetMapping(value = "/{amount}", produces = "application/json")
    public String echoInputAmount(@PathVariable int amount) {
        return "You saved: £" + amount;
    }

    @PostMapping("/purchase-amount")
    public PurchaseDecisionResponse evaluatePurchaseDecision(@RequestBody PurchaseDecisionRequest pdRequest) {
        return pdService.generatePurchaseDecision(pdRequest);
    }
}
