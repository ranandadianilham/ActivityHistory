package com.eluon.nu.activityhistory.api.ActivityHistory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ActivityHistoryApplication {

	public static void main(String[] args) {
		SpringApplication.run(ActivityHistoryApplication.class, args);
	}

}
