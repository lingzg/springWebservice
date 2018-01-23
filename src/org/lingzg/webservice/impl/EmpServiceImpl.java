package org.lingzg.webservice.impl;

import java.util.List;

import javax.jws.WebService;

import org.lingzg.dao.EmpDao;
import org.lingzg.entity.Emp;
import org.lingzg.webservice.IEmpService;
import org.lingzg.webutil.ApplicationContextHolder;

@WebService(endpointInterface = "org.lingzg.webservice.IEmpService")
public class EmpServiceImpl implements IEmpService {

	private EmpDao dao=ApplicationContextHolder.getBean("empDao", EmpDao.class);
	
	@Override
	public Emp getById(int id) {
		return dao.get(id);
	}

	@Override
	public List<Emp> findAll() {
		return dao.findAll();
	}

}
