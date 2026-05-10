package com.rkcp.worthit;

import com.rkcp.worthit.configuration.AppProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(AppProperties.class)
public class WorthitApplication {

	public static void main(String[] args) {
		SpringApplication.run(WorthitApplication.class, args);
	}

}
