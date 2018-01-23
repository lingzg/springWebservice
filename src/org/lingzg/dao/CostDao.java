package org.lingzg.dao;

import org.lingzg.base.JdbcBaseDao;
import org.lingzg.entity.Cost;
import org.springframework.stereotype.Repository;

@Repository
public class CostDao extends JdbcBaseDao<Cost, Integer> {

	@Override
	protected Class<?> getEntityClass() {
		return Cost.class;
	}
	
	@Override
	protected String getTableName() {
		return Cost.getTableName();
	}
	
	@Override
	protected String[][] getCloumnFields() {
		return new String[][]{Cost.getCloumnNames(),Cost.getFieldNames()};
	}
	
}
