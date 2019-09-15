package com.gojeck.parkinglot.business;

import static org.junit.Assert.assertEquals;

import com.gojeck.parkinglot.business.impl.ParkingLotServiceImpl;
import com.gojeck.parkinglot.data.Car;
import org.junit.Test;

public class ParkingLotServiceTest {
	
	ParkingLotService parkingLotService;
	
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
	@Test
	public void testGetSlotNumberForColorCarPresent() {
		parkingLotService = new ParkingLotServiceImpl(1);
		parkingLotService.parkCar(new Car("21221", "white"));
		parkingLotService.getSlotNumberForGivenColor("white");
	}

	@Test
	public void testGetSlotNumberForColorCarNotPresent() {
		parkingLotService = new ParkingLotServiceImpl(1);
		parkingLotService.parkCar(new Car("21221", "white"));
		parkingLotService.getSlotNumberForGivenColor("red");
	}

	@Test
	public void testGetRegNumberForColorCarPresent() {
		parkingLotService = new ParkingLotServiceImpl(1);
		parkingLotService.parkCar(new Car("21221", "white"));
		parkingLotService.getRegistrationNumberForGivenColor("white");
	}

	@Test
	public void testGetRegNumberForColorCarNotPresent() {
		parkingLotService = new ParkingLotServiceImpl(1);
		parkingLotService.parkCar(new Car("21221", "white"));
		parkingLotService.getRegistrationNumberForGivenColor("red");
	}

	@Test
	public void testLeaveCarWithCorrectSlotNumber() {
		parkingLotService = new ParkingLotServiceImpl(1);
		int slot = parkingLotService.parkCar(new Car("21221", "white"));
		parkingLotService.leaveCar(slot-1);
	}

	@Test
	public void testLeaveCarWithWrongSlotNumber() {
		parkingLotService = new ParkingLotServiceImpl(1);
		parkingLotService.parkCar(new Car("21221", "white"));
		parkingLotService.leaveCar(2);
	}

	@Test
	public void testStatus() {
		parkingLotService = new ParkingLotServiceImpl(1);
		parkingLotService.parkCar(new Car("21221", "white"));
		parkingLotService.getStatus();
	}
	
}