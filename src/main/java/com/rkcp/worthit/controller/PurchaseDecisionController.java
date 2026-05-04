package com.rkcp.worthit.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("purchase-decisions")
public class PurchaseDecisionController {

    @GetMapping(value = "/{amount}", produces = "application/json")
    public String echoInputAmount(@PathVariable int amount) {
        return "You saved: £" + amount;
    }
}
