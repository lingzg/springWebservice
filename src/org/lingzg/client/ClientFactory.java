package org.lingzg.client;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;

public class ClientFactory {

	public static Object getClient(Class<?> clazz,String adress){
		JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
        factory.setServiceClass(clazz);
        factory.setAddress("http://127.0.0.1:8080/springWebservice/cxf"+adress);
        return factory.create();
	}
}
