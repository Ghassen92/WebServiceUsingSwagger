package tn.sifast.rest;

import io.swagger.jaxrs.config.BeanConfig;

import javax.ws.rs.ApplicationPath;

import org.apache.log4j.Logger;
import org.glassfish.jersey.server.ResourceConfig;


 
@ApplicationPath("/rest")
public class WebApp extends ResourceConfig {

	final static Logger logger = Logger.getLogger(WebApp.class);
	public WebApp() {

		BeanConfig beanConfig = new BeanConfig();
		beanConfig.setVersion("2.0");
		beanConfig.setTitle("essai swagger");
		beanConfig.setSchemes(new String[] { "http" });
		beanConfig.setHost("localhost:8080");
		beanConfig.setBasePath("/WebServiceSwagger/rest");
		beanConfig.setResourcePackage("tn.sifast.rest");
		
		beanConfig.setScan(true);
		beanConfig.setPrettyPrint(true);
		logger.info("scanning package = "+beanConfig.classes());
	}
}
