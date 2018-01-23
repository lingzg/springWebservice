package org.lingzg.common;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import org.lingzg.util.BeanUtil;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.JdbcUtils;

public class EntityRowMapper implements RowMapper<Object> {

	private Class<?> clazz;

	public EntityRowMapper(Class<?> clazz) {
		this.clazz = clazz;
	}

	@Override
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		ResultSetMetaData rsmd = rs.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object bean = null;
		try {
			bean = clazz.newInstance();
			for (int i = 1; i <= columnCount; i++) {
				String key = getColumnKey(rsmd.getColumnName(i));
				Object obj = getColumnValue(rs, i);
				BeanUtil.setfieldValue(bean, key, obj);
			}
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
		return bean;
	}

	protected String getColumnKey(String columnName) {
		return BeanUtil.column2field(clazz, columnName);
	}

	protected Object getColumnValue(ResultSet rs, int index) throws SQLException {
		return JdbcUtils.getResultSetValue(rs, index);
	}

}
