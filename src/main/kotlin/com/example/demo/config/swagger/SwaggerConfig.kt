package com.example.demo.config.swagger


import io.swagger.v3.oas.models.Components
import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Info
import io.swagger.v3.oas.models.security.SecurityScheme
import io.swagger.v3.oas.models.servers.Server
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class SwaggerConfig {

    @Bean
    fun orderStockApiSwagger(): OpenAPI {
        return OpenAPI().addServersItem(Server().url("/"))
                .info(
                        Info().title("REST API")
                                .description("API 서버")
                                .version("v0.0.1")
                )
    }



}