package cn.com;

import org.glassfish.jersey.server.ResourceConfig;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;

public class RestApplication extends ResourceConfig{

	public RestApplication() {  

	     //服务类所在的包路径  
	     packages("cn.com.service.Rest");  
	     //注册JSON转换器  
	     register(JacksonJsonProvider.class);  

	    }  
}
