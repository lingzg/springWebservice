package org.lingzg.client;

import org.junit.Test;
import org.lingzg.webservice.IHelloWorld;

public class TestCase {

	@Test
	public void test() {  
		IHelloWorld client = (IHelloWorld) ClientFactory.getClient(IHelloWorld.class,"HelloWorld");
        String result = client.sayHello("你好!");
        System.out.println(result);
    }  
}
