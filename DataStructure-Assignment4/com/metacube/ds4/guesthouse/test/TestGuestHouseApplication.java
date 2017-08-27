package com.metacube.ds4.guesthouse.test;

import static org.junit.Assert.*;

import java.util.Hashtable;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import com.metacube.ds4.guesthouse.enums.Status;
import com.metacube.ds4.guesthouse.facade.GuestHouseFacade;
import com.metacube.ds4.guesthouse.model.Guest;

/**
 * Class is used to Test the guest house application
 * 
 * @author Prateek Jain
 *
 */
public class TestGuestHouseApplication {

	GuestHouseFacade guestHouse;

	/**
	 * Method is setting up the class object
	 */
	@Before
	public void setUp() {
		guestHouse = new GuestHouseFacade(11, 3);
	}

	/**
	 * Testing hashCode function if returning same number for same input or not
	 */
	@Test
	public void testHashCode() {
		guestHouse.setAgeOfGuest(10);
		int output1 = guestHouse.hashCode();
		guestHouse.setAgeOfGuest(10);
		int output2 = guestHouse.hashCode();
		assertEquals(output1, output2);
	}

	/**
	 * Method is used to test room allotment when no of guest is greater than no of rooms
	 */
	@Test
	public void testAllotRoomWhenNoOfGuestLessThanNoOfRooms() {
		Status status;
		guestHouse = new GuestHouseFacade(3, 2);
		status = guestHouse.allotRoom(new Guest("ramesh", 18));
		assertEquals("Guest 1", Status.ROOM_ALLOTED, status);
		status = guestHouse.allotRoom(new Guest("suresh", 25));
		assertEquals("Guest 2", Status.ROOM_ALLOTED, status);
	}
	
	/**
	 * Method is used to test room allotment when no of guest is greater than no of rooms
	 */
	@Test
	public void testAllotRoomWhenNoOfGuestsGreaterThanNoOfRooms() {
		Status status;
		guestHouse = new GuestHouseFacade(3, 4);
		status = guestHouse.allotRoom(new Guest("ramesh", 18));
		assertEquals("Guest 1", Status.ROOM_ALLOTED, status);
		status = guestHouse.allotRoom(new Guest("suresh", 25));
		assertEquals("Guest 2", Status.ROOM_ALLOTED, status);
		status = guestHouse.allotRoom(new Guest("mahesh", 27));
		assertEquals("Guest 3", Status.ROOM_ALLOTED, status);
		status = guestHouse.allotRoom(new Guest("shyam", 55));
		assertNotEquals("Guest 4", Status.ROOM_ALLOTED, status);
	}

	/**
	 * Method is used to test the room allotment when guests have different age
	 */
	@Test
	public void testAllotedRoomWhenGuestsHaveDifferentAge() {
		Hashtable<Integer, Guest> guestTable;
		String actual = "";
		guestHouse = new GuestHouseFacade(5, 3);
		guestHouse.allotRoom(new Guest("ramesh", 18));
		guestHouse.allotRoom(new Guest("suresh", 25));
		guestHouse.allotRoom(new Guest("mahesh", 27));
		guestTable = guestHouse.getAllotedRoomTable();
		Set<Integer> roomsChart = guestTable.keySet();
		//loop continue till end of hashTable
		for (Integer roomNo : roomsChart) {
			actual += guestTable.get(roomNo).getName()+" - "+roomNo+"\n";
		}
		String expected = "ramesh - 4\nmahesh - 3\nsuresh - 1\n";
		assertEquals(expected, actual);
	}
	
	/**
	 * Method is used to test the room allotment when guests have same and different age
	 */
	@Test
	public void testAllotedRoomWhenGuestsHaveSameAndDifferentAge() {
		Hashtable<Integer, Guest> guestTable;
		String actual = "";
		guestHouse = new GuestHouseFacade(5, 3);
		guestHouse.allotRoom(new Guest("ramesh", 18));
		guestHouse.allotRoom(new Guest("suresh", 18));
		guestHouse.allotRoom(new Guest("mahesh", 27));
		guestTable = guestHouse.getAllotedRoomTable();
		Set<Integer> roomsChart = guestTable.keySet();
		//loop continue till end of hashTable
		for (Integer roomNo : roomsChart) {
			actual += guestTable.get(roomNo).getName()+" - "+roomNo+"\n";
		}
		String expected = "suresh - 5\nramesh - 4\nmahesh - 3\n";
		assertEquals(expected, actual);
	}
}
