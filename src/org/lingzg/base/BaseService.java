package org.lingzg.base;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.lingzg.common.ParamsTable;

public abstract class BaseService<E,PK extends Serializable> {

	protected abstract IBaseDao<E, PK> getEntityDao();
	
	public E getById(PK id){
		return getEntityDao().get(id);
	}
	
	public List<E> findAll(){
		return getEntityDao().findAll();
	}
	
	public List<E> findByProperty(String propertyName, Object value){
		return getEntityDao().findByProperty(propertyName, value);
	}
	
	public List<E> findByProperties(String[] propertyNames, Object[] values){
		return getEntityDao().findByProperties(propertyNames, values);
	}
	
	public List<E> findByParamsTable(ParamsTable params){
		Map<String, Object> map = params.getParams();
		int size = map.size();
		String[] propertyNames = new String[size];
		Object[] values = new Object[size];
		int i=0;
		for(String key : map.keySet()){
			propertyNames[i] = key;
			values[i] = map.get(key);
			i++;
		}
		return getEntityDao().findByProperties(propertyNames, values);
	}
	
}
