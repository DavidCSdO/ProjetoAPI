package org.serratec.backend.ProjetoFinal.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.support.RequestHandledEvent;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {
	
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.any())		
				.build()
				.apiInfo(this.apiInfo());
				
	}
	
	public ApiInfo apiInfo() {
		ApiInfo apiInfo = new ApiInfoBuilder()
				.title("API G1")
				.description("API projeto final.")
				.license("Apache 2.0")
				.version("0.0.2")
				.contact(new Contact("G1", "GrupoG1", "cardosodavid92@gmail.com"))
				.build();
		
		return apiInfo;
	}
	
	
}
