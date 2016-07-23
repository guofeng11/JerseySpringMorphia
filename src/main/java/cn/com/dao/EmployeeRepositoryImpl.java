package cn.com.dao;



import org.bson.types.ObjectId;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.dao.BasicDAO;



import cn.com.entity.Employee;

public class EmployeeRepositoryImpl extends BasicDAO<Employee,ObjectId> {

	public EmployeeRepositoryImpl(Datastore ds) {
		super(ds);
	}


}
