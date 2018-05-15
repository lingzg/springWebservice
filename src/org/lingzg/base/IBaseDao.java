package org.lingzg.base;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.lingzg.common.PageInfo;
import org.springframework.jdbc.core.RowMapper;

public interface IBaseDao<E, PK extends Serializable> {

	List<E> findAll();

	List<E> findByProperty(String propertyName, Object value);

	List<E> findByProperties(String[] propertyNames, Object[] values);

	E get(PK id);

	void save(E entity);

	void update(E entity);

	void delete(PK id);

	void delete(E entity);

	List<?> findListBySql(String sql, Class<?> clazz, Object... params);

	List<E> findEntityListBySql(String sql, Object... params);
	
	List<?> findListBySql(String sql,Object... params);

	List<Map<String, Object>> findMapListBySql(String sql, Object... params);

	List<Map<String, Object>> findMapListBySql1(String sql, Object... params);

	List<Map<String, Object>> findMapListBySql2(String sql, Object... params);
	
	List<Map<String, Object>> findMapListBySql3(String sql, Object... params);

	public void findPageBySql(PageInfo page, String sql, RowMapper<?> mapper, Object... params);

	void findPageBySql(PageInfo page, String sql, Object... params);

	void findPageBySql1(PageInfo page, String sql, Object... params);

	void findPageBySql2(PageInfo page, String sql, Object... params);
	
	void findPageBySql3(PageInfo page, String sql, Object... params);

	void findPageBySql(PageInfo page, String sql, Class<?> clazz, Object... params);

	boolean executeSql(String sql, Object... params);

}
