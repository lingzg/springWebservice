package org.lingzg.dao;

import org.lingzg.base.JdbcBaseDao;
import org.lingzg.entity.Dept;
import org.springframework.stereotype.Repository;

@Repository
public class DeptDao extends JdbcBaseDao<Dept, Integer> {

	@Override
	protected Class<?> getEntityClass() {
		return Dept.class;
	}
	
	@Override
	protected String getTableName() {
		return Dept.getTableName();
	}
	
	@Override
	protected String[][] getCloumnFields() {
		return new String[][]{Dept.getCloumnNames(),Dept.getFieldNames()};
	}
	
}
