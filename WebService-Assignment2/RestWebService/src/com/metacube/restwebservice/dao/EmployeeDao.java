package com.metacube.restwebservice.dao;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import com.metacube.restwebservice.model.Employee;
import com.metacube.restwebservice.util.JsonFilehandling;
/**
 * This dao class is used to access the json file\
 * 
 * @author Prateek Jain
 *
 */
public enum EmployeeDao {
	instance;
	private List<JSONObject> employeesList;
	private Map<String, Employee> employees = new HashMap<String, Employee>();
	/**
	 * Constructor to initialize the map
	 */
	private EmployeeDao() {
		employeesList = JsonFilehandling.read();
		for (JSONObject jsonObj : employeesList) {
			employees.put(jsonObj.get("id").toString(), new Employee(jsonObj.get("id").toString(),jsonObj.get("name").toString(), jsonObj.get("age").toString()));
		}
	}
	/**
	 * Method is used to return the employee map
	 * @return
	 */
	public Map<String, Employee> getEmployees() {
		return employees;
	}
	 /**
	  * function is used to get the employee by id
	  * @param id
	  * @return
	  */
	public Employee getEmployeeById(String id) {
		return employees.get(id);
	}
	/**
	 * method is used to Write the data to file
	 * @throws ParseException
	 * @throws IOException 
	 */
	@SuppressWarnings("unchecked")
	public void writeTofile() throws ParseException, IOException{
		JsonFilehandling.clearFile();
		JSONObject object;
		//loop continue till end of map
		for(Map.Entry<String, Employee> employeeMap : employees.entrySet()){
			object = new JSONObject();
			object.put("id", employeeMap.getValue().getId());
			object.put("age", employeeMap.getValue().getAge());
			object.put("name", employeeMap.getValue().getName());
			object=(JSONObject) object;
			JsonFilehandling.write(object);
		}
	}
}
