package com.ApiProInfra.config;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class ConfiguracaoSwaggerConfig {

	@Bean
	public Docket ApiDesafioIndra() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.ApiProInfra")).paths(PathSelectors.regex("/api.*"))
				.build().apiInfo(metaInfo());
	}

	private ApiInfo metaInfo() {

		ApiInfo apiInfo = new ApiInfo("Projeto Pro-Infra", "API REST Pro-Infra", "1.0", "Terms of Service",
				new Contact("https://www.linkedin.com/in/demilly-ferreira/", "(83) 98707-7504", "demilly_@hotmail.com	"),
				"Apache License Version 2.0", "https://www.apache.org/licesen.html", new ArrayList<>());

		return apiInfo;
	}

}
