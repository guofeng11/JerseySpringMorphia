package cn.com.service.Rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


import org.mongodb.morphia.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import cn.com.dao.EmployeeRepositoryImpl;
import cn.com.dto.PersonEntity;
import cn.com.entity.Employee;

@Path("/person")
public class PersonServiceImpl implements PersonService {

	Logger logger = LoggerFactory.getLogger(PersonServiceImpl.class);
	@Autowired
	private EmployeeRepositoryImpl employeeRepository;

	// The Java method will process HTTP GET requests
	@GET
	@Path("/hello")
	// The Java method will produce content identified by the MIME Media type
	// "text/plain"
	@Produces("text/plain")
	public String getClichedMessage() {
		// Return some cliched textual content
		return "Hello kit";
	}

	@GET
	@Path("/getxml")
	@Produces(MediaType.APPLICATION_XML)
	public PersonEntity findPersonXML() {

		/*
		 * Query<Employee> query=employeeRepository.createQuery().filter("name",
		 * name); Employee employee=employeeRepository.findOne(query); if
		 * (employee!=null) { PersonEntity personEntity=new PersonEntity();
		 * personEntity.setName(employee.getName()); personEntity.setAge(20);
		 * return personEntity; } return null;
		 */
		logger.info("LiLei");
		PersonEntity personEntity = new PersonEntity();
		personEntity.setName("LiLei");
		personEntity.setAge(20);
		return personEntity;
	}

	@GET
	@Path("/getjson/{name}")
	@Produces(MediaType.APPLICATION_JSON)
	@Override
	public PersonEntity findPerson(@PathParam(value = "name") String name) {
		logger.info("coming");	  
		Query<Employee> query = employeeRepository.createQuery().filter("name", name);
		Employee employee = employeeRepository.findOne(query);
		if (employee != null) {
			PersonEntity personEntity = new PersonEntity();
			personEntity.setName(employee.getName());
			personEntity.setAge(20);
			return personEntity;
		}
		return new PersonEntity();
	}

}
