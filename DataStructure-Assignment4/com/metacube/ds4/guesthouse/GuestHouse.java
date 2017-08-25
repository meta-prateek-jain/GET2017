package com.metacube.ds4.guesthouse;

import java.util.Hashtable;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Set;

import com.metacube.ds4.guesthouse.enums.Status;
import com.metacube.ds4.guesthouse.facade.GuestHouseFacade;
import com.metacube.ds4.guesthouse.model.Guest;

/**
 * This is the main controller class of Guest house application
 * 
 * @author Prateek Jain
 *
 */
public class GuestHouse {

	private static GuestHouseFacade guestHouseFacade;
	private static Scanner scan;

	public static void main(String[] args) {
		scan = new Scanner(System.in);
		int numberOfRooms;
		int numberOfGuests;
		Hashtable<Integer, Guest> guestTable;
		// loop continue till valid number is entered
		while (true) {
			try {
				System.out
						.println("Enter the number of rooms in the Guest house");
				numberOfRooms = scan.nextInt();
				/*
				 * if number is less than 1 then display message that number
				 * should be greater than zero and take input again else break
				 * the loop
				 */
				if (numberOfRooms < 1) {
					System.out
							.println("The number of room should be greater than 0.");
				}else if(isPrime(numberOfRooms) == Status.NOT_A_PRIME){
					System.out.println(isPrime(numberOfRooms).getString()+" Try Again");
				}
				else {
					break;
				}
			} catch (InputMismatchException e) {
				System.out.println("Invaliid Input. Try Again");
				scan.next();
			}
		}

		// loop continue till valid number is entered
		while (true) {
			try {
				System.out.println("Enter the number of Guests");
				numberOfGuests = scan.nextInt();
				/*
				 * if number is less than 1 and greater than number of rooms in
				 * guest house then display message that number should be
				 * greater than zero and less than number of rooms available and
				 * take input again else break the loop
				 */
				if (numberOfGuests > 1 && numberOfGuests <= numberOfRooms) {
					break;
				}
				System.out
						.println("The number of room should be greater than 0. and less than available rooms in guest house : "
								+ numberOfRooms);

			} catch (InputMismatchException e) {
				System.out.println("Invaliid Input. Try Again");
				scan.next();
			}
		}

		guestHouseFacade = new GuestHouseFacade(numberOfRooms, numberOfGuests);
		System.out.println("Enter the details of guests");
		for (int index = 0; index < numberOfGuests; index++) {
			System.out.println("Enter the detail of Guest " + (index + 1));
			System.out.print("Name : ");
			String name = scan.next();
			int age;
			while (true) {
				System.out.print("\nAge : ");
				try {
					age = scan.nextInt();
					if (age > 1 && age < 120) {
						break;
					}
					System.out.println("Enter a valid Age");
				} catch (InputMismatchException e) {
					System.out.println("Invalid input. Try again");
					scan.next();
				}
			}
			System.out.println(guestHouseFacade.allotRoom(new Guest(name, age))
					.getString());
		}
		guestTable = guestHouseFacade.getAllotedRoomTable();
		Set<Integer> rooms = guestTable.keySet();
		for (Integer roomNo : rooms) {
			System.out.println("Room : " + roomNo + " --> "
					+ guestTable.get(roomNo).toString());
		}
	}
	private static Status isPrime(int number){
		Status status = null;
		if (number == 2 || number == 3) {
			status = Status.PRIME;
		} else if (number == 1 || number % 2 == 0) {
			status = Status.NOT_A_PRIME;
		} else {
			for (int i = 3; i * i <= number; i += 2)
				if (number % i == 0) {
					status = Status.NOT_A_PRIME;
				} else {
					status = Status.PRIME;
				}
		}
		return status;
	}
}
