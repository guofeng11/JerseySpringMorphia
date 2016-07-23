package cn.com.service;



import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.com.dto.PersonEntity;
import cn.com.service.Rest.PersonService;
import cn.com.service.Rest.PersonServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value="classpath:spring/spring-mongo.xml")
public class PersonServiceImplTest {

	@Test
	public void testFindPerson() {
		PersonService personService=new  PersonServiceImpl();
		PersonEntity personEntity=personService.findPerson("55");
		System.out.println(personEntity.getName());
	}

}
