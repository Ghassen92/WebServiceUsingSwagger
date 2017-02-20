package tn.sifast.rest;

import io.swagger.jaxrs.config.BeanConfig;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;

 
@ApplicationPath("/rest")
public class WebApp extends ResourceConfig {

	public WebApp() {

		BeanConfig beanConfig = new BeanConfig();
		beanConfig.setVersion("2.0");
		beanConfig.setTitle("essai swagger");
		beanConfig.setSchemes(new String[] { "http" });
		beanConfig.setHost("localhost:8080");
		beanConfig.setBasePath("/TestSwaagger2/rest");
		beanConfig.setResourcePackage("tn.sifast.rest");
		
		beanConfig.setScan(true);
		beanConfig.setPrettyPrint(true);
		System.out.println(beanConfig.classes());
	}
}
