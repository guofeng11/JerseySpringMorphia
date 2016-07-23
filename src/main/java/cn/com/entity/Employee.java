package cn.com.entity;



import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.*;
import org.mongodb.morphia.utils.IndexType;

import java.util.List;



@Entity(value="employees",noClassnameStored=true)
@Indexes( 
		@Index(fields = @Field(value="salary",type=IndexType.DESC))
		)
public class Employee {
	@Id
    private ObjectId id;
    private String name;

    private Integer sex=0;

	@Reference
    private Employee manager;
    @Reference
    private List<Employee> directReports;
    @Property("wage")
    private Double salary;
    private List<String> memos;
    
    
    
	public ObjectId getId() {
		return id;
	}
	public void setId(ObjectId id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Employee getManager() {
		return manager;
	}
	public void setManager(Employee manager) {
		this.manager = manager;
	}
	public List<Employee> getDirectReports() {
		return directReports;
	}
	public void setDirectReports(List<Employee> directReports) {
		this.directReports = directReports;
	}
	public Double getSalary() {
		return salary;
	}
	public void setSalary(Double salary) {
		this.salary = salary;
	}
	public List<String> getMemos() {
		return memos;
	}
	public void setMemos(List<String> memos) {
		this.memos = memos;
	}
    public Integer getSex() {
		return sex;
	}
	public void setSex(Integer sex) {
		this.sex = sex;
	}
}
