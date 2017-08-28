package com.metacube.shoppingCart.dao;
import java.io.IOException;

import com.metacube.shoppingCart.enums.DBType;
import com.metacube.shoppingCart.enums.Entity;
public class DaoFactory {
	public static BaseDao<?> getDaoForEntity(Entity entityName, DBType dbType) throws IOException{
        BaseDao<?> baseDao = null;
        switch(entityName){
        case PRODUCT:
            switch(dbType){
            case IN_MEMORY:
                baseDao = InMemoryProductDao.getInstance();
                break;
            case MY_SQL:
              //  baseDao = FileProductDao.getInstance();
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
