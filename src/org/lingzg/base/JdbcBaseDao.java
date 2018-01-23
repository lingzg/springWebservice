package org.lingzg.base;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.lingzg.common.ColumnArrayRowMapper;
import org.lingzg.common.ColumnMapRowMapper;
import org.lingzg.common.EntityRowMapper;
import org.lingzg.common.PageInfo;
import org.lingzg.util.BeanUtil;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public abstract class JdbcBaseDao<E,PK extends Serializable> implements IBaseDao<E,PK>{

	@Resource
	private JdbcTemplate jdbcTemplate;
	
	protected abstract Class<?> getEntityClass();
	protected abstract String getTableName();
	protected abstract String[][] getCloumnFields();//[[CloumnNames],[FieldsNames]]
	
	public JdbcTemplate getJdbcTemplate(){
		return jdbcTemplate;
	}
	
	@SuppressWarnings("unchecked")
	public List<E> findAll() {
		String sql = "select * from "+getTableName();
		List<Object> list = getJdbcTemplate().query(sql, new EntityRowMapper(getEntityClass()));
		return (List<E>) list;
	}
	
	public List<E> findByProperty(String propertyName, Object value){
		return findByProperties(new String[]{propertyName}, new Object[]{value});
	}
	
	@SuppressWarnings("unchecked")
	public List<E> findByProperties(String[] propertyNames, Object[] values) {
		StringBuffer sql=new StringBuffer();
		sql.append("select * from ").append(getTableName());
		if(propertyNames!=null){
			for(int i=0;i<propertyNames.length;i++){
				sql.append(i==0 ? " where " : " and ");
				sql.append(propertyNames[i]).append("=?");
			}
		}
		List<Object> list = getJdbcTemplate().query(sql.toString(), new EntityRowMapper(getEntityClass()), values);
		return (List<E>) list;
	}
	
	@SuppressWarnings("unchecked")
	public E get(PK id) {
		String[][] arr =  getCloumnFields();
		String sql = "select * from "+getTableName()+" where "+arr[0][0]+"=?";
		return (E) getJdbcTemplate().queryForObject(sql, new EntityRowMapper(getEntityClass()), id);
	}
	
	public void delete(PK id) {
		String[][] arr =  getCloumnFields();
		String sql = "delete from "+getTableName()+" where "+arr[0][0]+"=?";
		getJdbcTemplate().update(sql, id);
	}
	
	@SuppressWarnings("unchecked")
	public void delete(E entity) {
		String[][] arr =  getCloumnFields();
		String sql = "delete from "+getTableName()+" where "+arr[0][0]+"=?";
		PK id = (PK) BeanUtil.getfieldValue(entity, arr[1][0]);
		getJdbcTemplate().update(sql, id);
		
	}

	@Override
	public void save(E entity) {
		String[][] arr =  getCloumnFields();
		String[] fields=arr[1];
		int len = fields.length;
		StringBuffer sql = new StringBuffer();
		sql.append("insert into ").append(getTableName()).append(" values(null");
		Object[] params = new Object[len-1];
		for(int i=1;i<len;i++){
			sql.append(",?");
			params[i-1]=BeanUtil.getfieldValue(entity, fields[i]);
		}
		sql.append(")");
		getJdbcTemplate().update(sql.toString(), params);
	}

	@Override
	public void update(E entity) {
		String[][] arr =  getCloumnFields();
		String[] columns=arr[0];
		String[] fields=arr[1];
		int len = columns.length;
		StringBuffer sql = new StringBuffer();
		sql.append("update ").append(getTableName()).append(" set ");
		Object[] params = new Object[len];
		for(int i=1;i<len;i++){
			sql.append(columns[i]).append("=?");
			if(i!=len-1){
				sql.append(",");
			}
			params[i-1]=BeanUtil.getfieldValue(entity, fields[i]);
		}
		sql.append(" where ").append(columns[0]).append("=?");
		params[len-1]=BeanUtil.getfieldValue(entity, fields[0]);
		getJdbcTemplate().update(sql.toString(), params);
	}
	
	public List<?> findListBySql(String sql, Class<?> clazz, Object... params){
		return getJdbcTemplate().query(sql, new EntityRowMapper(clazz), params);
	}
	
	@SuppressWarnings("unchecked")
	public List<E> findEntityListBySql(String sql,Object... params){
		return (List<E>) getJdbcTemplate().query(sql, new EntityRowMapper(getEntityClass()), params);
	}
	
	public List<?> findListBySql(String sql,Object... params){
		return getJdbcTemplate().query(sql, new ColumnArrayRowMapper(), params);
	}
	
	public List<Map<String, Object>> findMapListBySql(String sql,Object... params){
		return getJdbcTemplate().query(sql, new ColumnMapRowMapper(), params);
	}
	
	public List<Map<String, Object>> findMapListBySql2(String sql,Object... params){
		return getJdbcTemplate().query(sql, new ColumnMapRowMapper(ColumnMapRowMapper.CAMEL_CASE), params);
	}
	
	public List<Map<String, Object>> findMapListBySql3(String sql,Object... params){
		return getJdbcTemplate().query(sql, new ColumnMapRowMapper(ColumnMapRowMapper.FIRST_LOWER_CASE), params);
	}
				
	public void findPageBySql(PageInfo page, String sql, RowMapper<?> mapper, Object... params){
		String countSql = "select count(1) from("+sql+")tcont";
		long count = getJdbcTemplate().queryForObject(countSql, Long.class, params);
		page.setTotal(count);
		int start = page.getStartRow();
		int end = start + page.getPageSize();
		//mysql
		sql += "limit "+start+","+end;
		//oracle
		//sql="SELECT * FROM (SELECT tn.*,ROWNUM AS rowno FROM ("+sql+") tn WHERE ROWNUM <= "+end+") tw WHERE tw.rowno >= "+start;
		System.out.println(sql);
		List<?> rows = getJdbcTemplate().query(sql, mapper, params);
		page.setRows(rows);
	}
	
	public void findPageBySql(PageInfo page, String sql, Object... params){
		findPageBySql(page, sql, new ColumnMapRowMapper(), params);
	}
	
	public void findPageBySql2(PageInfo page, String sql, Object... params){
		findPageBySql(page, sql, new ColumnMapRowMapper(ColumnMapRowMapper.CAMEL_CASE), params);
	}
	
	public void findPageBySql3(PageInfo page, String sql, Object... params){
		findPageBySql(page, sql, new ColumnMapRowMapper(ColumnMapRowMapper.FIRST_LOWER_CASE), params);
	}
	
	public void findPageBySql(PageInfo page, String sql, Class<?> clazz, Object... params){
		findPageBySql(page, sql, new EntityRowMapper(clazz), params);
	}
	
	public boolean executeSql(String sql, Object... params){
		getJdbcTemplate().update(sql, params);
		return true;
	}
}
