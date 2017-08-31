package com.metacube.ds2.collegecounselling;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

import com.metacube.ds2.collegecounselling.facade.CollegeFacade;
import com.metacube.ds2.collegecounselling.facade.StudentFacade;
import com.metacube.ds2.collegecounselling.model.BaseEntity;
import com.metacube.ds2.collegecounselling.model.Student;
import com.metacube.ds2.queue.Queue;

/**
 * This class is the main class of college Counselling application
 * 
 * @author Prateek Jain
 *
 */
public class CollegeCounselling {

	static Scanner scan = new Scanner(System.in);
	private static Queue students = new Queue();
	private static Map<Integer, BaseEntity> colleges = new HashMap<Integer, BaseEntity>();

	public static void main(String[] args) {
		students = StudentFacade.getInstance().getStudentQueueOrderByRank();
		colleges = CollegeFacade.getInstance().getMap();
		// loop continue till all seats are alloted or all students admitted in college
		while (CollegeFacade.getInstance().getAvailableNumberOfSeats() != 0 && students.peek() != null) {
			System.out.println("Student '" + ((BaseEntity) students.peek()).getName() + "'(Rank->"
					+ ((BaseEntity) students.peek()).getRank() + ") :");
			showCollegeList();
			System.out.println("Select college id: ");
			int id = getValidCollegeId();
			/*
			 * if seats are available then admit the student
			 * else display the message no seat is available
			 */
			if (CollegeFacade.getInstance().isSeatsAvailable(id)) {
				CollegeFacade.getInstance().admitStudentInCollege((Student) students.deque(), id);
				System.out.println("Admitted in college");
			} else {
				System.out.println("Opps! No seat available");
			}
		}
		printResult();
	}

	/**
	 * Method is used to get the valid college id from user
	 * @return
	 */
	private static int getValidCollegeId() {
		int id = -1;
		// loop continue till valid id is entered
		while (true) {
			try {
				id = scan.nextInt();
				// if college with that id is present then break the loop
				if (colleges.containsKey(id)) {
					break;
				}
				System.out.println("College Id is invalid. Try Again. ");
			} catch (InputMismatchException e) {
				System.out.println("Invalid Input. Try Again");
				scan.next();
			}
		}
		return id;
	}

	/**
	 * Method is used to print the result of counselling
	 */
	private static void printResult() {
		/*
		 * if students list is not empty then all students not got admission
		 * else all students got the admission
		 */
		if (students.getSize() != 0) {
			System.out.println("\nRest of the Students not got the Admission in any college as seats are full\n");
		} else {
			System.out.println("\nAll Students are admitted in the selected college\n");
		}
		
		System.out.println(StudentFacade.getInstance().getListOfAllStudentsWithAllocatedCollege());
	}

	/**
	 * Method is used to show the colleges list with details 
	 */
	private static void showCollegeList() {
		System.out.println(CollegeFacade.getInstance().getCollegeList());
	}

}
