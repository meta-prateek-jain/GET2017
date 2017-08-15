package com.metacube.shoppingCart.dao;

import java.util.Map;

import com.metacube.shoppingCart.model.BaseEntity;
/**
 * This interface is implemented by all dao classes
 * @author Prateek Jain
 *
 * @param <T>
 */
public interface BaseDao<T extends BaseEntity> {
	public void add(BaseEntity entity);
	public void edit(int id, int value);
	public BaseEntity retrieve(int id);
	public void remove(int id);
	public Map<Integer, BaseEntity> getList();
}
