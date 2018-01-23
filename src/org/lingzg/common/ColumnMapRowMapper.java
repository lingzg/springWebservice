package org.lingzg.common;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.lingzg.util.StringUtil;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.JdbcUtils;

public class ColumnMapRowMapper implements RowMapper<Map<String, Object>> {

	public static final int DEFAULT_CASE = 0;
	public static final int CAMEL_CASE = 1;
	public static final int FIRST_LOWER_CASE = 2;

	private int columnCase;

	public ColumnMapRowMapper() {
		this.columnCase = DEFAULT_CASE;
	}

	public ColumnMapRowMapper(int columnCase) {
		this.columnCase = columnCase;
	}

	@Override
	public Map<String, Object> mapRow(ResultSet rs, int rowNum) throws SQLException {
		ResultSetMetaData rsmd = rs.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Map<String, Object> mapOfColValues = createColumnMap(columnCount);
		for (int i = 1; i <= columnCount; i++) {
			String key = getColumnKey(rsmd.getColumnName(i));
			Object obj = getColumnValue(rs, i);
			mapOfColValues.put(key, obj);
		}
		return mapOfColValues;
	}

	protected Map<String, Object> createColumnMap(int columnCount) {
		return new HashMap<String, Object>(columnCount);
	}

	protected String getColumnKey(String columnName) {
		switch (this.columnCase) {
		case CAMEL_CASE:
			return StringUtil.toCamelCase(columnName);
		case FIRST_LOWER_CASE:
			return StringUtil.toLowerCaseFirstOne(columnName);
		default:
			return columnName;
		}
	}

	protected Object getColumnValue(ResultSet rs, int index) throws SQLException {
		return JdbcUtils.getResultSetValue(rs, index);
	}

}
