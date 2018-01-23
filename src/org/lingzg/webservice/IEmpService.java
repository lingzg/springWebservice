package org.lingzg.webservice;

import java.util.List;

import javax.jws.WebParam;
import javax.jws.WebService;

import org.lingzg.entity.Emp;

@WebService
public interface IEmpService {

	public Emp getById(@WebParam int id);
	
	public List<Emp> findAll();
	
}
