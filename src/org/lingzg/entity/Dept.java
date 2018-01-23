package org.lingzg.entity;

import org.lingzg.base.BaseEntity;

public class Dept extends BaseEntity {

	private static final long serialVersionUID = 5554095562787191417L;
	
	private Integer deptno;
	private String dname;
	private String loc;

	public Integer getDeptno() {
		return deptno;
	}

	public void setDeptno(Integer deptno) {
		this.deptno = deptno;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public String getLoc() {
		return loc;
	}

	public void setLoc(String loc) {
		this.loc = loc;
	}

	public static String getTableName() {
		return "t_dept";
	}

	public static String[] getCloumnNames() {
		return new String[] { "deptno", "dname", "loc" };
	}

	public static String[] getFieldNames() {
		return new String[] { "deptno", "dname", "loc" };
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
