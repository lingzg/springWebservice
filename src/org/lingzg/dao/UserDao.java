package org.lingzg.dao;

import org.lingzg.base.JdbcBaseDao;
import org.lingzg.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao extends JdbcBaseDao<User, Integer> {

	@Override
	protected Class<?> getEntityClass() {
		return User.class;
	}
	
	@Override
	protected String getTableName() {
		return User.getTableName();
	}
	
	@Override
	protected String[][] getCloumnFields() {
		return new String[][]{User.getCloumnNames(),User.getFieldNames()};
	}

}
