package com.gojeck.parkinglot.business;

import static org.junit.Assert.assertEquals;

import com.gojeck.parkinglot.business.impl.ParkingLotServiceImpl;
import com.gojeck.parkinglot.data.Car;
import org.junit.Test;

public class ParkingLotServiceTest {
	
	ParkingLotServiceImpl parkingLotService;
	
	@Test
	public void testParkCarAvailableSpace(){
		parkingLotService = new ParkingLotServiceImpl(1);
		int actual = parkingLotService.parkCar(new Car("21221","red"));
		assertEquals(1, actual);
	}
	
	@Test
	public void testParkCarNoAvailableSpace(){
		parkingLotService = new ParkingLotServiceImpl(0);
		int actual = parkingLotService.parkCar(new Car("21221","red"));
		assertEquals(-1, actual);
	}

	
	@Test
	public void testGetSlotNumberForRegistrationNumberCarPresent(){
		parkingLotService = new ParkingLotServiceImpl(1);
		parkingLotService.parkCar(new Car("21221","red"));
		int actual = parkingLotService.getSlotNumberForGivenRegistrationNumber("21221");
		assertEquals(1, actual);
	}
	
	@Test
	public void testGetSlotNumberForRegistrationNumberCarNotPresent(){
		parkingLotService = new ParkingLotServiceImpl(1);
		parkingLotService.parkCar(new Car("21221","red"));
		int actual = parkingLotService.getSlotNumberForGivenRegistrationNumber("21222");
		assertEquals(-1, actual);
	}
	
	
}