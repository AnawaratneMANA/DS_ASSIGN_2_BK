package com.testing.demo.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import java.util.Collection;
import java.util.Collections;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket swaggerConfiguration() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(Details())
                .pathMapping("/")
                .select()
                .paths(PathSelectors.regex("/.*"))
                .apis(RequestHandlerSelectors.basePackage("com.example"))
                .build();
    }

    private ApiInfo Details(){
        return new ApiInfo(
                "DS Project",
                "DS Group Project",
                "1.0",
                "",
                new springfox.documentation.service.Contact("Team", "http://google.com", "a@b.com"),
                "Open",
                "http://#",
                Collections.emptyList());
    }
}




