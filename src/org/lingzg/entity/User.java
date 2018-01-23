package org.lingzg.entity;

import org.lingzg.base.BaseEntity;

public class User extends BaseEntity {

	private static final long serialVersionUID = -1846402861015186553L;
	
	private String userName;
	private String password;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public static String getTableName() {
		return "t_user";
	}

	public static String[] getCloumnNames() {
		return new String[] { "userName", "password" };
	}

	public static String[] getFieldNames() {
		return new String[] { "userName", "password" };
	}

	public static String column2field(String columnName) {
		String[] cols = getCloumnNames();
		for (int i = 0; i < cols.length; i++) {
			if (cols[i] != null && cols[i].equalsIgnoreCase(columnName)) {
				return getFieldNames()[i];
			}
		}
		return null;
	}
}
