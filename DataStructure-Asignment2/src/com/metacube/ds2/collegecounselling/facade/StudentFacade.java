package com.metacube.ds2.collegecounselling.facade;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import com.metacube.ds2.collegecounselling.dao.BaseDao;
import com.metacube.ds2.collegecounselling.dao.DaoFactory;
import com.metacube.ds2.collegecounselling.enums.DBType;
import com.metacube.ds2.collegecounselling.enums.Entity;
import com.metacube.ds2.collegecounselling.model.BaseEntity;
import com.metacube.ds2.collegecounselling.model.Student;
import com.metacube.ds2.queue.Queue;

/**
 * This class contains all th business logics of student
 * 
 * @author Prateek Jain
 *
 */
public class StudentFacade {
	private static StudentFacade studentFacade;
	private static Map<Integer, BaseEntity> studentList;
	private BaseDao studentDao;

	// constructor to initialize the student dao object
	private StudentFacade() {
		studentList = new HashMap<Integer, BaseEntity>();
		try {
			studentDao = DaoFactory.getDaoForEntity(Entity.STUDENT, DBType.IN_MEMORY);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * This is used to create class singleton and get available instance
	 * 
	 * @return StudentFacade
	 * @throws IOException
	 */
	synchronized public static StudentFacade getInstance() {
		// if studentfacade object is null then initialize it
		if (studentFacade == null) {
			studentFacade = new StudentFacade();
		}
		return studentFacade;
	}

	/**
	 * Method is used to get the student queue ordered by rank
	 * 
	 * @return
	 */
	public Queue getStudentQueueOrderByRank() {
		Queue students = new Queue();
		// sort the students list
		studentList = new TreeMap<Integer, BaseEntity>(studentDao.getMap());
		// loop continue till end of list is reached
		for (Map.Entry<Integer, BaseEntity> student : studentList.entrySet()) {
			students.enque((Student) student.getValue());
		}

		return students;
	}

	/**
	 * Method is used to get list of all students whom college is allocated
	 * @return
	 */
	public String getListOfAllStudentsWithAllocatedCollege() {
		String studentsDetails = "";
		// loop continue till end of student map reavched
		for (Map.Entry<Integer, BaseEntity> student : studentDao.getMap().entrySet()) {
			studentsDetails += ((Student) student.getValue()).toString();
		}
		return studentsDetails;
	}
}
