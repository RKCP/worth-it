package com.rkcp.worthit.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.math.BigDecimal;

@ConfigurationProperties(prefix = "app")
public record AppProperties(BigDecimal defaultReturnRate){

}
