package com.metacube.ds2.collegecounselling.dao;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.metacube.ds2.collegecounselling.enums.FilePath;
import com.metacube.ds2.collegecounselling.model.BaseEntity;
import com.metacube.ds2.collegecounselling.model.College;
import com.metacube.ds2.collegecounselling.util.FileHandling;

/**
 * This is a college dao which is used to access the data of college
 * 
 * @author Prateek Jain
 *
 */
public class InMemoryCollegeDao implements BaseDao {

	private static InMemoryCollegeDao inMemoryCollegeDao;
	private static Map<Integer, BaseEntity> collegesMap = new HashMap<Integer, BaseEntity>();
	
	/**
	 * Constructor to initialize the collegeMap
	 * @throws IOException
	 */
	public InMemoryCollegeDao() throws IOException{
		List<String> collegesDetails = new FileHandling().read(FilePath.COLLEGE_LIST.toString());
		// loop continue till end of collegesDetails
		for (String str : collegesDetails) {
			String[] details = str.split(",");
			//if college has all details then add it to collegeList map
			if(details.length>=4){
				collegesMap.put(Integer.parseInt(details[0]), new College(Integer.parseInt(details[0]), details[1], Integer.parseInt(details[2]), Integer.parseInt(details[3])));
			}
		}
	}
	/**
     * This is used to create class singleton and get available instance
     * 
     * @return
	 * @throws IOException 
     */
    synchronized public static InMemoryCollegeDao getInstance() throws IOException{
    	// if inMemoryCollegeDao object is null then initialize the object
        if(inMemoryCollegeDao == null){
            inMemoryCollegeDao = new InMemoryCollegeDao();
        }
        return inMemoryCollegeDao;
    }	
    /**
     * Method is used to get the collegesMap
     */
    public Map<Integer, BaseEntity> getMap(){
    	return collegesMap;
    }
    /**
     * Method is used to get the college by id
     * @param id
     * @return
     */
    public College getCollege(int id){
    	return (College) collegesMap.get(id);
    }
}
