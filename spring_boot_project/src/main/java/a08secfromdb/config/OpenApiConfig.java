package a08secfromdb.config;

import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import org.springframework.context.annotation.Configuration;

@Configuration
@SecurityScheme(
        name = "basicAuth",
        scheme = "bearer",
        type = SecuritySchemeType.HTTP

)
public class OpenApiConfig {
    // This configures Swagger UI to show the Authorize button for JWT tokens.
}
