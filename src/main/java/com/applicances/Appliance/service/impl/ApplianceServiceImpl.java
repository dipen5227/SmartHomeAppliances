package com.applicances.Appliance.service.impl;

import org.springframework.stereotype.Service;

import com.applicances.Appliance.Exceptions.CustomRuntimeException;
import com.applicances.Appliance.service.ApplianceService;
import com.applicances.Appliance.util.Constant;

@Service
public class ApplianceServiceImpl implements ApplianceService {

	@Override
	public String turnOffLight(String position) {
		try {
			if (position.equals("OFF")) {
				if (Constant.lightStatus) {
					Constant.lightStatus = false;
					return "Light Successfully Turn OFF";
				} else
					return "Already OFF";

			} else {
				if (!Constant.lightStatus) {
					Constant.lightStatus = true;
					return "Light Successfully Turn ON";
				} else
					return "Already ON";
			}
		} catch (Exception e) {
			throw new CustomRuntimeException("Exception  : " + e.getMessage());
		}

	}

	@Override
	public String turnOffFan(int fanSpeed) {
		try {
			int fanSpeedStatus;
			Integer speed = Integer.valueOf(fanSpeed);

			switch (speed) {
			case 0:
				fanSpeedStatus = Constant.fanSpeed;
				Constant.fanSpeed = 0;
				Constant.fanStatus = false;
				return fanSpeedStatus == 0 ? "Fan Already OFF" : "Successfully Turn Off Fan";
			case 1:
				fanSpeedStatus = Constant.fanSpeed;
				Constant.fanSpeed = 1;
				Constant.fanStatus = true;
				return fanSpeedStatus == 0 ? "Fan Successfully Start"
						: "Fan Speed Successfully set to 1 From " + fanSpeedStatus;
			case 2:
				fanSpeedStatus = Constant.fanSpeed;
				Constant.fanSpeed = 2;
				Constant.fanStatus = true;
				return fanSpeedStatus == 0 ? "Fan Successfully Start"
						: "Fan Speed Successfully set to 2 From " + fanSpeedStatus;
			default:
				throw new CustomRuntimeException("Invalid Input");
			}

		} catch (Exception e) {
			throw new CustomRuntimeException("Invalid Input");
		}
	}

	@Override
	public String turnOffairConditioner(String mode) {
		try {
			if (mode.equals("OFF")) {
				if (Constant.acStatus) {
					Constant.acStatus = false;
					return "AirConditioner Successfully Turn OFF";
				} else
					return "AirConditioner Already OFF";

			} else {
				if (!Constant.acStatus) {
					Constant.acStatus = true;
					return "AirConditioner Successfully Turn ON";
				} else
					return "AirConditioner Already ON";
			}
		} catch (Exception e) {
			throw new CustomRuntimeException("Exception  : " + e.getMessage());
		}
	}

}
