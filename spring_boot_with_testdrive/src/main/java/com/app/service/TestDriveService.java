package com.app.service;

import java.util.List;

import com.app.dto.CarBookingUpdateDTO;
import com.app.dto.TestDriveDTO;
import com.app.dto.TestDriveUpdateDTO;
import com.app.entity.CarBooking;
import com.app.entity.TestDrive;

public interface TestDriveService {

		List<TestDrive> getAllTestDrives();
	
		TestDrive addTestDrive (TestDriveDTO testDriveDTO);

	    String deleteTestDrive(Long testDriveId);

	    TestDrive updateTestDrive(Long testDriveId, TestDriveUpdateDTO testDriveUpdateDTO);

	
}
