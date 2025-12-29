// package com.example.demo.config;

// import io.swagger.v3.oas.models.OpenAPI;
// import io.swagger.v3.oas.models.info.Info;
// import io.swagger.v3.oas.models.security.SecurityRequirement;
// import io.swagger.v3.oas.models.security.SecurityScheme;
// import io.swagger.v3.oas.models.servers.Server;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;

// @Configuration
// public class SwaggerConfig {

//     public static final String SECURITY_SCHEME_NAME = "bearerAuth";

//     @Bean
//     public OpenAPI openAPI() {
//         return new OpenAPI()
//                 .info(new Info()
//                         .title("Supply Chain Weak Link Analyzer")
//                         .version("1.0")
//                         .description("JWT-secured Supply Chain Analytics API")
//                 )
//                 // 👇 IMPORTANT: define HTTPS server
//                 .addServersItem(new Server().url("https://9034.pro604cr.amypo.ai"))
//                 .addSecurityItem(new SecurityRequirement().addList(SECURITY_SCHEME_NAME))
//                 .components(
//                         new io.swagger.v3.oas.models.Components()
//                                 .addSecuritySchemes(
//                                         SECURITY_SCHEME_NAME,
//                                         new SecurityScheme()
//                                                 .name(SECURITY_SCHEME_NAME)
//                                                 .type(SecurityScheme.Type.HTTP)
//                                                 .scheme("bearer")
//                                                 .bearerFormat("JWT")
//                                 )
//                 );
//     }
// }

package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            // 1. Disable CSRF (Required for REST APIs and to fix 403 on POST)
            .csrf(csrf -> csrf.disable())

            // 2. Set session management to stateless (Standard for JWT)
            .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))

            // 3. Configure URL permissions
            .authorizeHttpRequests(auth -> auth
                // Allow anyone to access the Auth endpoints (Register/Login)
                .requestMatchers("/auth/**").permitAll()
                
                // Allow access to Swagger UI and API Docs
                .requestMatchers("/v3/api-docs/**", "/swagger-ui/**", "/swagger-ui.html").permitAll()
                
                // All other requests require a valid JWT token
                .anyRequest().authenticated()
            );

        return http.build();
    }
}