package cn.com.service;

import java.util.Date;
import javax.jws.WebService;

import cn.com.dto.PersonEntity;

/**
 * WebService接口
 */
@WebService(name = "HelloWS", targetNamespace = "http://www.tmp.com/ws/hello")
public interface HelloWService {
	/**
	 * 返回字符串
	 * 
	 * @return
	 */
	String index();

	/**
	 * 两个整数相加
	 * 
	 * @param x
	 * @param y
	 * @return 相加后的值
	 */
	Integer add(Integer x, Integer y);

	/**
	 * 返回当前时间
	 * 
	 * @return
	 */
	Date now();
	
	/**
	 * 获取复杂类型
	 * @param name 用户姓名
	 * @param age 用户年龄
	 * @return 返回用户类
	 */
	PersonEntity getPerson(String name, Integer age);
}
