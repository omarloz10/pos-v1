package co.com.olozano.api.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    OpenAPI openApiConfig() {
        return new OpenAPI().info(new Info()
                        .title("asdasdasd")
                        .description("asdasdasdasd")
                        .version("1.0")
                        .contact(new Contact()
                                .name("Omar Lozano")));
//                .addSecurityItem(new SecurityRequirement().addList("bearerAuth")) // Requiere este esquema de seguridad
//                .components(new io.swagger.v3.oas.models.Components()
//                        .addSecuritySchemes("bearerAuth", new SecurityScheme()
//                                .name("bearerAuth")
//                                .type(SecurityScheme.Type.HTTP)
//                                .scheme("bearer")
//                                .bearerFormat("JWT")));
    }

}
