package com.applicances.Appliance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.applicances.Appliance.service.ApplianceService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Appliance", description = "Appliance Status Change")
@RestController
@RequestMapping("/api/appliances")
public class ApplianceController {

	@Autowired
	ApplianceService applianceService;

	/*
	 * For Turn Off Fan
	 */
	@Operation(summary = "TURN OFF,ON Fan")
	@Parameter(schema = @Schema(allowableValues = { "0", "1", "2" }), name = "fanSpeed")
	@PostMapping(path = "fan")
	@ResponseBody
	public ResponseEntity<?> turnOffFan(@RequestParam("fanSpeed") int fanSpeed) {
		if (fanSpeed == 0 || fanSpeed == 1 || fanSpeed == 2) {
			String response = applianceService.turnOffFan(fanSpeed);
			return ResponseEntity.status(HttpStatus.OK).body(response);
		} else
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid Input");
	}

	/*
	 * For Turn Off Light
	 */
	@Operation(summary = "TURN OFF,ON Light")
	@Parameter(schema = @Schema(allowableValues = { "ON", "OFF" }), name = "position")
	@PostMapping(path = "light")
	@ResponseBody
	public ResponseEntity<?> turnOffLight(@RequestParam("position") String position) {

		if (position.equals("OFF") || position.equals("ON")) {
			String response = applianceService.turnOffLight(position);
			return ResponseEntity.status(HttpStatus.OK).body(response);
		} else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid Input");
		}
	}

	/*
	 * For Turn Off Air Conditioner
	 */
	@Operation(summary = "TURN OFF,ON AirConditioner")
	@Parameter(schema = @Schema(allowableValues = { "ON", "OFF" }), name = "mode")
	@PostMapping(path = "ac")
	@ResponseBody
	public ResponseEntity<?> turnOffairConditioner(@RequestParam("mode") String mode) {

		if (mode.equals("OFF") || mode.equals("ON")) {
			String response = applianceService.turnOffairConditioner(mode);
			return ResponseEntity.status(HttpStatus.OK).body(response);
		} else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid Input");
		}

	}

}
