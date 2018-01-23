package org.lingzg.dao;

import org.lingzg.base.JdbcBaseDao;
import org.lingzg.entity.Emp;
import org.springframework.stereotype.Repository;

@Repository
public class EmpDao extends JdbcBaseDao<Emp, Integer> {

	@Override
	protected Class<?> getEntityClass() {
		return Emp.class;
	}
	
	@Override
	protected String getTableName() {
		return Emp.getTableName();
	}
	
	@Override
	protected String[][] getCloumnFields() {
		return new String[][]{Emp.getCloumnNames(),Emp.getFieldNames()};
	}

}
