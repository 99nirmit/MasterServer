package com.example.apigateway.config

import org.springframework.cloud.gateway.route.RouteLocator
import org.springframework.cloud.gateway.route.builder.PredicateSpec
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration


@Configuration
class ApiGatewayConfig {
    @Bean
    fun customRouteLocator(builder: RouteLocatorBuilder): RouteLocator? {
        return builder.routes()
            .route(
                "example_route"
            ) { r: PredicateSpec ->
                r
                    .path("/example/**")
                    .uri("http://example.com")
            }
            .route(
                "another_route"
            ) { r: PredicateSpec ->
                r
                    .path("/another/**")
                    .uri("http://another-service.com")
            } // Add more routes as needed
            .build()
    }

    @Bean
    fun securityFilterChain(http: HttpSecurity): SecurityWebFilterChain? {
        http
            .authorizeExchange()
            .pathMatchers("/example/**").authenticated()
            .anyExchange().permitAll()
            .and()
            .httpBasic()
        return http.build()
    }
}