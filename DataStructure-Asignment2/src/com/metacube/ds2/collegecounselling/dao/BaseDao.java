package com.metacube.ds2.collegecounselling.dao;

import java.util.Map;

import com.metacube.ds2.collegecounselling.model.BaseEntity;

/**
 * This is base Dao Interface implemented by all other dao classes
 * 
 * @author Prateek Jain
 *
 */
public interface BaseDao {

	public Map<Integer, BaseEntity> getMap();
}
