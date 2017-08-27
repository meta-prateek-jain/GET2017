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
				System.out.println("Enter the number of rooms in the Guest house");
				numberOfRooms = scan.nextInt();
				/*
				 * if number is less than 1 then display message that number
				 * should be greater than zero and take input again 
				 * else if number is not prime then print message not a prime 
				 * else break the loop
				 */
				if (numberOfRooms < 1) {
					System.out.println("The number should be greater than 0.");
				} else if (isPrime(numberOfRooms) == Status.NOT_A_PRIME) {
					System.out.println(isPrime(numberOfRooms).getString() + " Try Again");
				} else {
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
				 * if number is greater than 1 and less than number of rooms in
				 * guest house then break the loop
				 */
				if (numberOfGuests > 1 && numberOfGuests <= numberOfRooms) {
					break;
				}
				System.out.println("The number should be greater than 0. and less than Rooms available (Total rooms : "
						+ numberOfRooms + " )");

			} catch (InputMismatchException e) {
				System.out.println("Invaliid Input. Try Again");
				scan.next();
			}
		}

		guestHouseFacade = new GuestHouseFacade(numberOfRooms, numberOfGuests);
		System.out.println("Enter the details of guests");
		// loop continue till details of all guests is entered
		for (int index = 0; index < numberOfGuests; index++) {
			System.out.println("Enter the detail of Guest " + (index + 1));
			scan.nextLine();
			String name = "";
			// loop continue till input is entered
			while (true) {
				System.out.print("Name : ");
				name = scan.nextLine();
				// if name is entered then break the loop
				if (!name.isEmpty()) {
					break;
				}
				System.out.println("Please Enter something.");
			}
			int age;
			// loop continue till valid input is entered
			while (true) {
				System.out.print("\nAge : ");
				try {
					age = scan.nextInt();
					// if age is greater than 13 and less than 120 then valid so
					// break the loop
					if (age > 13 && age < 120) {
						break;
					}
					System.out.println("Enter a valid Age and minimum age to book room is 14");
				} catch (InputMismatchException e) {
					System.out.println("Invalid input. Try again");
					scan.next();
				}
			}
			System.out.println(guestHouseFacade.allotRoom(new Guest(name, age)).getString());
		}
		guestTable = guestHouseFacade.getAllotedRoomTable();
		Set<Integer> roomsChart = guestTable.keySet();
		// loop continue till all alloted rooms are printed
		for (Integer roomNo : roomsChart) {
			System.out.println("Room : " + roomNo + " --> " + guestTable.get(roomNo).toString());
		}
	}

	/**
	 * Method is used to check the number is prime or not
	 * 
	 * @param number
	 * @return
	 */
	private static Status isPrime(int number) {
		Status status = null;
		/*
		 * if number is 2 or 3 then it is a prime 
		 * else if number is 1 or divisible by 2 then it is not a prime 
		 * else check number is prime or not
		 */
		if (number == 2 || number == 3) {
			status = Status.PRIME;
		} else if (number == 1 || number % 2 == 0) {
			status = Status.NOT_A_PRIME;
		} else {
			// loop continue until number is checked whether prime or not
			for (int i = 3; i <= number / 2; i++)
				/*
				 * if number divisible by a number then return status Not A Prime 
				 * else return Prime
				 */
				if (number % i == 0) {
					status = Status.NOT_A_PRIME;
					break;
				} else {
					status = Status.PRIME;
				}
		}
		return status;
	}
}
