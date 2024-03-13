package com.algaworks.algalog.algalogapi.common;

import java.util.Arrays;
import java.util.HashSet;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
//    private Contact contato() {
//        return new Contact(
//                "Seu nome",
//                "http://www.seusite.com.br",
//                "voce@seusite.com.br");
//    }
//    private ApiInfoBuilder informacoesApi() {
//
//        ApiInfoBuilder apiInfoBuilder = new ApiInfoBuilder();
//
//        apiInfoBuilder.title("Title - Rest API");
//        apiInfoBuilder.description("API Criada a partir do curso da Alga Works");
//        apiInfoBuilder.version("1.0");
//        apiInfoBuilder.termsOfServiceUrl("Termo de uso: Open Source");
//        apiInfoBuilder.license("Licença - Sua Empresa");
//        apiInfoBuilder.licenseUrl("http://www.seusite.com.br");
//        apiInfoBuilder.contact(this.contato());
//
//        return apiInfoBuilder;
//
//    }
//    @Bean
//    public Docket detalheApi() {
//        Docket docket = new Docket(DocumentationType.SWAGGER_2);
//
//        docket
//                .select()
//                .apis(RequestHandlerSelectors.basePackage("com.algaworks.algalog.algalogapi.Controller"))
//                .paths(PathSelectors.any())
//                .build()
//                .apiInfo(this.informacoesApi().build())
//                .consumes(new HashSet<String>(Arrays.asList("application/json")))
//                .produces(new HashSet<String>(Arrays.asList("application/json")));
//
//        return docket;
//    }

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.algaworks.algalog.algalogapi.Controller"))
                .paths(PathSelectors.any())
                .build();
    }

}
