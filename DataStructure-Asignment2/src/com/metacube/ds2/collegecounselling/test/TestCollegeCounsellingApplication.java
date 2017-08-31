package com.metacube.ds2.collegecounselling.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.metacube.ds2.collegecounselling.facade.CollegeFacade;
import com.metacube.ds2.collegecounselling.facade.StudentFacade;
import com.metacube.ds2.collegecounselling.model.Student;
import com.metacube.ds2.queue.Queue;

public class TestCollegeCounsellingApplication {

	CollegeFacade collegeFacade;
	Queue students = new Queue();
	/**
	 * Method is used to setUp the Class object
	 */
	@Before
	public void setUp() {
		collegeFacade = CollegeFacade.getInstance();
		students = StudentFacade.getInstance().getStudentQueueOrderByRank();
	}
	/**
	 * Method is used to test College Counselling when Valid input is entered.
	 */
	@Test
	public void testCollegeCounsellingForValidInput() {
		collegeFacade.admitStudentInCollege((Student) students.deque(), 101);
		collegeFacade.admitStudentInCollege((Student) students.deque(), 102);
		collegeFacade.admitStudentInCollege((Student) students.deque(), 103);
		collegeFacade.admitStudentInCollege((Student) students.deque(), 102);
		collegeFacade.admitStudentInCollege((Student) students.deque(), 101);
		collegeFacade.admitStudentInCollege((Student) students.deque(), 102);
		collegeFacade.admitStudentInCollege((Student) students.deque(), 103);
		String actual = StudentFacade.getInstance().getListOfAllStudentsWithAllocatedCollege();
		String expected = "Id : 8 --> shubham --> 1 --> College : Id : 101 ---> JECRC"
				+ "\nId : 7 --> arpit --> 2 --> College : Id : 102 ---> Poornima"
				+ "\nId : 5 --> rohit --> 3 --> College : Id : 103 ---> GIT"
				+ "\nId : 9 --> archit --> 4 --> College : Id : 102 ---> Poornima"
				+ "\nId : 4 --> gaurav --> 5 --> College : Id : 101 ---> JECRC"
				+ "\nId : 12 --> harshit --> 6 --> College : Id : 102 ---> Poornima"
				+ "\nId : 6 --> garvit --> 7 --> College : Id : 103 ---> GIT"
				+ "\nId : 2 --> raman --> 8 --> College : No college is alloted"
				+ "\nId : 11 --> umang --> 9 --> College : No college is alloted"
				+ "\nId : 1 --> Aman --> 10 --> College : No college is alloted"
				+ "\nId : 10 --> prashant --> 11 --> College : No college is alloted"
				+ "\nId : 3 --> harman --> 12 --> College : No college is alloted\n";
		assertEquals(expected, actual);
	}

	/**
	 * Method is used to test College Counselling when Invalid input is entered.
	 */
	@Test
	public void testCollegeCounsellingForInValidInput() {
		collegeFacade.admitStudentInCollege((Student) students.deque(), 101);
		collegeFacade.admitStudentInCollege((Student) students.deque(), 105);
		collegeFacade.admitStudentInCollege((Student) students.deque(), 103);
		collegeFacade.admitStudentInCollege((Student) students.deque(), 106);
		collegeFacade.admitStudentInCollege((Student) students.deque(), 101);
		collegeFacade.admitStudentInCollege((Student) students.deque(), 102);
		collegeFacade.admitStudentInCollege((Student) students.deque(), 103);
		String actual = StudentFacade.getInstance().getListOfAllStudentsWithAllocatedCollege();
		String expected = "Id : 8 --> shubham --> 1 --> College : Id : 101 ---> JECRC"
				+ "\nId : 7 --> arpit --> 2 --> College : No college is alloted"
				+ "\nId : 5 --> rohit --> 3 --> College : Id : 103 ---> GIT"
				+ "\nId : 9 --> archit --> 4 --> College : No college is alloted"
				+ "\nId : 4 --> gaurav --> 5 --> College : Id : 101 ---> JECRC"
				+ "\nId : 12 --> harshit --> 6 --> College : Id : 102 ---> Poornima"
				+ "\nId : 6 --> garvit --> 7 --> College : Id : 103 ---> GIT"
				+ "\nId : 2 --> raman --> 8 --> College : No college is alloted"
				+ "\nId : 11 --> umang --> 9 --> College : No college is alloted"
				+ "\nId : 1 --> Aman --> 10 --> College : No college is alloted"
				+ "\nId : 10 --> prashant --> 11 --> College : No college is alloted"
				+ "\nId : 3 --> harman --> 12 --> College : No college is alloted\n";
		assertEquals(expected, actual);
	}
}
