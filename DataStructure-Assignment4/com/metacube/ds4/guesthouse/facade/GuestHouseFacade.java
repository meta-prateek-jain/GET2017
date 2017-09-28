package com.metacube.ds4.guesthouse.facade;

import java.util.Hashtable;
import java.util.LinkedList;
import java.util.Queue;

import com.metacube.ds4.guesthouse.enums.Status;
import com.metacube.ds4.guesthouse.model.Guest;

/**
 * Class contains all the business logic to allot the rooms to the guest on the
 * basis of their age
 * 
 * @author Prateek Jain
 *
 */
public class GuestHouseFacade {

	int totalNumberOfRooms;
	int totalNumberOfGuests;
	int ageOfGuest;
	GuestHouseFacade guestHouseFacade;
	Queue<Integer> availableRooms = new LinkedList<Integer>();
	Hashtable<Integer, Guest> allotedRoomTable = new Hashtable<Integer, Guest>();

	/**
	 * constructor to initialize the variables
	 * 
	 * @param numberOfRooms
	 * @param numberOfGuests
	 */
	public GuestHouseFacade(int numberOfRooms, int numberOfGuests) {
		this.totalNumberOfRooms = numberOfRooms;
		this.totalNumberOfGuests = numberOfGuests;
		initializeAvailableRoomsList(numberOfRooms);
	}

	public GuestHouseFacade() {
		
	}
	/**
	 * Method to initialize the available rooms queue
	 * 
	 * @param numberOfRooms
	 */
	private void initializeAvailableRoomsList(int numberOfRooms) {
		int count = 1;
		// loop continue till count is less than total number of rooms
		while (count <= numberOfRooms) {
			availableRooms.add(numberOfRooms--);
		}
	}

	/**
	 * Method is used to allot the room to the guest
	 * 
	 * @param guest
	 * @return
	 */
	public Status allotRoom(Guest guest) {
		Status status = Status.ROOM_NOT_AVAILABLE;
		ageOfGuest = guest.getAge();
		int roomNo = hashCode();
		// if room is available then allot the room
		if (roomNo != -1) {
			availableRooms.remove(roomNo);
			allotedRoomTable.put(roomNo, guest);
			status = Status.ROOM_ALLOTED;
		}
		return status;
	}

	/**
	 * Hash code function to get the room no for the guest according to their age
	 */
	@Override
	public int hashCode() {
		int room = (this.ageOfGuest % totalNumberOfRooms) + 1;
		// if room is already alloted then get the new room no. from available rooms list
		if (allotedRoomTable.containsKey(room)) {
			/*
			 * if their is a room available which is not alloted then return this room no 
			 * else return -1
			 */
			if (availableRooms.peek() != null) {
				room = availableRooms.poll();
			} else {
				room = -1;
			}
		}
		return room;
	}

	/**
	 * @return the allotedRoomTable
	 */
	public Hashtable<Integer, Guest> getAllotedRoomTable() {
		return allotedRoomTable;
	}

	public int getAgeOfGuest() {
		return ageOfGuest;
	}

	public void setAgeOfGuest(int ageOfGuest) {
		this.ageOfGuest = ageOfGuest;
	}
}
