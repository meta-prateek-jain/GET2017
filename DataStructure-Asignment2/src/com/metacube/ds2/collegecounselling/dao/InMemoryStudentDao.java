package com.metacube.ds2.collegecounselling.dao;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.metacube.ds2.collegecounselling.enums.FilePath;
import com.metacube.ds2.collegecounselling.model.BaseEntity;
import com.metacube.ds2.collegecounselling.model.Student;
import com.metacube.ds2.collegecounselling.util.FileHandling;

/**
 * This is a student dao which is used to access the student data
 * @author Prateek Jain
 *
 */
public class InMemoryStudentDao implements BaseDao{

	private static InMemoryStudentDao inMemoryStudentDao;
	private static Map<Integer, BaseEntity> studentsMap = new HashMap<Integer, BaseEntity>();
	/**
	 * Constructor is used to initialize the studentsMap
	 * @throws IOException
	 */
	public InMemoryStudentDao() throws IOException{
		List<String> studentsDetails = new FileHandling().read(FilePath.STUDENT_LIST.toString());
		// loop continue till end of collegeDetails
		for (String string : studentsDetails) {
			String[] details = string.split(",");
			//if student details are complete then add it to collegeList map
			if(details.length>=3){
				studentsMap.put(Integer.parseInt(details[2]), new Student(Integer.parseInt(details[0]), details[1], Integer.parseInt(details[2])));
			}
		}
	}
	/**
     * This is used to create class singleton and get available instance
     * 
     * @return
	 * @throws IOException 
     */
    synchronized public static InMemoryStudentDao getInstance() throws IOException{
    	// if studentDao object is null then initialize the object
        if(inMemoryStudentDao == null){
            inMemoryStudentDao = new InMemoryStudentDao();
        }
        return inMemoryStudentDao;
    }	
    /**
     * Method is used to get the studentsMap
     */
    public Map<Integer, BaseEntity> getMap(){
    	return studentsMap;
    }
    /**
     * Method is used to get the student by its id
     * @param id
     * @return
     */
    public Student getStudent(int id){
    	return (Student) studentsMap.get(id);
    }
}
