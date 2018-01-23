package org.lingzg.client;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.lingzg.entity.Emp;
import org.lingzg.webservice.IEmpService;
import org.lingzg.webservice.IHelloWorld;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/test")
public class TestController {

	@RequestMapping("/hi")
	public void hi(String text,HttpServletRequest request,HttpServletResponse response) throws IOException{
		IHelloWorld client = (IHelloWorld) ClientFactory.getClient(IHelloWorld.class,"/HelloWorld");
		String result = client.sayHello(text);
		response.getWriter().println(result);
        
	}
	
	@RequestMapping("/get")
	public void getById(int id,HttpServletRequest request,HttpServletResponse response) throws IOException{
		IEmpService client = (IEmpService) ClientFactory.getClient(IEmpService.class,"/emp");
		Emp result = client.getById(id);
		response.getWriter().println(result);
        
	}
	
	@RequestMapping("/find")
	public void findAll(HttpServletRequest request,HttpServletResponse response) throws IOException{
		IEmpService client = (IEmpService) ClientFactory.getClient(IEmpService.class,"/emp");
		List<Emp> result = client.findAll();
		response.getWriter().println(result);
        
	}
}
