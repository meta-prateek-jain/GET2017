package com.metacube.ds2.collegecounselling.facade;

import java.io.IOException;
import java.util.Map;

import com.metacube.ds2.collegecounselling.dao.BaseDao;
import com.metacube.ds2.collegecounselling.dao.DaoFactory;
import com.metacube.ds2.collegecounselling.enums.DBType;
import com.metacube.ds2.collegecounselling.enums.Entity;
import com.metacube.ds2.collegecounselling.model.BaseEntity;
import com.metacube.ds2.collegecounselling.model.College;
import com.metacube.ds2.collegecounselling.model.Student;

/**
 * This class contains all the business logics of college
 * 
 * @author Prateek Jain
 *
 */
public class CollegeFacade {
	private static CollegeFacade collegeFacade;
	private BaseDao collegeDao;

	// constructor to initialize the collegedao object
	private CollegeFacade() {
		try {
			collegeDao = DaoFactory.getDaoForEntity(Entity.COLLEGE, DBType.IN_MEMORY);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * This is used to create class singleton and get available instance
	 * 
	 * @return CollegeFacade
	 * @throws IOException
	 */
	synchronized public static CollegeFacade getInstance() {
		// if collegefacade is null then initialize it
		if (collegeFacade == null) {
			collegeFacade = new CollegeFacade();
		}
		return collegeFacade;
	}

	/**
	 * Method is used to get the collegeMap
	 * 
	 * @return
	 */
	public Map<Integer, BaseEntity> getMap() {
		return collegeDao.getMap();
	}

	/**
	 * Method is used to get the available number of seats
	 * 
	 * @return
	 */
	public int getAvailableNumberOfSeats() {
		int seatsAvailable = 0;
		// loop continue till end of college map list
		for (Map.Entry<Integer, BaseEntity> college : collegeDao.getMap().entrySet()) {
			seatsAvailable += ((College) college.getValue()).getSeats();
		}
		return seatsAvailable;
	}

	/**
	 * Method is used to get the college by its id
	 * 
	 * @param id
	 * @return
	 */
	public College getCollegeById(int id) {
		return (College) collegeDao.getMap().get(id);
	}

	/**
	 * Method is used to reduced the seat in college as seat is alloted to
	 * student
	 * 
	 * @param college
	 */
	public void reduceSeat(College college) {
		college.setSeats(college.getSeats() - 1);
	}

	/**
	 * Method is used to admit the student in college
	 * 
	 * @param student
	 * @param id
	 */
	public void admitStudentInCollege(BaseEntity student, int id) {
		//If college id is valid then allotment is done
		if(this.getCollegeById(id) != null) {
			College college = getCollegeById(id);
			college.admitStudent((Student) student);
			((Student) student).setCollege(college);
			reduceSeat(college);
		}
	}

	/**
	 * Method is used to check is seats is available in college or not
	 * 
	 * @param id
	 * @return
	 */
	public boolean isSeatsAvailable(int id) {
		College college = getCollegeById(id);
		boolean seatAvailable = false;
		// if seats is not zero then return true
		if (college.getSeats() != 0) {
			seatAvailable = true;
		}
		return seatAvailable;
	}

	/**
	 * Method is used to get the all colleges details in string
	 * 
	 * @return
	 */
	public String getCollegeList() {
		String collegesDetails = "";
		// loop continue until end of college map is reached
		for (Map.Entry<Integer, BaseEntity> college : collegeDao.getMap().entrySet()) {
			collegesDetails += ((College) college.getValue()).toString() + " ---> Seats available : "
					+ ((College) college.getValue()).getSeats() + "\n";
		}
		return collegesDetails;
	}

}
