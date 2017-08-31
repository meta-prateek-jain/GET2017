package com.metacube.ds2.collegecounselling.dao;

import java.io.IOException;

import com.metacube.ds2.collegecounselling.enums.DBType;
import com.metacube.ds2.collegecounselling.enums.Entity;

/**
 * Class is used to get the instance of dao classes
 * 
 * @author Prateek Jain
 *
 */
public class DaoFactory {

	/**
	 * Method is used to get the dao instance
	 * @param entityName
	 * @param dbType
	 * @return
	 * @throws IOException
	 */
	public static BaseDao getDaoForEntity(Entity entityName, DBType dbType) throws IOException{
        BaseDao baseDao = null;
        //switch case is used to get the instance of dao classes depending on entityname and dbname
        switch(entityName){
        case STUDENT:
            switch(dbType){
            case IN_MEMORY:
                baseDao = InMemoryStudentDao.getInstance();
                break;
            default:
                break;
            }
            break;

        case COLLEGE:
            switch(dbType){
            case IN_MEMORY:
                baseDao = InMemoryCollegeDao.getInstance();
                break;
            default:
                break;
            }
            break;

        default:
            break;
        }
        return baseDao;
    }
}