package cn.com.service;


import java.util.Date;

import javax.jws.WebService;

import cn.com.dto.PersonEntity;


@WebService(
		endpointInterface = "cn.com.service.HelloWService",
		portName = "HelloWSPort",
		serviceName = "HelloWSService"
		)
public class HelloWServiceImpl implements HelloWService {
	public String index() {
		return "hello";
	}

	public Integer add(Integer x, Integer y) {
		return x + y;
	}

	public Date now() {
		return new Date();
	}
	
	public PersonEntity getPerson(String name, Integer age) {
		PersonEntity person = new PersonEntity();
		person.setAge(age);
		person.setName(name);
		
		return person;
	}
}
