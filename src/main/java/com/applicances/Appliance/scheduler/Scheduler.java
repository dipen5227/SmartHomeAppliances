package com.applicances.Appliance.scheduler;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.applicances.Appliance.util.Constant;

@Component
public class Scheduler {

	/*
	 * This Method will execute only once a year on 1st January 1:00 AM
	 */
	@Scheduled(cron = "0 0 1 1 1 ?")
	public void scheduleTask() {
		Constant.fanSpeed = 0;
		Constant.fanStatus = false;
		Constant.acStatus = false;
		Constant.lightStatus = false;
	}
}
