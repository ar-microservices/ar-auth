package com.arfan.auth.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {
    @Value("${server.servlet.context-path}")
    private String contextPath;

    @Bean
    public OpenAPI customOpenApi() {
        Server server = new Server();
        server.setUrl(contextPath);
        server.description("Default Server");
        return new OpenAPI()
                .addServersItem(server)
                .info(new Info()
                        .title("API DOCUMENTATION")
                        .version("v1")
                        .description("This is for documentation api")
                        .license(new License().name("Apache 2.0").url("http://springdoc.org")));
    }
}
