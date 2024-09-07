package com.applicances.Appliance.service;

public interface ApplianceService {

	public String turnOffFan(int id);

	public String turnOffLight(String position);

	public String turnOffairConditioner(String mode);
}
