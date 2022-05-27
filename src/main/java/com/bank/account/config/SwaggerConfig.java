package com.bank.account.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
*
* @author Yogya Hewavidana
*
*/

@Configuration
public class SwaggerConfig {

	@Bean
	public Docket swaggerApi() {

		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.bank.account.controller")).paths(PathSelectors.any())
				.build();
	}

	
//	Docket is a builder 
//	select() method returns an instance of ApiSelectorBuilder
//	RequestHandlerSelectors.basePackage(). It will scan the base package and create APIs for all of the classes
//	within it.
//	RequestHandlerSelectors.any() to generate documentation for all packages.
//	paths() method further defines for which paths in our APIs do we want to create documentation for.
}
