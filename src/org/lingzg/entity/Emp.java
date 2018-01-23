package org.lingzg.entity;

import java.util.Date;

import org.lingzg.base.BaseEntity;

public class Emp extends BaseEntity {

	private static final long serialVersionUID = -3632724887992261824L;
	
	private Integer empno;
	private String ename;
	private String job;
	private Integer mgr;
	private Date hiredate;
	private Double sal;
	private Double comm;
	private Integer deptno;

	public Integer getEmpno() {
		return empno;
	}

	public void setEmpno(Integer empno) {
		this.empno = empno;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public Integer getMgr() {
		return mgr;
	}

	public void setMgr(Integer mgr) {
		this.mgr = mgr;
	}

	public Date getHiredate() {
		return hiredate;
	}

	public void setHiredate(Date hiredate) {
		this.hiredate = hiredate;
	}

	public Double getSal() {
		return sal;
	}

	public void setSal(Double sal) {
		this.sal = sal;
	}

	public Double getComm() {
		return comm;
	}

	public void setComm(Double comm) {
		this.comm = comm;
	}

	public Integer getDeptno() {
		return deptno;
	}

	public void setDeptno(Integer deptno) {
		this.deptno = deptno;
	}

	public static String getTableName() {
		return "t_emp";
	}

	public static String[] getCloumnNames() {
		return new String[] { "empno", "ename", "job", "mgr", "hiredate", "sal", "comm", "deptno" };
	}

	public static String[] getFieldNames() {
		return new String[] { "empno", "ename", "job", "mgr", "hiredate", "sal", "comm", "deptno" };
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

	@Override
	public String toString() {
		return super.toString()+"{empno=" + empno + ", ename=" + ename + ", job=" + job + ", mgr=" + mgr + ", hiredate=" + hiredate
				+ ", sal=" + sal + ", comm=" + comm + ", deptno=" + deptno + "}";
	}
	
	
}
