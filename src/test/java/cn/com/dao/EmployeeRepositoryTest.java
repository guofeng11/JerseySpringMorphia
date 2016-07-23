package cn.com.dao;





import cn.com.entity.Employee;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mongodb.morphia.Key;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value={"classpath:spring/spring-mongo.xml"})
public class EmployeeRepositoryTest {

	@Autowired
	private EmployeeRepositoryImpl employRepository;

	@Test
	public  void testSave() {
		Employee employee1=new Employee();
		employee1.setName("lilei");
		employee1.setSalary(50000.0);

		Key<Employee> emp1= employRepository.save(employee1);
		System.out.println(emp1.getId());

		Employee employee2=new Employee();
		employee2.setName("hanmeimei");
		employee2.setSalary(250000.0);
		employee2.setManager(employee1);
		List<Employee> list=new ArrayList<Employee>();
		//list.add(employee1);
		employee2.setDirectReports(list);
		Key<Employee> emp2= employRepository.save(employee2);
		System.out.println(emp2.getId());

		List<Employee> list1=new ArrayList<Employee>();
		list1.add(employee2);
		employee1.setDirectReports(list1);
		Key<Employee> emp3= employRepository.save(employee1);
		System.out.println(emp3.getId());
	}
    @Test
    public void testFind()
    {
    	final List<Employee> employees = employRepository.find().asList();
        for (Employee employee : employees) {
        	System.out.println(employee.getName()+employee.getSalary());
        	for (Employee emp : employee.getDirectReports()) {
        		Employee mEmployee=employRepository.findOne("id", emp.getId());
        		System.out.println("我是二级"+mEmployee.getName()+mEmployee.getSalary());
			} 
		}
    }

}
