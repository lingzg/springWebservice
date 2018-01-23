package org.lingzg.common;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.JdbcUtils;

public class ColumnArrayRowMapper implements RowMapper<Object> {

	@Override
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		ResultSetMetaData rsmd = rs.getMetaData();
		int columnCount = rsmd.getColumnCount();
		if(columnCount>1){
			Object[] valueArray = new Object[columnCount];
			for (int i = 1; i <= columnCount; i++) {
				valueArray[i - 1] = getColumnValue(rs, i);
			}
			return valueArray;
		}else{
			return getColumnValue(rs, 1);
		}
	}

	protected Object getColumnValue(ResultSet rs, int index) throws SQLException {
		return JdbcUtils.getResultSetValue(rs, index);
	}

}
