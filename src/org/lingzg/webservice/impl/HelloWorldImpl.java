package org.lingzg.webservice.impl;

import javax.jws.WebService;

import org.lingzg.webservice.IHelloWorld;

@WebService(endpointInterface = "org.lingzg.webservice.IHelloWorld")
public class HelloWorldImpl implements IHelloWorld {

	public String sayHello(String text) {
		return "Hello : " + text;
	}
}
