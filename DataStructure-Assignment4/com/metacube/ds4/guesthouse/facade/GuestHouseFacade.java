package com.metacube.ds4.guesthouse.facade;

import java.util.Hashtable;
import java.util.LinkedList;
import java.util.Queue;

import com.metacube.ds4.guesthouse.enums.Status;
import com.metacube.ds4.guesthouse.model.Guest;

public class GuestHouseFacade {

	int totalNumberOfRooms;
	int totalNumberOfGuests;
	int ageOfGuest;
	GuestHouseFacade guestHouseFacade;
	Queue<Integer> availableRooms = new LinkedList<Integer>();
	Hashtable<Integer, Guest> allotedRoomTable = new Hashtable<Integer, Guest>();

	public GuestHouseFacade(int numberOfRooms, int numberOfGuests) {
		this.totalNumberOfRooms = numberOfRooms;
		this.totalNumberOfGuests = numberOfGuests;
		initializeAvailableRoomsList(numberOfRooms);
	}

	private void initializeAvailableRoomsList(int numberOfRooms) {
		int count = 1;
		while (count <= numberOfRooms) {
			availableRooms.add(numberOfRooms--);
		}
	}

	public GuestHouseFacade getInstance(int numberOfRooms, int numberOfGuests) {
		if (guestHouseFacade == null) {
			synchronized (GuestHouseFacade.class) {
				if (guestHouseFacade == null) {
					guestHouseFacade = new GuestHouseFacade(numberOfRooms,
							numberOfGuests);
				}
			}
		}
		return guestHouseFacade;
	}

	public Status allotRoom(Guest guest) {
		Status status = Status.ROOM_NOT_AVAILABLE;
		ageOfGuest = guest.getAge();
		int roomNo = hashCode();
		if (roomNo != -1) {
			availableRooms.remove(roomNo);
			allotedRoomTable.put(roomNo, guest);
			status = Status.ROOM_ALLOTED;
		}
		return status;
	}

	@Override
	public int hashCode() {
		int room = (this.ageOfGuest % totalNumberOfRooms) + 1;
		if (allotedRoomTable.containsKey(room)) {
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
}
