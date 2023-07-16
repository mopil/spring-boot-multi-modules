package com.example.multiserver.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpMethod
import org.springframework.http.HttpStatus
import springfox.documentation.builders.ApiInfoBuilder
import springfox.documentation.builders.PathSelectors
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.builders.ResponseBuilder
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket
import springfox.documentation.swagger2.annotations.EnableSwagger2

@Configuration
@EnableSwagger2
class SwaggerConfig {
    @Bean
    fun api(): Docket {
        return Docket(DocumentationType.SWAGGER_2)
            .select()
            .apis(RequestHandlerSelectors.any())
            .paths(PathSelectors.any())
            .build()
            .apiInfo(ApiInfoBuilder().title("sample server API").build())
            .setGlobalResponseMessage()
    }

    private fun Docket.setGlobalResponseMessage(): Docket {
        val responseMessage = listOf(
            ResponseBuilder().code(HttpStatus.OK.toString()).description("ok!!").build(),
            ResponseBuilder().code(HttpStatus.INTERNAL_SERVER_ERROR.toString()).description("Internal Server Error!!")
                .build(),
            ResponseBuilder().code(HttpStatus.NOT_FOUND.toString()).description("Not Found").build()
        )

        return this
            .globalResponses(HttpMethod.GET, responseMessage)
            .globalResponses(HttpMethod.HEAD, responseMessage)
            .globalResponses(HttpMethod.POST, responseMessage)
            .globalResponses(HttpMethod.PUT, responseMessage)
            .globalResponses(HttpMethod.PATCH, responseMessage)
            .globalResponses(HttpMethod.DELETE, responseMessage)
            .globalResponses(HttpMethod.OPTIONS, responseMessage)
            .globalResponses(HttpMethod.TRACE, responseMessage)
    }
}
